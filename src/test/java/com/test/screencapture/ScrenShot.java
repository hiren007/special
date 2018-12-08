package com.test.screencapture;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.test.base.TestBase;

public class ScrenShot {
	
	WebDriver driver;
	Date date = new Date() ;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss") ;
    TakesScreenshot ts = (TakesScreenshot) TestBase.driver;
    
    public ScrenShot(WebDriver driver) {
		this.driver = driver;
		ts = (TakesScreenshot) driver;
	}

    public String ReportCapture(WebDriver driver, String filepath) {
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(filepath));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return filepath;
	}
}