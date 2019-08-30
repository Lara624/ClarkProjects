package DigitalLab;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import IntelixPlusChatBankingNegativeTestCases.BuyData;
import Reusable.TestDataTest;
//import Reusable.Testdata;
//import Reusable.Testdatatest;

public class UnsuccessfulLoginTest extends TestDataTest {
	
	
	WebDriver driver;
	
	@Test
	
	public void UnsuccessfulLogin () {
		
		
		// TODO Auto-generated method stub
		
		
		WebElement email = driver.findElement(By.name("StaffId"));
		email.sendKeys(CorrectUsername);
		
		//2. Enter Password.
		WebElement password = driver.findElement(By.name("Password"));
		password.sendKeys(InCorrectPassword);
		
		//4. Click Login.	
		WebElement login = driver.findElement(By.xpath("//button[@id='login-btn']"));
		login.click();
		
	
		
		closePage();
		

	
	}
}


		
		

