package com.OHRMCapstone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpageclass {
	WebDriver driver;
	
	
	//constructor
	Loginpageclass(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements( driver , this);
	}
	
	
	//locators
	@FindBy (name="username") WebElement txtusername ;
	@FindBy (name="password") WebElement txtpswd ;
	@FindBy (xpath="//button[@type = \"submit\"]") WebElement loginbtn;
	
	//Action methods
	
	public void setusername(String user) {
		txtusername.sendKeys(user);
	}

	public void setpswd(String password) {
		txtpswd.sendKeys(password);
	}

	
	public void clicklogin() {
	loginbtn.click();
	}
	
}
