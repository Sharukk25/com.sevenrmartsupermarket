package com.sevenrmartsupermarket.tests;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageProductPage;

public class ManageProductTest extends Base {

	ManageProductPage manageproduct;
	LoginPage loginpage;
	HomePage homepage;

	@Test(groups = "Smoke")
	public void verifyTableHeader() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		manageproduct = homepage.clickOnManageProductPage();
		manageproduct.getTableHeader();
		List<String> actualHeaders = manageproduct.getTableHeader();
		List<String> expectedHeaders = new ArrayList<>();
		expectedHeaders.add("Title");
		expectedHeaders.add("Product Type");
		expectedHeaders.add("Category");
		expectedHeaders.add("Image");
		expectedHeaders.add("Min - Max Qty");
		expectedHeaders.add("Stock");
		expectedHeaders.add("Status");
		expectedHeaders.add("Featured");
		expectedHeaders.add("Action");
		Assert.assertEquals(actualHeaders, expectedHeaders);
	}

	@Test
	public void verifyProductSearch() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		manageproduct = homepage.clickOnManageProductPage();
		manageproduct.clickOnProductSearchButton().enterProductTitle("Carrot").clickOnProductSearchButton();
		String actualProduct = manageproduct.getProductTitle();
		System.out.println("Searching for product " + actualProduct);
		Assert.assertEquals(actualProduct, "Carrot");
	}
}
