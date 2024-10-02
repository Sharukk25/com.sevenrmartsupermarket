package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.constants.DataProviderClass;
import com.sevenrmartsupermarket.pages.AdminPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminTest extends Base{
	
	LoginPage loginpage;
	AdminPage adminpage;
	HomePage homepage;
	ExcelReader excelreader = new ExcelReader();
	
	@Test
	public void verifyNewAdminCreation()
	{
		loginpage = new LoginPage(driver);
		homepage =loginpage.login();
		adminpage=homepage.clickOnAdminPage();
		String actualProfileName =adminpage.getTableHeader();
		System.out.println(actualProfileName);
		adminpage.clickNewButton();
		adminpage.createNewAdmin("Justin", actualProfileName, actualProfileName);
		String expectedProfileName = "Username" ;
	    Assert.assertEquals(actualProfileName, expectedProfileName);
	}
	
	@Test
	public void excelDataRead()
	{
		excelreader.setExcelFile("LoginData", "AdminData");
		String exceluserName =excelreader.getCellData(1, 0);
		String excelpassword =excelreader.getCellData(1, 1);
		System.out.println(exceluserName+" "+excelpassword);
	}
	
	@Test(dataProvider = "createNewAdmin",dataProviderClass = DataProviderClass.class) 
	public void VerifynewAdminCreation(String userName,String password,String userType)
	{
		loginpage = new LoginPage(driver);
		homepage =loginpage.login();
		adminpage =homepage.clickOnAdminPage();
		String newUser=userName +" "+ GeneralUtility.getRandomName();
		System.out.println(newUser);
		adminpage.createNewAdmin(newUser, password, userType);
		Assert.assertEquals(adminpage.getTextOfFirstElementOfTable(),newUser);
	}	
}
