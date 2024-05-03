package com.shopper.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopper.qa.base.TestBase;

public class SearchResultPage extends TestBase
{
	//Elements
	
	
	//Element - locator of first product from search result
	
	@FindBy(xpath = "//button[contains(text(),'add to cart')]")
	WebElement allProductsfromSearchResult;
	
	//Cart icon
	@FindBy(xpath = "//*[@id= 'cartIcon']")
	WebElement cartIcon;
	
	//Constructor to intitialize
	
	public SearchResultPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions for Elements
	public String getUrlOfResultPage()
	{
		return driver.getCurrentUrl();
	}
	
	//
	public CartPage selectSingleProductFromSearchResult()
	{
		allProductsfromSearchResult.click();
		cartIcon.click();
		return new CartPage();
	}
}
