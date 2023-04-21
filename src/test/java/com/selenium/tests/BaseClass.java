package com.selenium.tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.selenium.pages.BasePage;
import com.selenium.utilities.ReadConfig;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait wait;
	static Logger logger = LogManager.getLogger(BaseClass.class.getName());
	BasePage basepage;

	 ReadConfig readconfig = new ReadConfig();

	public  String url = readconfig.getUrl();
	public  String browser = readconfig.getBrowserName();
	public  String username = readconfig.getUsername();
	public  String password = readconfig.getPassword();

	@BeforeClass
	public void setup(ITestContext context) {
		
		// driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		logger.info("launching browser");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));

	}

	@AfterMethod
	public void checkstatus(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			String pathString = screenShot(driver, result.getName());

			logger.info("Screenshot captured");

		}

	}

	@AfterClass
	public void tearDown() {
		//driver.close();
		logger.info("closing browser");
	}

	public String screenShot(WebDriver driver, String filename) {

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + ".png";

		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return destination;
	}
}
