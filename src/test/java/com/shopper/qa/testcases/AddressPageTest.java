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
import com.shopper.qa.pages.SearchResultPage;
import com.shopper.qa.pages.SignInPage;

public class AddressPageTest  extends TestBase
{

	//define variables
	LandingPage landingPage;
	SignInPage signInPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	CartPage cartPage;
	AddressPage addressPage;
	
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
	}

	public AddressPageTest() {
		super();
	}
	
	//@Test(priority=1)
	public void verifyAddressPageUrl() 
	{
		AssertJUnit.assertEquals(addressPage.getUrlOfAddressPage(), "https://www.shoppersstack.com/selectaddress");
	}
	
	@Test(priority=1)
	public PaymentOptionsPage verifyProceedToNextAfterSelectingAddress() 
	{
		addressPage.selectAnyAddress();
		addressPage.proceedAfterSelectingAddress();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new PaymentOptionsPage();
	}
	
	//getUrlOfAddressPage
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
