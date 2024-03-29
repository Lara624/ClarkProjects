package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	//This method returns a browser back
	
	public static WebDriver open (String browserType){
		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ayobami\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ayobami\\Documents\\Selenium Software\\chromedriver.exe");
			 return new ChromeDriver();
		}
		
		else if (browserType.equalsIgnoreCase("firefox")) {		
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ayobami\\Documents\\Selenium Software\\geckodriver.exe");
			 return new FirefoxDriver();
		}
		
		else {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Ayobami\\Documents\\Selenium Software\\IEDriverServer.exe");
			 return  new InternetExplorerDriver();
			
		}
		
		
	}

}
