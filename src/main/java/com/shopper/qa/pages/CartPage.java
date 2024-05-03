package com.shopper.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopper.qa.base.TestBase;

public class CartPage extends TestBase
{

	
	// Elelement : cart
	//button[@id="buynow_fl"]
	
	//Buy now
	
	
	@FindBy(xpath = "//span[contains(text(),'Buy Now')]")
	WebElement buyNowBtn;
	
	
	public CartPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions for Elements
	
	public String getUrlOfCartPage()
	{
		return driver.getCurrentUrl();
	}
	
	public AddressPage clickOnBuyNow()
	{
		buyNowBtn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new AddressPage();
	}
}
