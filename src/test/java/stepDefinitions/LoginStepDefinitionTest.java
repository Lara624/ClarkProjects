package stepDefinitions;		
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Reusable.BasePropertyTest;

@RunWith(Cucumber.class)
public class LoginStepDefinitionTest extends BasePropertyTest {
		
WebDriver driver;	

@Given("^User opens the web application URL on chrome browser$")
public void user_opens_the_web_application_url_on_chrome_browser() throws Throwable {
System.out.println("Open browser"); //Open Browser
driver = Utilities.DriverFactory.open(browserType);//Choose Chrome
driver.get(baseURL); 	   
}


@When("^User Clicks the login button$")
public void user_clicks_the_login_button() throws Throwable {
WebElement login = driver.findElement(By.xpath("//div[text()='Einloggen']"));
login.click();
	
	        
}

@Then("^User enters username and password$")
public void user_enters_username_and_password() throws Throwable {
WebElement email= driver.findElement(By.xpath("//input[@id='user_email']"));
email.sendKeys(CorrectEmail);
							

WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
password.sendKeys(CorrectPassword);	        

}


@And("^User clicks login$")
public void user_clicks_login() throws Throwable {
WebElement finallogin = driver.findElement(By.xpath("//input[@name='commit']"));
finallogin.click();
	
	        
}


	}	


