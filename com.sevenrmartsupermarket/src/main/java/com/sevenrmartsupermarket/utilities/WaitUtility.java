package com.sevenrmartsupermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	public WebDriver driver;
	public static final long IMPLICIT_WAIT = 10;
	WebDriverWait wait;
	
	public void waitForElementToBeClickable(WebDriver driver,WebElement element,long time) 
	{
		wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForVisibilityOfTheElement(WebDriver driver,String xpath,long time)
	{
		wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void waitForInVisibility(WebDriver driver,String xpath,long time)
	{
		wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}
}
