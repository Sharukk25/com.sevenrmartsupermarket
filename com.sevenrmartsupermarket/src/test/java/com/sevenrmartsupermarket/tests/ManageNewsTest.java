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
		Assert.assertEquals(managenewspage.getNewsTitle(),"Enter News Informations");
	}
	
	@Test
	public void verifyDeletionOfNews()
	{
		loginpage = new LoginPage(driver);
		homepage =loginpage.login();
		managenewspage = new ManageNewsPage(driver);
		managenewspage =homepage.clickOnNewsMoreInfo();	
		managenewspage.deleteNews();
		Assert.assertEquals(managenewspage.deleteAlert(),"Manage News");
	}
}
