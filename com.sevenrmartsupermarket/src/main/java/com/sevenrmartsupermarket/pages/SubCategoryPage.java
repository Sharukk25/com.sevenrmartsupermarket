package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class SubCategoryPage {

	public WebDriver driver;
	PageUtility pageutility;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newSubCatergoryButton;
	@FindBy(xpath="//select[@class='form-control selectpicker']")
	private WebElement categoryField;
	@FindBy(xpath="//input[@id='subcategory']")
    private WebElement subCategoryField;
    @FindBy(xpath="//input[@id='main_img']")
    private WebElement imageUpload;
    @FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement saveButton;
    @FindBy(xpath="//a//p[contains(text(),'Sub Category')]")
    private WebElement sideNavigationSubCategory;
    @FindBy(xpath="//table//td[1]")
	private WebElement FirsttableData;
    
	public SubCategoryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public SubCategoryPage  createNewSubCategory()
	{
		newSubCatergoryButton.click();
		return this;
		
	}
	public SubCategoryPage selectCategory()
	{
		Select select = new Select(categoryField);
		select.selectByIndex(3);
		return this;
	}
	public SubCategoryPage enterSubCategory(String subcategory)
	{
		subCategoryField.sendKeys(subcategory);
		return this;
	}
	
	public SubCategoryPage uploadImage()
	{
		imageUpload.sendKeys(Constants.IMAGE_FILE_PATH);
		return this;
	}
	public SubCategoryPage clickSaveButton()
	{
		pageutility = new PageUtility(driver);
		pageutility.scrollAndClick(saveButton);
		return this;
	}
	
	public void createNewSubCategory(String subCategory)
	{
		createNewSubCategory()
		.selectCategory()
		.enterSubCategory(subCategory)
		.uploadImage()
		.clickSaveButton();
	}
	
	public String getTextOfFirstElementOfTable()
	{
		sideNavigationSubCategory.click();
		return FirsttableData.getText();	 
	}
}
