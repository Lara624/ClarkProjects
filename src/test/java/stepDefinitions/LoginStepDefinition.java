package stepDefinitions;
import cucumber.api.java.en.And;
//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
//import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebElement;

import Reusable.BaseTest;


//import Utilities.DriverFactory;

@RunWith(Cucumber.class)
public class LoginStepDefinition extends BaseTest  {
	
WebDriver driver;


@Given("^User opens the application URL on chrome browser$")
public void user_opens_the_application_url_on_chrome_browser() throws Throwable {
driver = Utilities.DriverFactory.open(browserType);//Choose Chrome
driver.get(baseURL);   
	    }

	 
@When("^Appropriate username and password is entered and user clicks login$")
public void appropriate_username_and_password_is_entered_and_user_clicks_login() throws Throwable {
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

	    
	    
@Then("^User has access to the application$")
public void user_has_access_to_the_application() throws Throwable {
LoginTest();	
	    }

@And("^Close the browser$")
public void close_the_browser() throws Throwable {
closePage();
	    }
	        
    	 
}