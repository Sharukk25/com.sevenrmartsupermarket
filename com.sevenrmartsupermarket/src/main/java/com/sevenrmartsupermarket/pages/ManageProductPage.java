package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageProductPage {
	
	WebDriver driver;
	GeneralUtility utility = new GeneralUtility();
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath="//table//th")
	private List<WebElement> tableHeader; 
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath="//input[@class='form-control'][1]")
	private WebElement producttTitle; 
    @FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
    private WebElement clickSearch;
	
	public ManageProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<String> getTableHeader() 
    {
		List<String> tableHeaderData = new ArrayList<String>();
		tableHeaderData = utility.get_Text_Of_Elements(tableHeader);
		System.out.println("Size: " + tableHeaderData.size());
		System.out.println("Card Names" + tableHeaderData);
		return tableHeaderData;
	}
	
	public ManageProductPage clickOnProductSearchButton()
	{
		searchButton.click();
		return this;
	}
	
	public ManageProductPage enterProductTitle(String title)
	{
		producttTitle.sendKeys(title);
		return this;
	}
	
	public ManageProductPage clickSearch()
	{
		clickSearch.click();
		return this;
	}
	
	public String getProductTitle()
	{
		return producttTitle.getAttribute("value");
	}
}
	


