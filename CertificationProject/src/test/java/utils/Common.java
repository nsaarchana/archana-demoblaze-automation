package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Common {
	
	private WebDriver driver;
	
	public void setupBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("safari"))
			driver = new SafariDriver();
		else if(browser.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
		{
			System.out.println("Valid browser name is not entered, hence quitting the automation run");
			System.exit(0);
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//if(url!="")
			//driver.get(url);
		//else
			//driver.get("about:blank");
	}
	
	public WebDriver getBrowser()
	{
		return driver;
	}
	
	public void closeTab()
	{
		driver.close();
	}
	
	public void quitBrowser()
	{
		driver.quit();
	}

}
