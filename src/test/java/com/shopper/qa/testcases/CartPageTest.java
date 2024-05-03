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
import com.shopper.qa.pages.SearchResultPage;
import com.shopper.qa.pages.SignInPage;

public class CartPageTest extends TestBase
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
	}

	public CartPageTest() {
		super();
	}
	
	@Test(priority=1)
	public void verifyBuyingOfSelectedProduct() 
	{
		addressPage = cartPage.clickOnBuyNow();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AssertJUnit.assertEquals(addressPage.getUrlOfAddressPage(), "https://www.shoppersstack.com/selectaddress");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
