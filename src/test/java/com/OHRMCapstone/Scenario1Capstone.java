package com.OHRMCapstone;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OHRMCapstone.ExcelUtility;


public class Scenario1Capstone {
	
WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
	//	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(dataProvider = "loginData")
	  public void LoginTestOHRM(String username , String pswd , String result) throws IOException, InterruptedException {
		  
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  WebElement usertxt = driver.findElement(By.name("username"));
		  usertxt.clear();
		  usertxt.sendKeys(username);
		  
		  WebElement pswdtxt = driver.findElement(By.name("password"));
		  pswdtxt.clear();
		  pswdtxt.sendKeys(pswd);
		   
		  //driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		  driver.findElement(By.xpath("//button[@type = \"submit\"]")).click();
		  
		  
		  //TAKE SCREENSHOT WHETHER THE PAGE IN LOGGEDIN OR NOT
		  ExcelUtility.getScreenshot(driver, "ss_"+System.currentTimeMillis());

		  
		  String exp_url = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		  String act_url = driver.getCurrentUrl();
		  
		  
		  if (exp_url.equals(act_url)) {
			  
			  System.out.println("Login Successful");
			  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
	     	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a")).click();
			  Assert.assertTrue(true);
			  
		  }
		  else
			  System.out.println("Login failed");
	}
	
	@DataProvider(name = "loginData")
	  public String[][] getData() throws IOException{
		  String path = ".\\testdatafiles\\OrangeHRMlogindetails.xlsx";
		  ExcelUtility util = new ExcelUtility(path);
		  int totalrows = util.getRowCount("Login");
		  int totalcolms = util.getCellCount("Login", 1);
		  
		  String logindata[][] = new String[totalrows][totalcolms];
		   for(int i= 1; i<=totalrows ; i++) 
		   {
			   for(int j=0 ; j<totalcolms ; j++) {
				   logindata[i-1][j]= util.getCellData("Login", i, j);
			   }
			   
		   }
		  
		  return logindata;
		  
	  }
}
