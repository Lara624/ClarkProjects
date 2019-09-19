package stepDefinitions;
	
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import Reusable.BasePropertyTest;

@RunWith(Cucumber.class)
public class ContractValidationTest extends BasePropertyTest {
	
WebDriver driver;		

@Given("^User is already logged into the application $")
public void user_is_already_logged_into_the_application() throws Throwable {

// This steps opens the browser and logs in a user into the application.	
SetUp ();	
	
}

@When("^User counts the number of contracts that contains the word Gut versichert$")
public void user_counts_the_number_of_contracts_that_contains_the_word_gut_versichert() throws Throwable {

// This step executes the checks for numbers of Contract that contains Gut verischert
CheckContracts ();	
	
}


}	
	
	
	

