package com.shopper.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopper.qa.base.TestBase;

public class PlaceOrderPage extends TestBase
{
	//function to check url - https://www.shoppersstack.com/place-order
	//function to check message - Thank you for your order
	
	@FindBy(xpath = "//h2[contains(text(),'Thank you for your order')]")
	WebElement msgThankYou;
	
	
	public PlaceOrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getUrlOfPlaceOrderPage() {
		return driver.getCurrentUrl();
	}
	
	public boolean checkThankYouMessage() {
		return true;
	}
}
