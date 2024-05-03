package com.shopper.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopper.qa.base.TestBase;
import com.shopper.qa.pages.AddressPage;
import com.shopper.qa.pages.CartPage;
import com.shopper.qa.pages.HomePage;
import com.shopper.qa.pages.LandingPage;
import com.shopper.qa.pages.PaymentOptionsPage;
import com.shopper.qa.pages.PlaceOrderPage;
import com.shopper.qa.pages.SearchResultPage;
import com.shopper.qa.pages.SignInPage;

public class PaymentOptionsPageTest extends TestBase
{

	//define variables
		LandingPage landingPage;
		SignInPage signInPage;
		HomePage homePage;
		SearchResultPage searchResultPage;
		CartPage cartPage;
		AddressPage addressPage;
		PaymentOptionsPage paymentOptionsPage;
	
		
	//constructor
	public PaymentOptionsPageTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() 
	{
initialization();
		
		landingPage = new LandingPage();
		
		signInPage = landingPage.clickLoginFromLandingPage();
		
		homePage = signInPage.login("kmsalve@gmail.com", "Rohan123@");
		
		searchResultPage = homePage.searchfromHomePage("shirt");
		
		cartPage = searchResultPage.selectSingleProductFromSearchResult();
		
		addressPage = cartPage.clickOnBuyNow();
		
		addressPage.selectAnyAddress();
		
		paymentOptionsPage = addressPage.proceedAfterSelectingAddress();
		
	}
	
	//@Test(priority=1)
	public void verifyPaymentOptionsPageUrl() 
	{
		String actualUrl = paymentOptionsPage.getUrlOfPaymentOptionsPage();
		
		AssertJUnit.assertEquals(actualUrl, "https://www.shoppersstack.com/payment-options");
	}
	
	@Test(priority=1)
	public PlaceOrderPage verifyUserAbleToProceed() 
	{
		
		paymentOptionsPage.selectPaymentOption();
		
		paymentOptionsPage.clickProceedafterSelectingPayment();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new PlaceOrderPage();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
