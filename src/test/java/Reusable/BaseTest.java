package Reusable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.BeforeMethod;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;

import org.testng.annotations.Test;



public class BaseTest {
	
WebDriver driver;
public String baseURL = "https://fbnmobile-admin.azurewebsites.net/Account/Login?ReturnUrl=%2F";
public String browserType = "Chrome";
public String CorrectUsername = "SN027710";
public String NonprofiledUsername = "sn029034";
public String CorrectPassword = "password";
public String InCorrectPassword = "skyNet@1.com";
public String BlankUsername = "";
public String BlankPassword = "";
public String Token = "123456";
	
	

@BeforeTest
public void SetUp () {
System.out.println("Open browser"); //Open Browser
driver = Utilities.DriverFactory.open(browserType);//Choose Chrome
driver.get(baseURL);  	

System.out.println("Execute Login Test");		
//1. Enter Username.
WebElement email= driver.findElement(By.name("StaffId"));
email.sendKeys(CorrectUsername);
						
//2. Enter Password.
WebElement password = driver.findElement(By.name("Password"));
password.sendKeys(CorrectPassword);
				
//3. Click Login.	
WebElement login = driver.findElement(By.xpath("//button[@id='login-btn']"));
login.click();
				
//4. Wait before clicking.			
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
//5. Enter token.
WebElement token = driver.findElement(By.xpath("//input[@id='Token']"));
token.sendKeys(Token);
						
//6. Wait before clicking submit.				
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
//7. Click submit
WebElement submit = driver.findElement(By.xpath("//button[@id='token-btn']"));
submit.click();
	
}



@Test

public void LoginTest () {
	
	String ActualTitle = driver.getTitle();
	String ExpectedTitle = "Index -FBN Mobile Dashboard";
	if (ActualTitle.equalsIgnoreCase(ExpectedTitle)) {
		System.out.println("Title Matched");
	}
		else {
		System.out.println("Title didn't match");
		
	}
									
}




@Test
public void CreateDepartment () {
System.out.println("Execute Create Department Test");	
//9. Wait
driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

//10. Click Department
WebElement ClickDept = driver.findElement(By.xpath("//a[contains(text(),'Departments')]"));
ClickDept.click();
	
//11.Wait	
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//12. Enter department name
WebElement Inputdept = driver.findElement(By.xpath("//input[@id='Name']"));
Inputdept.sendKeys("Tesept");
	
//13.Wait
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


//14.Click
WebElement SaveDept = driver.findElement(By.xpath("//button[@class='btn btn-save']"));
SaveDept.click();
}



@AfterTest	
public void closePage () {
 System.out.println("Close Browser");
  driver.quit();
		
	}

}

