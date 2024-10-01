package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.constants.DataProviderClass;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
public class LoginTest extends Base {
	
	LoginPage loginpage;
	HomePage homepage;
	
	@Test(groups={"smoke","regression"})
	public void verifyAdminLogin()
	{	
		loginpage= new LoginPage(driver);
		homepage =loginpage.login("Sharu","sharu");  
		String expectedProfileName = "Sharu";
		String actualProfileName = homepage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);	
	}	
	
	@Test(dataProvider = "login",dataProviderClass = DataProviderClass.class) 
	public void verifyDataProviderLogin(String userName ,String password)
	{
		loginpage = new LoginPage(driver);
		loginpage.login(userName,password);	
		String expectedProfile = "Admin";
		String actualProfile=loginpage.getLoginProfileName();
		Assert.assertEquals(actualProfile, expectedProfile);		
	}
}
