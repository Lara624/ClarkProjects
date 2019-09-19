package stepDefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import Reusable.BasePropertyTest;

@RunWith(Cucumber.class)

public class ConfirmationOfValueTest extends BasePropertyTest {

WebDriver driver;

 @Given("^User is logged into the application$")
public void user_is_logged_into_the_application() throws Throwable {
	 
// This step opens the browser and logs in a user into the application.	
SetUp ();	
	 
 }

@When("^User checks if the Dein Renteinkommen value is above 2000Euro$")
public void user_checks_if_the_dein_renteinkommen_value_is_above_2000euro() throws Throwable {
 
// This step executes the check for Renteinkomen validation above 2500 euros.	
ConfirmationOfRenteneikommenValue ();	 
	 
 }

}	
	

