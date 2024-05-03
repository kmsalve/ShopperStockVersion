package com.shopper.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopper.qa.base.TestBase;

public class HomePage extends TestBase
{
	//Elements
	//search Element
	@FindBy(xpath = "//input[@id='search']")
	WebElement searchTxt;
	
	@FindBy(xpath = "//*[@name='searchBtn']")
	WebElement searchBtn;
	
	//cart - 	//button[@id="buynow_fl"]
	
	@FindBy(xpath = "//button[@id=\"buynow_fl\"]")
	WebElement cartBtn;
	
	//constructor 
	public  HomePage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//validate logo on Homepage
	
	
	
	//Validate Home Page title
	
	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	
	
	//Search action
	public SearchResultPage searchfromHomePage(String searchCriteria) 
	{
		searchTxt.sendKeys(searchCriteria);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchBtn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new SearchResultPage();
	}
	
	public CartPage clickCart() {
		cartBtn.click();
		return new CartPage();
	}
	
}
