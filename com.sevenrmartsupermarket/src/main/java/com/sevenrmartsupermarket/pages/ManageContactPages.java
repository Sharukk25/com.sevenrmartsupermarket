package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageContactPages {
	
	WebDriver driver;
	PageUtility pageutility;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	private WebElement EditButton;
	@FindBy(xpath="//textarea[@id='content']")
	private WebElement addressField;
	@FindBy(xpath="//button[@name='Update']")
	private WebElement updateButton;
	
	public ManageContactPages(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickEditButton()
	{
		pageutility = new PageUtility(driver);
		pageutility.scrollAndClick(EditButton);
	}
	
	public void upadteNewAddress(String address)
	{
		addressField.clear();
		addressField.sendKeys(address);
	}
	
	public void clickUpdate()
	{
		pageutility = new PageUtility(driver);
		pageutility.scrollAndClick(updateButton);
	}
	
	public void editContactDetail(String address)
	{
		clickEditButton();
		upadteNewAddress(address);
		clickUpdate();
	}
	

}
