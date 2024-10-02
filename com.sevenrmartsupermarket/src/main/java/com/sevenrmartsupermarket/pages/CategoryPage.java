package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class CategoryPage {
	
	public WebDriver driver;
	PageUtility pageutility;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement createNewProductButton;
	@FindBy(xpath="//input[@id='category']")
	private WebElement categoryField; 
	@FindBy(xpath="//li[@id='134-selectable']")
	private WebElement selectGroup;
	@FindBy(xpath="//input[@id='main_img']")
	private WebElement chooseFile;
	@FindBy(xpath="(//input[@type='radio'])[1]")
	private WebElement showTopRadioButtonOne;
	@FindBy(xpath="(//input[@type='radio'])[2]")
	private WebElement showTopRadioButtonTwo;
	@FindBy(xpath="(//input[@type='radio'])[3]")
	private WebElement showLeftRadioButtonOne;
	@FindBy(xpath="(//input[@type='radio'])[4]")
	private WebElement showLeftRadioButtonTwo;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement saveButton; 
//	@FindBy(xpath ="//h1[contains(text(),'List Categories')]")
//	private WebElement categoryPagetitle;
	@FindBy(xpath ="//h1[contains(text(),'Add Category')]")
	private WebElement categoryPageCreationtitle;
	
	public CategoryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void clickProductNewButton()
	{
		createNewProductButton.click();
	}
	
	public void enterCategory(String category)
	{
		categoryField.sendKeys(category);
	}
	
	public void clickSelectGroup()
	{
		selectGroup.click();
	}
	
	public void selectImageFile()
	{
	
		chooseFile.sendKeys(Constants.IMAGE_FILE_PATH);
	
	}
	
	public void selectTopRadioButton()
	{
		pageutility = new PageUtility(driver);
		boolean radioselect1 = showTopRadioButtonOne.isSelected();
		System.out.println("First radio button  selected?:" +radioselect1);
		boolean radioselect2 = showTopRadioButtonTwo.isSelected();
		System.out.println("First radio button  selected?:" +radioselect2);
		if(radioselect1==false)
		{
			pageutility.scrollAndClick(showTopRadioButtonOne);
		}
		else
		{
			pageutility.scrollAndClick(showTopRadioButtonTwo);
		}
		
	}
	
	public void selectLeftRadioButton()
	{
		pageutility = new PageUtility(driver);
		boolean radioselect1 = showLeftRadioButtonOne.isSelected();
		System.out.println("First radio button  selected?:" +radioselect1);
		boolean radioselect2 = showLeftRadioButtonTwo.isSelected();
		System.out.println("First radio button  selected?:" +radioselect2);
		if(radioselect1==false)
		{
			
			pageutility.scrollAndClick(showLeftRadioButtonOne);
		}
		else
		{
			pageutility.scrollAndClick(showLeftRadioButtonTwo);
			
		}
		
	}
	
	public void clickSave()
	{
		pageutility = new PageUtility(driver);
		pageutility.scrollAndClick(saveButton);
	}
	
	public void createNewCategory(String productName)
	{
		clickProductNewButton();
		enterCategory(productName);
		clickSelectGroup();
		selectImageFile();
		selectTopRadioButton();
		selectLeftRadioButton();
		clickSave();
	}
	
	public String getCategoryPageTitle()
	{
		return categoryPageCreationtitle.getText();
	}
	
	
}
