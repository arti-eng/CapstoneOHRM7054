package com.OHRMCapstone;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Scenario2testClass {
	WebDriver driver;
	Loginpageclass lpc=new Loginpageclass(driver);
	Adminpageclass apc = new Adminpageclass(driver);
	
	@BeforeClass
	 public void setupAndlogintoOHRM() {
		 driver = new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//login on Login Page
		  lpc= new Loginpageclass(driver);
		  apc = new Adminpageclass(driver);
		  lpc.setusername("Admin");
		  lpc.setpswd("admin123");
		  lpc.clicklogin();
		
	}
	
  @Test
  public void Test1() {
	  
	  
	  // Logged in ----- Count no. of options on left side menu
	 int noOfOptions= apc.getnoOfOptionsonAdminpage();
	 System.out.println("Total no. of options on  left side menu are :" +noOfOptions);
	 
	 // click on Admin link
	 apc.clickOnAdminLink();
	 System.out.println("Successfully clicked on Admin Link");
	
  }
  
  @Test
  
  public void Test2() {
	  
//		 // click on Admin link
//		 apc.clickOnAdminLink();
//		 System.out.println("Successfully clicked on Admin Link");
		 
		 apc.enterUsername("Admin");
		 apc.clickOnSearchbtn();
		 String TotalRecords= apc.noOfRecords();
		 System.out.println("Total no. of records for Admin as user are :"+ TotalRecords);
		 driver.navigate().refresh();
	  
  }
  @Test
  public void Test3() {
	  apc.clickOnuserroledrpDwn();
	  apc.clickOnAdminuserRole();
	  apc.clickOnSearchbtn();
	  String TotalRecords= apc.noOfRecords();
		 System.out.println("Total no. of records for Admin as user role are :"+ TotalRecords);
		 driver.navigate().refresh();
	  
	  
  }
  
  @Test 
  public void Test4() {
	  apc.clickOnStatusDrpdwn();
	  apc.clickOnDisabled();
	  apc.clickOnSearchbtn();
	  String TotalRecordsfordisabled= apc.noOfRecords();
		 System.out.println("Total no. of records for disabled status are :"+ TotalRecordsfordisabled);
		 driver.navigate().refresh();
		 apc.clickOnStatusDrpdwn();
		 apc.clickOnEnabled();
		 String TotalRecords= apc.noOfRecords();
		 System.out.println("Total no. of records for enabled staus are :"+ TotalRecords);
		 driver.navigate().refresh();
		 
	  
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
