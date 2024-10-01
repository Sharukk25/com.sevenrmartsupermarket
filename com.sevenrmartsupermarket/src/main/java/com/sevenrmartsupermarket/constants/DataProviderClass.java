package com.sevenrmartsupermarket.constants;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class DataProviderClass {
	
	ExcelReader excelReader = new ExcelReader();

    @DataProvider(name = "login")
    public Object[][] verifylogin() {
    	
    	excelReader.setExcelFile("LoginData", "LoginCredentials");
    	return excelReader.getMultidimentionalData(2, 2);   
    }
    
    @DataProvider(name = "createNewAdmin")
    public Object[][] admincreate() {
    	
    	excelReader.setExcelFile("LoginData", "createNewAdmin");
    	return excelReader.getMultidimentionalData(2, 3);
    }
    
    
}
