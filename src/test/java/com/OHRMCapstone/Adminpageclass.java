package com.OHRMCapstone;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adminpageclass {
	
WebDriver driver;
	
	
	//constructor
	Adminpageclass(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//locators
	
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li") List<WebElement>options;
	@FindBy (xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")  WebElement Admin;
	 @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")   WebElement usernametxtbox;
	 @FindBy (xpath ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]") WebElement searchbtn;
	 @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i") WebElement userroledrpdown;
	 @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]") WebElement AdmininuserRole;
	 @FindBy (xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]/i") WebElement StatusdrpDown;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div[2]/span") WebElement Enabled;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div[3]/span") WebElement Disabled;
	@FindBy (xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span") WebElement RecordsFound;
	
	//actionmethods
	 
	 public int  getnoOfOptionsonAdminpage() {
		 for(WebElement op:options) {
			 System.out.println(op.getText());
		 }
		int size= options.size();
		 System.out.println("Total no of options provided are :" + options.size());
		 return size;
	 }
	 
	 public void clickOnAdminLink() {
		 Admin.click();

	 }
	 
	 public void enterUsername(String user) {
		 
		 usernametxtbox.sendKeys(user);
	 }
	 
	 public void clickOnSearchbtn() {
		searchbtn.click();

	 }
	 
	 
	 public void clickOnuserroledrpDwn() {
			userroledrpdown.click();

		 }
	 
	 public void clickOnAdminuserRole() {
		AdmininuserRole.click();

		 } 
	 
	 public void clickOnStatusDrpdwn() {
			StatusdrpDown.click();

		 }
	 public void clickOnEnabled() {
			Enabled.click();

		 }
	 
	 
	 public void clickOnDisabled() {
			Disabled.click();

		 }
	 public String noOfRecords() {
		String rec= RecordsFound.getText();
		 String records= rec.replaceAll("[^0-9]", "");
		 return records;
		 
	 }
	 

}
