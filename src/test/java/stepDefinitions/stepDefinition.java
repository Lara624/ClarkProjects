package stepDefinitions;
import cucumber.api.java.en.And;
//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
//import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Reusable.TestDataTest;

@RunWith(Cucumber.class)
public class stepDefinition extends TestDataTest {
	
	WebDriver driver;


	@Given("^Initialize the chrome browser and enter the web application URL$")
	public void initialize_the_chrome_browser_and_enter_the_web_application_URL() throws Throwable {
	    // Open the chrome browser and web application.
	    setUp();
	}

    @When("^User enters (.+) and (.+) and logsin$")
    public void user_enters_and_and_logsin(String username, String password) throws Throwable {
    	
    	//Enter Staff username
    	WebElement staffemail= driver.findElement(By.name("StaffId"));
		staffemail.sendKeys(username);
				
		//Enter Staff Password.
		WebElement staffpassword = driver.findElement(By.name("Password"));
		staffpassword.sendKeys(password);
		
		//Click Login.	
		WebElement login = driver.findElement(By.xpath("//button[@id='login-btn']"));
		login.click();
		
		//Wait before clicking.
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Enter token.
		WebElement token = driver.findElement(By.xpath("//input[@id='Token']"));
		token.sendKeys(Token);
		
		//Click submit
		WebElement submit = driver.findElement(By.xpath("//button[@id='token-btn']"));
		submit.click();
        
    }

    @Then("^Validate login status$")
    public void validate_login_status() throws Throwable {
         System.out.println("Successful");
         
    }
    
    
         @And("^Close the browser$")
         public void close_the_browser() throws Throwable {
             // Write code here that turns the phrase above into concrete actions
             
        	 closePage();
         }
         
	        
    	 
    

}