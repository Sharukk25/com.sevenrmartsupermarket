package com.sevenrmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {

	public String get_Attribute(WebElement element,String attribute)
	{
		return element.getAttribute(attribute);   
	}
	
	public String get_CssValue(WebElement element,String cssproperty)
	{
		return element.getCssValue(cssproperty);    
	}
	
	public String get_logoColor(WebElement element,String csscolor)
	{
		return element.getCssValue(csscolor);
	}
	public List<String> get_Text_Of_Elements(List<WebElement> elementsList)  
	{
		List<String> data=new ArrayList<String>();
		for(WebElement element :elementsList)
		{
			data.add(element.getText());
		}
		return data;
	}
	
	public static String getRandomName()
	{
		Faker faker= new Faker();
		return faker.name().firstName();	
	}
	
}
