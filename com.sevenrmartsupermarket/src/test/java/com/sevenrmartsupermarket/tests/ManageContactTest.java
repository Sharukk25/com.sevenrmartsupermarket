package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageContactPages;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageContactTest extends Base{

	LoginPage loginpage;
	HomePage homepage;
	ManageContactPages managecontactpage;
	
	@Test(groups = "Smoke")
	public void verifyManageContactEditData()
	{
		loginpage = new LoginPage(driver);
		homepage =loginpage.login();
		managecontactpage =homepage.clickOnManageContactMoreInfo();	
		String categoryName =GeneralUtility.getRandomName();
		managecontactpage.editContactDetail(categoryName);
		String updatedContactName = managecontactpage.getTextOfFirstElementOfTable();
		 Assert.assertEquals(updatedContactName, categoryName);
	}
}
