package com.sevenrmartsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;
import com.sevenrmartsupermarket.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	Properties properties = new Properties(); 
	ScreenshotCapture screenshot = new ScreenshotCapture();

	public Base() {
		try { 

			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip); 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initialize(String browser, String url) 
	{
		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT)); 
	}

	@Parameters("browser") 
	@BeforeMethod(enabled=false,alwaysRun = true)
	public void initliazeBrowser(String browser) 
	{

		String url = properties.getProperty("url");
		initialize(browser, url); 
	}
	@BeforeMethod(enabled = true,alwaysRun = true)
	public void initliazeBrowser()  
	{
		String browser = properties.getProperty("browser");  
		String url = properties.getProperty("url"); 
		initialize(browser, url);  
	}
	@AfterMethod(alwaysRun = true)
	public void WindowTerminate(ITestResult itestresult) 
	{
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			screenshot.takeScreenShot(driver, itestresult.getName());
		}
		driver.quit();
	}

}
