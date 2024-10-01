package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.listeners.RetryAnalyzer;
import com.sevenrmartsupermarket.pages.AdminPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class HomeTest extends Base {
	
	HomePage homepage;
	LoginPage loginpage;
	AdminPage adminpage;

	@Test
	public void VerifyHomeProfileName()
	{
		loginpage = new LoginPage(driver);
		homepage=loginpage.login("Akhil","User123");
		homepage.getProfileName();
		Assert.assertEquals(homepage.getProfileName(),"Akhil");
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void VerifyHomeCardNames()
	{
		loginpage = new LoginPage(driver);
		homepage=loginpage.login();
		homepage.getHomeCard();
	}
	
	@Test
	public void verifyAdminPageClick()
	{
		loginpage = new LoginPage(driver);
		homepage =loginpage.login();
		homepage = new HomePage(driver);
		homepage.clickOnAdminPage();
		Assert.assertEquals(homepage.getAdminTitle(),"Admin Users");	
	}
	
	@Test
	public void verifyProductPageClick()
	{
		loginpage = new LoginPage(driver);
		homepage =loginpage.login();
		homepage = new HomePage(driver);
		homepage.clickOnManageProductPage();
		Assert.assertEquals(homepage.getProductTitle(),"List Products");	
	}
	
	@Test
	public void verifyManageContactClick()
	{
		loginpage = new LoginPage(driver);
		homepage =loginpage.login();
		homepage = new HomePage(driver);
		homepage.clickOnManageContactMoreInfo();
		Assert.assertEquals(homepage.getContactTitle(),"Contact Us");
	}
	
	@Test
	public void verifyManageCategoryClick()
	{
		loginpage = new LoginPage(driver);
		homepage =loginpage.login();
		homepage = new HomePage(driver);
		homepage.clickOnCategoryMoreInfo();
		Assert.assertEquals(homepage.getCategoryTitle(),"List Categories");
	}
	
	@Test
	public void verifyManageSubCategoryClick()
	{
		loginpage = new LoginPage(driver);
		homepage =loginpage.login();
		homepage = new HomePage(driver);
		homepage.clickOnSUbCategoryMoreInfo();
		Assert.assertEquals(homepage.getSubCategoryTitle(),"List Sub Categories");
	}
	
	@Test
	public void verifyManageNewsClick()
	{
		loginpage = new LoginPage(driver);
		homepage =loginpage.login();
		homepage.clickOnNewsMoreInfo();
		Assert.assertEquals(homepage.getNewsTitle(),"Manage News");
	}
}
