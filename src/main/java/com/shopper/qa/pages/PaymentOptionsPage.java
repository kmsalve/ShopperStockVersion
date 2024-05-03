package com.shopper.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopper.qa.base.TestBase;

public class PaymentOptionsPage extends TestBase
{

	//Radio button element
	
	@FindBy(xpath = "//input[@type='radio' and @value ='COD']")
	WebElement codPaymentRd;
	
	//Add Card button
	
	@FindBy(xpath = "//button[contains(text(),'Proceed')]")
	WebElement proceedBtn;
	
	//constructor 
	public  PaymentOptionsPage() 
	{
		PageFactory.initElements(driver, this);
	}

	public String getUrlOfPaymentOptionsPage() 
	{
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}	
	public void selectPaymentOption() 
	{
		codPaymentRd.click();
	}
	public PlaceOrderPage clickProceedafterSelectingPayment() 
	{
		proceedBtn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
		return new PlaceOrderPage();
	}	
}
