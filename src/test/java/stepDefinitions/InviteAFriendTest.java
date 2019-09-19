package stepDefinitions;
	
	
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import java.util.concurrent.TimeUnit;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Reusable.BasePropertyTest;

	@RunWith(Cucumber.class)
	public class InviteAFriendTest extends BasePropertyTest {
		WebDriver driver;
	    @Given("^User is logged into the  application$")
	    public void user_is_logged_into_the_application() throws Throwable {
	    	// This steps opens the browser and logs in a user into the application.	
	    	SetUp ();	
	        
	    }

	    @When("^User clicks the Freunde einladen$")
	    public void user_clicks_the_freunde_einladen() throws Throwable {
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    WebElement invite = driver.findElement(By.xpath("//a[@class='page-navigation__link--invite _sections-link_dyd59d _action_dyd59d _base-action_dyd59d']"));
	    invite.click();
	    }

	    @Then("^User scrolls to the per E-mail einladen text box$")
	    public void user_scrolls_to_the_per_email_einladen_text_box() throws Throwable {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("window.scrollBy(0,250)", "");
	        
	    }

	    @Then("^User clicks the E-mail einladen$")
	    public void user_clicks_the_email_einladen() throws Throwable {
	    	WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
	    	inputEmail.sendKeys("haywaii90@yahoo.com");
	    	
	    	WebElement sendInvite = driver.findElement(By.xpath("//button[@id='sendInvitationEmail']"));
	    	sendInvite.click();
	        
	    }

	    @And("^User verifies that an onscreen notification message is recieved$")
	    public void user_verifies_that_an_onscreen_notification_message_is_recieved() throws Throwable {
	    	WebElement msg = driver.findElement(By.xpath("//div[@class='success-text']"));
	    	String txt = msg.getText();
	    	String ExpectedText = "erfolgreich versendet";
	    	Assert.assertEquals(txt, ExpectedText);	
	        
	    }	
	

}
