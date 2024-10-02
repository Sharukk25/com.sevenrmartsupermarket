package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.SubCategoryPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class SubCategoryTest extends Base
{
	HomePage homepage;
	LoginPage loginpage;
	SubCategoryPage subcategorypage;

@Test	
	public void verifyNewSubCategoryCreation()
	{
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		subcategorypage=homepage.clickOnSUbCategoryMoreInfo();
		String subname = GeneralUtility.getRandomName();
        subcategorypage.createNewSubCategory(subname);
        String actualName =subcategorypage.getTextOfFirstElementOfTable();
        Assert.assertEquals(actualName,subname); 
	}
}
