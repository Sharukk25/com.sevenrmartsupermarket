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
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement saveButton;
    @FindBy(xpath="//input[@id='main_img']")
    private WebElement imageUpload;
    @FindBy(xpath="//h1[contains(text(),'Add Sub Category')]")
    private WebElement newsubcategoryTitle;
    
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
	public SubCategoryPage enterCategory()
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
	
	public SubCategoryPage createNewSubCategory(String subCategory)
	{
		return this.createNewSubCategory()
		.enterCategory()
		.enterSubCategory(subCategory)
		.uploadImage()
		.clickSaveButton();
	}
	public String getNewSubCategoryCreationTitle()
	{
		return newsubcategoryTitle.getText();
	}
}
