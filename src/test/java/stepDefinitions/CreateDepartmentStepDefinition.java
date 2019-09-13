package stepDefinitions;
import java.util.concurrent.TimeUnit;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Reusable.BaseTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

public class CreateDepartmentStepDefinition extends BaseTest {
	
WebDriver driver;
	
 @Given("^Chrome Browser is opened$")
 public void chrome_browser_is_opened() throws Throwable {
 SetUp();  
    	
    }

 @When("^User has successfully logged into the application$")
 public void user_has_successfully_logged_into_the_application() throws Throwable {
 LoginTest();
    }
    
 @Then("^User clicks Department$")
 public void user_clicks_department() throws Throwable {
 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
 WebElement ClickDept = driver.findElement(By.xpath("//a[contains(text(),'Departments')]"));
 ClickDept.click();

    }
    

 @Then("^User enters Department name$")
 public void user_enters_department_name() throws Throwable {
 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 WebElement Inputdept = driver.findElement(By.xpath("//input[@id='Name']"));
 Inputdept.sendKeys("Ebuisness");
    }

 @Then("^User saves the department$")
 public void user_saves_the_department() throws Throwable {
 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 WebElement SaveDept = driver.findElement(By.xpath("//button[@class='btn btn-save']"));
 SaveDept.click();
    }

 @And("^Department is saved successfully$")
  public void department_is_saved_successfully() throws Throwable {
      
    }
	
}
