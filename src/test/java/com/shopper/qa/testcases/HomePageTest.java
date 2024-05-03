package com.shopper.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.sql.Time;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopper.qa.base.TestBase;
import com.shopper.qa.pages.HomePage;
import com.shopper.qa.pages.LandingPage;
import com.shopper.qa.pages.SearchResultPage;
import com.shopper.qa.pages.SignInPage;

public class HomePageTest extends TestBase
{

	//define variables
	LandingPage landingPage;
	SignInPage signInPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	//constructor
	public HomePageTest() 
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
	}
	
	//@Test(priority=1)
	public void verifyHomePageTitle() 
	{
		String actualTitle =  homePage.getHomePageTitle();
		AssertJUnit.assertEquals(actualTitle, "ShoppersStack");
	}
	
	@Test(priority=1)
	public void verifySearchFuctionality() 
	{
		
		String searchStr = "mobile"; //shirt
		searchStr = searchStr.toLowerCase();
		searchResultPage = homePage.searchfromHomePage(searchStr);
		
		AssertJUnit.assertEquals(searchResultPage.getUrlOfResultPage(), prop.getProperty("url")+"search-products/"+searchStr);
		
	}
	//@Test(priority=2)
	public void verifyHomePageLogo() 
	{
		
		AssertJUnit.assertEquals("", "");
	}
	
	//@Test(priority=3)
	public void verifyUserNameOnHomePage() 
	{
		
		AssertJUnit.assertEquals("", "");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
