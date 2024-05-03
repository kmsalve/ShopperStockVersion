package com.shopper.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class PlaceOrderPageTest extends TestBase{

	//define variables
		LandingPage landingPage;
		SignInPage signInPage;
		HomePage homePage;
		SearchResultPage searchResultPage;
		CartPage cartPage;
		AddressPage addressPage;
		PaymentOptionsPage paymentOptionsPage;
		PlaceOrderPage placeOrderPage;
		
		Logger log = LogManager.getLogger(PlaceOrderPageTest.class.getName());
		
	//constructor
	public PlaceOrderPageTest() 
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
		
		paymentOptionsPage.selectPaymentOption();
		
		placeOrderPage = paymentOptionsPage.clickProceedafterSelectingPayment();	
		
	}
	
	//@Test(priority=1)
	public void verifyOrderPageUrl() 
	{
		String actualUrl = placeOrderPage.getUrlOfPlaceOrderPage();
		
		AssertJUnit.assertEquals(actualUrl, "https://www.shoppersstack.com/payment-options");
	}
	
	@Test(priority=1)
	public void verifyOrderConfimation() 
	{
		log.info("Info");
		log.debug("debug");
		log.fatal("fatal");
		log.error("error");
		log.warn("warn");

		AssertJUnit.assertTrue(placeOrderPage.checkThankYouMessage());	
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
