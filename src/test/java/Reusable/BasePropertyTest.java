package Reusable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


public class BasePropertyTest {
WebDriver driver;
public String baseURL = "https://www.clark.de/de/";
public String browserType = "Chrome";
public String CorrectEmail = "steffen.glomb@posteo.de";
public String CorrectPassword = "Hallo123";

	
	

@BeforeTest
public void SetUp () {
System.out.println("Open browser"); //Open Browser
driver = Utilities.DriverFactory.open(browserType);//Choose Chrome
driver.get(baseURL);  	

System.out.println("********Validating Login Test********");
WebElement login = driver.findElement(By.xpath("//div[text()='Einloggen']"));
login.click();

//1. Enter Username.
WebElement email= driver.findElement(By.xpath("//input[@id='user_email']"));
email.sendKeys(CorrectEmail);
						
//2. Enter Password.
WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
password.sendKeys(CorrectPassword);
				
//3. Click Login.	
WebElement finallogin = driver.findElement(By.xpath("//input[@name='commit']"));
finallogin.click();

System.out.println("******** Login Test Validation Complete ********");

}



@Test
public void LoginTest () {
	System.out.println("******** Validating Home Page Test ********");
	System.out.println("Validating Successful login");		
	String actualTitle = "Clark";
	Assert.assertEquals(driver.getTitle(), actualTitle);
	System.out.println("******** Home Page Validation Complete ********");
	}

@Test
public void CheckContracts() {
	System.out.println("******** Validating Number of Contracts Present ********");
	int k = driver.findElements(By.xpath("//div[@role='button']//span[text()='Gut versichert']")).size();
	
	if (k >= 1) {
		System.out.println("There are "+ k + " contracts with “Gut versichert");
	}else if(k <= 0) {
		System.out.println("There are no contracts with “Gut versichert");
		System.out.println("******** Contract Validation Test Complete ********");
	}
	
}

	
@Test
public void ConfirmationOfRenteneikommenValue () {
	
System.out.println("******** Validating Renteneikommen Value Test ********");
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
WebElement rente = driver.findElement(By.xpath("//a[@href='/de/app/retirement']"));
rente.click();

	
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
WebElement b = driver.findElement(By.xpath("//dd[@class='_actual-income__value_1aoxqn _value_1aoxqn _flex-item_1aoxqn']"));
String a = b.getText();  
String[] s1 = a.split("\\s", 2);  
String[] kk = s1[0].split(",");
String oo = kk[0].replace(".", "");
String value = oo +"."+kk[1]; 
double NAmount = Double.parseDouble(value);

if (NAmount > 2400) {
	
System.out.println("Renteneinkommen is above 2400 Euro");			
	}

else {
System.out.println("Renteneinkommen is below 2400 Euro");

System.out.println("******** Renteneikommen Value Test Complete ********");	
		
		
	}
	
	
}

@Test

public void ComfirmationEmpfohlenenAppears () {
System.out.println("******** Validating empfohlenen  Value Test ********");		
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
WebElement Bedarf = driver.findElement(By.xpath("//a[@class='is-active page-navigation__link--optimisations _sections-link_dyd59d _action_dyd59d _base-action_dyd59d _active-link_dyd59d']"));
Bedarf.click();
	
WebElement button = driver.findElement(By.xpath("//div[@id='ember681']//div[@class='_content-container_s84z92']"));
Assert.assertEquals(true, button.isDisplayed());

System.out.println("******** empfohlenen  Value Test Complete ********");	

}


@Test 

public void InviteAFriend () {
JavascriptExecutor js = (JavascriptExecutor) driver;
System.out.println("******** Validating Invite A Friend Test ********");		
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

WebElement invite = driver.findElement(By.xpath("//a[@class='page-navigation__link--invite _sections-link_dyd59d _action_dyd59d _base-action_dyd59d']"));
invite.click();

js.executeScript("window.scrollBy(0,250)", "");

WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
inputEmail.sendKeys("haywaii90@yahoo.com");

WebElement sendInvite = driver.findElement(By.xpath("//button[@id='sendInvitationEmail']"));
sendInvite.click();

WebElement msg = driver.findElement(By.xpath("//div[@class='success-text']"));
String txt = msg.getText();
String ExpectedText = "erfolgreich versendet";
Assert.assertEquals(txt, ExpectedText);
	
}



}

