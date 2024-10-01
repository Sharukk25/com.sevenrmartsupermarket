package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class LoginPage {

	WebDriver driver;
	WaitUtility wait = new WaitUtility();
	Properties properties = new  Properties();
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;    

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	private WebElement signInButton;
	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement loginProfile;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {       	//imp
			
			 FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			 properties.load(ip);   
			 
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public HomePage login()
	{
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickOnsigninButton();
		return new HomePage(driver); 
		
	}

	public void enterUserName(String userName) {   
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnsigninButton() {
		wait.waitForElementToBeClickable(driver, signInButton, 10);
		signInButton.click();
	
	}
 
	public HomePage login(String userName,String password)   
	{
		enterUserName(userName);
		enterPassword(password);
		clickOnsigninButton();
		return new HomePage(driver); 
	}
	
	public String getLoginProfileName()
	{
		return loginProfile.getText();
	}
}
