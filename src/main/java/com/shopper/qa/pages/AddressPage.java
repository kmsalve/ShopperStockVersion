package com.shopper.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopper.qa.base.TestBase;

public class AddressPage extends TestBase
{
	////*[@id="20143"]
	
	
	@FindBy(xpath = "//input[@type='radio' and @name='address']")
	WebElement addressListRadio;
	
	//proceed
	
	//*[@id="root"]/div[4]/div[3]/button
	
	@FindBy(xpath = "//button[contains(text(), 'Proceed')]")
	WebElement proceedBtn;
	
	//constructor 
	public  AddressPage() 
	{
		PageFactory.initElements(driver, this);
	}

	public String getUrlOfAddressPage() {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}
		
	public void selectAnyAddress() {
		addressListRadio.click();
	}
	
	public PaymentOptionsPage proceedAfterSelectingAddress() 
	{
		proceedBtn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new PaymentOptionsPage();
	}
	
		
}
