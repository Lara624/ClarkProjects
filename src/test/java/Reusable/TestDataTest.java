package Reusable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDataTest {
	
	WebDriver driver;
	
	
	public String baseURL = "http://192.168.253.76/fbnmobiledashboard/Account/Login";
	public String browserType = "Chrome";
	public String CorrectUsername = "SN027710";
	public String NonprofiledUsername = "sn029034";
	public String CorrectPassword = "Wiskolowiska2025!";
	public String InCorrectPassword = "skyNet@1.com";
	public String BlankUsername = "";
	public String BlankPassword = "";
	public String Token = "123456";
	
	
@Test

public void SuccessfulLoginTest () {
	
	System.out.println("Start execution");
	
	//1. Enter Username.
			WebElement email= driver.findElement(By.name("StaffId"));
			email.sendKeys(CorrectUsername);
					
			//2. Enter Password.
			WebElement password = driver.findElement(By.name("Password"));
			password.sendKeys(CorrectPassword);
			
			//4. Click Login.	
			WebElement login = driver.findElement(By.xpath("//button[@id='login-btn']"));
			login.click();
			
			//5. Wait before clicking.
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//6. Enter token.
			WebElement token = driver.findElement(By.xpath("//input[@id='Token']"));
			token.sendKeys(Token);
			
			//7. Click submit
			WebElement submit = driver.findElement(By.xpath("//button[@id='token-btn']"));
			submit.click();
			
			System.out.println("Complete test");
		
			
}
 @BeforeTest
public void setUp () {
	System.out.println("Opening browser");
	driver = Utilities.DriverFactory.open(browserType);//Choose Chrome
	driver.get(baseURL);                                //Open Browser
}
 
 @AfterTest	
	public void closePage () {
    	System.out.println("Close Browser");
    	driver.quit();
		
	}
 
}
