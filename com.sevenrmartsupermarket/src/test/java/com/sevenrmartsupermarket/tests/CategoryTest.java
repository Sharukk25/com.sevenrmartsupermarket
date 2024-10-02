package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.CategoryPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class CategoryTest extends Base{

	LoginPage loginpage;
	HomePage homepage;
	CategoryPage categorypage;
	
	@Test
	public void verifyNewCategoryCreation()
	{
		loginpage = new LoginPage(driver);
		homepage =loginpage.login();
		categorypage =homepage.clickOnCategoryMoreInfo();
		String category = GeneralUtility.getRandomName();
		categorypage.createNewCategory(category);
		String actualName =categorypage.getTextOfFirstElementOfTable();
        Assert.assertEquals(actualName,category);
	}
}
