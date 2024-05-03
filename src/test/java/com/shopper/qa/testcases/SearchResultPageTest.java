package com.shopper.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;

import com.shopper.qa.base.TestBase;
import com.shopper.qa.pages.CartPage;
import com.shopper.qa.pages.HomePage;
import com.shopper.qa.pages.LandingPage;
import com.shopper.qa.pages.SearchResultPage;
import com.shopper.qa.pages.SignInPage;

public class SearchResultPageTest extends TestBase
{
	
	//define variables
	LandingPage landingPage;
	SignInPage signInPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	CartPage cartPage;
	
	//Logger log = LogManager.getLogger(PlaceOrderPageTest.class.getName());
	
	
	public SearchResultPageTest() {
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
	}
	
	@Test(priority=1)
	public void verifySearchResultWorkingCorrectly()
	{
		//log.info("*********** Started :  verifySearchResultWorkingCorrectly  ***************");
		
		cartPage = searchResultPage.selectSingleProductFromSearchResult();
		
		AssertJUnit.assertEquals(cartPage.getUrlOfCartPage(), "https://www.shoppersstack.com/cart");
		
		//log.info("*********** Finished : verifySearchResultWorkingCorrectly  ***************");
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
