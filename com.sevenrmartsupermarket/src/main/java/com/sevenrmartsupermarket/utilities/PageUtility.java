package com.sevenrmartsupermarket.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	WebDriver driver;
	JavascriptExecutor js;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	public void jsScrollIntoView(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void jsClick(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void mouseClick(WebElement element) {
		Actions action = new Actions(driver);
		action.click(element).build().perform();
	}

	public void mouseDoubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	public void mouseRightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();	}

	public String getAlertText() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void scrollAndClick(WebElement element) {
		int index = 0;
		while (!isClicked(element)) {
			js.executeScript("window.scrollBy(0," + index + ")"); 
			index = index + 3;
		}

	}

	public boolean isClicked(WebElement element) {
		try {
			element.click();
			return true; 
		} catch (Exception e) {
			return false;
		}
	}
}
