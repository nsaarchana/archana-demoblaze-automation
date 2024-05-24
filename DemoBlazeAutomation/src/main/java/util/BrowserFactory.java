package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	private WebDriver driver;	
	public void checkBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			
			//System.setProperty("webdriver.chrome.driver",current_project_dir+"/Drivers/chromedriver");
			/*
			 * ChromeOptions options = new ChromeOptions(); options.
			 * addArguments("user-data-dir=C:\\Users\\VINGLE\\AppData\\Local\\Google\\Chrome\\User Data"
			 * ); options.addArguments("disable-infobars");
			 * 
			 * driver = new ChromeDriver(options);
			 */
			
			driver = new ChromeDriver();
			
		}
		
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", current_project_dir+"/Drivers/geckodriver");
			driver = new FirefoxDriver();
				
		}		
	}
	
	public WebDriver getBrowser() {
		return driver;
	}
}
