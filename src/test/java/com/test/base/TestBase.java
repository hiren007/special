package com.test.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.test.excelreader.ExcelFileReader;
import com.test.pages.Dashboard;
import com.test.pages.ForgotPasswordPage;
import com.test.pages.HomePage;
import com.test.pages.PlanSelectPage;
import com.test.pages.SignUpPage;
import com.test.screencapture.ScrenShot;
import com.test.scroll.ScrollHelper;

public class TestBase {

	public static WebDriver driver;
	public static WebElement element;
	public static WebDriverWait wait;
	public static HomePage homepage;
	public static PlanSelectPage planselectpage;
	public static SignUpPage signuppage;
	public static Dashboard dashboard;
	public static ForgotPasswordPage forgotpassword;
	public static ExcelFileReader excel;
	public static ScrenShot screnshot;
	public static ScrollHelper scroll;

	public static Date date = new Date();
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    public static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
    public String destDir = System.getProperty("user.dir") + "/TestReports/"+ dateFormat.format(date) +"/Report_" + dateTimeFormat.format(date);
	public String finaldestDir;
    public String screenFaildir;
	public String screenSkipdir;
	public String screenPassdir;

	public static HashMap<String,WebDriver> drivers = new HashMap<>();
	public static HashMap<String,ExtentReports> extentReports = new HashMap<>();
	public static HashMap<String,String> destDirs = new HashMap<>();

	private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	private static List<Status> statusHierarchy = Arrays.asList(
			Status.FATAL,
			Status.FAIL,
			Status.ERROR,
			Status.WARNING,
			Status.SKIP,
			Status.PASS,
			Status.DEBUG,
			Status.INFO
	);

	public void pageObjectInitilizer(WebDriver driver) throws IOException {
		wait = new WebDriverWait(driver, 10);
		homepage = new HomePage(driver);
		planselectpage = new PlanSelectPage(driver);
		signuppage = new SignUpPage(driver);
		forgotpassword = new ForgotPasswordPage(driver);
		dashboard = new Dashboard(driver);
		excel = new ExcelFileReader();
		screnshot = new ScrenShot(driver);
		scroll = new ScrollHelper(driver);
	}

	@Parameters({"browser","test"})
	@BeforeTest
	public void setUp(String browser,String test) throws IOException {
		
		WebDriver driver = null;
		String finaldestDir = null;
		
		System.setProperty("webdriver.gecko.driver",".\\Resource\\windows\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver",".\\Resource\\windows\\chromedriver.exe");
		if(browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
			drivers.put(browser,driver);
			finaldestDir = destDir + "/" + test;
			destDirs.put(browser,finaldestDir);
			System.out.println("@BeforeTest Running Test with "+test);
		} else if(browser.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
			drivers.put(browser,driver);
			finaldestDir = destDir + "/" + test;
			destDirs.put(browser,finaldestDir);
			System.out.println("@BeforeTest Running Test with "+test);
		} else {
			System.out.println("@BeforeTest Browser Not Found");
			System.exit(0);
		}


		screenFaildir = finaldestDir + "/Screens/FAIL";
		screenSkipdir = finaldestDir + "/Screens/SKIP";
		screenPassdir = finaldestDir + "/Screens/PASS";

		new File(finaldestDir).mkdirs();
		new File(screenFaildir).mkdirs();
		new File(screenSkipdir).mkdirs();
		new File(screenPassdir).mkdirs();

		ExtentReports extent = new ExtentReports();
		extent.setSystemInfo("OS", "Windows 8.1");
		extent.setSystemInfo("Browser", browser);
		extent.setSystemInfo("Host Name", "Sitewon");
		extent.setSystemInfo("Environment", "QA Test");
		extent.setSystemInfo("Tester Name", "Hiren Gajera");

		extent.config().statusConfigurator().setStatusHierarchy(statusHierarchy);
		System.out.println("@BeforeTest Browser"+browser+" "+extent );
		

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(finaldestDir + "/ST_" + dateTimeFormat.format(date) + ".html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		extent.attachReporter(htmlReporter);
		
		extentReports.put(browser,extent);
		
		driver.manage().deleteAllCookies();
		driver.get("https://sitewon-portal-development.azurewebsites.net/customer/login");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("driver (setup) - " + driver);

		pageObjectInitilizer(driver);
	}

	@BeforeClass
		public void beforeClass(ITestContext context) {
			String browser = context.getCurrentXmlTest().getParameter("browser");
			if(browser.equalsIgnoreCase("firefox")){
				driver = drivers.get(browser);
				finaldestDir = destDirs.get(browser);
				System.out.println("@BeforeClass Running Test with Firefox Browser");
			} else if(browser.equalsIgnoreCase("chrome")){
				driver = drivers.get(browser);
				finaldestDir = destDirs.get(browser);
				System.out.println("@BeforeClass Running Test with Chrome Browser");
			} else {
				System.out.println("@BeforeClass Browser Not Found");
				System.exit(0);
			}

			screenFaildir = finaldestDir + "/Screens/FAIL";
			screenSkipdir = finaldestDir + "/Screens/SKIP";
			screenPassdir = finaldestDir + "/Screens/PASS";
			ExtentReports extent = extentReports.get(browser);
			System.out.println("@BeforeClass Browser"+browser+" "+extent );
			ExtentTest parent = extent.createTest(getClass().getSimpleName());
			parentTest.set(parent);
			parentTest.get().log(Status.INFO, "Running on "+browser);
	}

	@BeforeMethod
	public synchronized void beforeMethod(Method method) {
		ExtentTest child = parentTest.get().createNode(method.getName());
		test.set(child);
	}

	@AfterMethod
	public void afterMethod(ITestResult result, ITestContext context) throws IOException {

		String screenFailPath = screenFaildir + "/" + result.getMethod().getMethodName() + ".png";
		String screenSkipPath = screenSkipdir + "/" + result.getMethod().getMethodName() + ".png";
		String screenPassPath = screenPassdir + "/" + result.getMethod().getMethodName() + ".png";


		if (result.getStatus() == ITestResult.FAILURE) {
			screnshot.ReportCapture(drivers.get(context.getCurrentXmlTest().getParameter("browser")), screenFailPath);
			test.get().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenFailPath,result.getMethod().getMethodName()).build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			screnshot.ReportCapture(drivers.get(context.getCurrentXmlTest().getParameter("browser")), screenSkipPath);
			test.get().skip(result.getThrowable(),  MediaEntityBuilder.createScreenCaptureFromPath(screenSkipPath,result.getMethod().getMethodName()).build());
		} else {
			screnshot.ReportCapture(drivers.get(context.getCurrentXmlTest().getParameter("browser")), screenPassPath);
			test.get().pass("Passed",  MediaEntityBuilder.createScreenCaptureFromPath(screenPassPath,result.getMethod().getMethodName()).build());
		}
		extentReports.get(context.getCurrentXmlTest().getParameter("browser")).flush();
	}

	@AfterTest
	public void tearDown(ITestContext context) {
		drivers.get(context.getCurrentXmlTest().getParameter("browser")).quit();
	}
}