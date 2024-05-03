package com.shopper.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopper.qa.base.TestBase;

public class SignInPage extends TestBase{

	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement email;
	
	////div[contains(text(),'Login')]
	
	@FindBy(xpath ="//input[@id='Password']")
	WebElement password;
	
	
	@FindBy(xpath ="//button[@id='Login']")
	WebElement loginBtnNext;
	
	//constructor - inittialize page object
	public SignInPage() 
	{	
		PageFactory.initElements(driver, this);
	}
		

	public HomePage login(String un, String ps)
	{
		email.sendKeys(un);
		password.sendKeys(ps);
		loginBtnNext.click();
		
		return new HomePage();
	}
	
}
