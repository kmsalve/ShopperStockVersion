package com.shopper.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopper.qa.base.TestBase;


public class LandingPage extends TestBase
{

	//Object repository
	
	////*[@id="loginBtn"]
	
	@FindBy(xpath = "//button[@id='loginBtn' and @name='loginBtn']")
	WebElement loginBtn;
	
	
	
	//constructor - inittialize page object
	public LandingPage() 
	{	
		PageFactory.initElements(driver, this);
	}

	
	
	//Actions 
	//click login button
	public SignInPage clickLoginFromLandingPage()
	{
		((RemoteWebDriver) driver).executeScript("arguments[0].click();", loginBtn);
		
		//loginBtn.click();
		return new SignInPage();
	}
	
	public String validateLandingPageTitle()
	{
		return driver.getTitle();
	}
	
}

