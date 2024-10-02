package com.sevenrmartsupermarket.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class ManageNewsPage {

	WebDriver driver;
	PageUtility pageutility;
	WaitUtility wait;
	
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newsCreateButton;
	@FindBy(xpath="//textarea[@id='news']")
	private WebElement newsTextarea;
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveButton;
	@FindBy(xpath="//i[@class='fas fa-trash-alt']")
	private WebElement newsDeleteButton;
	@FindBy(xpath="//table//tr")
	private List<WebElement> newsTable;
	@FindBy(xpath="//h3[contains(text(),'Enter News Informations')]")
	private WebElement manageNewsTitle;
	@FindBy(xpath="//table//tr[1]//td[2]//i[@class='fas fa-trash-alt']")
	private WebElement deleteData;
	@FindBy(xpath="//a//p[contains(text(),'Manage News')]")
    private WebElement sideNavigationManageNews;
    @FindBy(xpath="//table//td[1]")
	private WebElement FirsttableData;
    @FindBy(xpath="//table//tr[2]//td[1]")
	private WebElement secondtableElementBefore;
    @FindBy(xpath="//table//td[1]")
	private WebElement secondtableElementAfter;
  
	
	public ManageNewsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getNewsTitle()
	{
		return manageNewsTitle.getText();
	}
	
	public ManageNewsPage clickCreateNewsButton()
	{
		pageutility = new PageUtility(driver);
		pageutility.scrollAndClick(newsCreateButton);
		return this;
	}

	public ManageNewsPage enterNewNews(String news)
	{
		newsTextarea.sendKeys(news);
		return this;
	}
	
	public ManageNewsPage clickSave()
	{
		pageutility = new PageUtility(driver);
		pageutility.scrollAndClick(saveButton);	
		return this;
	}
	
	public ManageNewsPage createNews(String news)
	{
		return this.clickCreateNewsButton()
		.enterNewNews(news)
		.clickSave();		 
	}
	
	public void deleteNews()
	{
		pageutility=new PageUtility(driver);
		WaitUtility wait = new WaitUtility();
		wait.waitForElementToBeClickable(driver, deleteData, 10);
		deleteData.click();
		pageutility.acceptAlert();
	}
	
	public String getTextOfFirstElementOfTable()
	{
		sideNavigationManageNews.click();
		return FirsttableData.getText();	 
	}
	
	public String getTextOfSecondElementBeforeDeletion()
	{
		sideNavigationManageNews.click();
		return secondtableElementBefore.getText();	 
	}
	
	public String getTextOfSecondElementAfterDeletion()
	{
		sideNavigationManageNews.click();
		return FirsttableData.getText();	 
	}
}
