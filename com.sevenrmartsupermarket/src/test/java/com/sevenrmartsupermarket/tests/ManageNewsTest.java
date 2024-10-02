package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageNewsPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageNewsTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	ManageNewsPage managenewspage;
	
	@Test
	public void verifyNewsPageCreation()
	{
		loginpage = new LoginPage(driver);
		homepage =loginpage.login();
		managenewspage =homepage.clickOnNewsMoreInfo();	
		String news = GeneralUtility.getRandomName();
		managenewspage.createNews(news);
		String actualName =managenewspage.getTextOfFirstElementOfTable();
	    Assert.assertEquals(actualName,news);
		
	}
	
	@Test
	public void verifyDeletionOfNews()
	{
		loginpage = new LoginPage(driver);
		homepage =loginpage.login();
		managenewspage = new ManageNewsPage(driver);
		managenewspage =homepage.clickOnNewsMoreInfo();
		String secondElementBefore = managenewspage.getTextOfSecondElementBeforeDeletion();
		managenewspage.deleteNews();
		String secondElementAfter = managenewspage.getTextOfSecondElementAfterDeletion();
		Assert.assertEquals(secondElementAfter,secondElementBefore);
	}
}
