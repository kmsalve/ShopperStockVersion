package com.shopper.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopper.qa.base.TestBase;
import com.shopper.qa.pages.HomePage;
import com.shopper.qa.pages.LandingPage;
import com.shopper.qa.pages.SignInPage;

public class SingInPageTest extends TestBase
{
	//define annotations
	LandingPage landingPage;
	SignInPage signInPage;
	HomePage homePage;
	
		
	public SingInPageTest() 
	{
		super();	
		
	}

	@BeforeMethod
	public void setUp() 
	{
		initialization();	
		
	    landingPage = new LandingPage();
		
		signInPage = landingPage.clickLoginFromLandingPage();
	}
	
	@Test(priority=1)
	public void clickLoginTest() 
	{
		homePage = signInPage.login("kmsalve@gmail.com", "Rohan123@");
	}
	
	
	@AfterMethod
	public void TearDown() 
	{
		driver.quit();
	}
	
}
