package com.sevenrmartsupermarket.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class AdminPage {

	WebDriver driver;
	WaitUtility wait = new WaitUtility();

	@FindBy(xpath = "//table//th[1]")
	private WebElement tableheader;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypeDropDown;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
	private List<WebElement> tabledata;
	@FindBy(xpath="//table//td[1]")
	private WebElement FirsttableData;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getTableHeader() {

		return tableheader.getText();
	}

	public AdminPage clickNewButton() {
		newButton.click();
		return this;
	}

	public AdminPage enterUserName(String userName) {
		userNameField.sendKeys(userName);
		return this;
	}

	public AdminPage enterPassword(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	public AdminPage selectUserType(String userType) {
		Select select = new Select(userTypeDropDown);
		select.selectByIndex(2);
		return this;
	}

	public AdminPage clickSave() {
		wait.waitForElementToBeClickable(driver, saveButton, 10);
		saveButton.click();
		return this;
	}

	public AdminPage createNewAdmin(String userName, String password, String userType) {
		return this.clickNewButton()
		.enterUserName(userName)
		.enterPassword(password)
		.selectUserType(userType)
		.clickSave();
	}
	
	public String getTextOfFirstElementOfTable()
	{
		return FirsttableData.getText();
	}
}
