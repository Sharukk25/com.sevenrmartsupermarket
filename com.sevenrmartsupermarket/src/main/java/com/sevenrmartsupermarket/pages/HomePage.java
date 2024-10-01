package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sevenrmartsupermarket.utilities.GeneralUtility;


public class HomePage {

	WebDriver driver;
	GeneralUtility utility = new GeneralUtility();
	@FindBy(xpath ="//div[@class='user-panel mt-3 pb-3 mb-3 d-flex']//div//a")
	private WebElement adminProfile;
	@FindBy(xpath="//h1[contains(text(),'Admin Users')]")
	private WebElement adminTitle;
	@FindBy(xpath ="//div[@class='user-panel mt-3 pb-3 mb-3 d-flex']//div//a")
	private WebElement homepageProfileName;
	@FindBy(xpath="//div[@class='inner']//p")
	private List<WebElement> homeCard;
	@FindBy(xpath = "//div[contains(@class, 'col-lg-3 col-6')][1]//following-sibling::a")
	private WebElement adminMoreInfo;
	@FindBy(xpath = "//div[contains(@class, 'col-lg-3 col-6')][8]//following-sibling::a")
	private WebElement manageProductMoreInfo;
	@FindBy(xpath="//h1[contains(text(),'List Products')]")
	private WebElement productTitle;
	@FindBy(xpath = "//div[contains(@class, 'col-lg-3 col-6')][3]//following-sibling::a")
	private WebElement categoryMoreInfo;
	@FindBy(xpath="//h1[contains(text(),'List Categories')]")
	private WebElement categoryTitle;
	@FindBy(xpath = "//div[contains(@class, 'col-lg-3 col-6')][4]//following-sibling::a")
	private WebElement subCategoryMoreInfo;
	@FindBy(xpath="//h1[contains(text(),'List Sub Categories')]")
	private WebElement subCategoryTitle;
	@FindBy(xpath="//div[contains(@class, 'col-lg-3 col-6')][5]//following-sibling::a")
	private WebElement manageContactMoreInfo;
	@FindBy(xpath="//h1[contains(text(),'Contact Us')]")
	private WebElement contactTitle;
	@FindBy(xpath="//div[contains(@class, 'col-lg-3 col-6')][9]//following-sibling::a")
	private WebElement manageNewsMoreInfo; 
	@FindBy(xpath="//h1[contains(text(),'Manage News')]")
	private WebElement manageNewsTitle;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProfileName()
	{
		return homepageProfileName.getText();
	}
	
	public AdminPage clickOnAdminPage()  
	{
		adminMoreInfo.click();
		return new AdminPage(driver);
	}
	public String getAdminTitle()   
	{
		return adminTitle.getText();
	}
	
	public ManageProductPage clickOnManageProductPage()   
	{
		manageProductMoreInfo.click();
		return new ManageProductPage(driver);
	}
	public String getProductTitle()   
	{
		return productTitle.getText();
	}
	
	public ManageContactPages clickOnManageContactMoreInfo()   
	{
		manageContactMoreInfo.click();
		return new ManageContactPages(driver);
	}
	public String getContactTitle()   
	{
		return contactTitle.getText();
	}
	
	
	public SubCategoryPage clickOnSUbCategoryMoreInfo()
	{
		subCategoryMoreInfo.click();
		return new SubCategoryPage(driver);
	}
	
	public String getSubCategoryTitle()   
	{
		return subCategoryTitle.getText();
	}
	public CategoryPage clickOnCategoryMoreInfo()
	{
		categoryMoreInfo.click();
		return new CategoryPage(driver);
	}
	public String getCategoryTitle()   
	{
		return categoryTitle.getText();
	}
	
	public ManageNewsPage clickOnNewsMoreInfo()
	{
		manageNewsMoreInfo.click();
		return new ManageNewsPage(driver);
	}
	public String getNewsTitle()   
	{
		return manageNewsTitle.getText();
	}
	public void getHomeCard() 
    {
		List<String> cardName = new ArrayList<String>();
		cardName = utility.get_Text_Of_Elements(homeCard);
		System.out.println("Size: " + cardName.size());
		System.out.println("Card Names" + cardName);
	}	
}

