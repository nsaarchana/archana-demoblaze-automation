package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;
import util.BrowserFactory;
import util.TestUtil;

public class TestBase {
public static WebDriver driver;
public static Properties prop = new Properties();
public static String current_project_dir;
public LoginPage loginPage;
public static Logger logger;


public TestBase()
{
	try
	{
	
		current_project_dir = System.getProperty("user.dir");
		File propFile = new File(current_project_dir+"/src/main/java/config/config.properties");
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
	}
	
	catch(IOException e)
	{
		e.getMessage();
		e.getStackTrace();
	}
}

public static void initialization()
{
	String browserName = prop.getProperty("browser");
	
	logger = logger.getLogger("DemoBlaze Automaton");
	PropertyConfigurator.configure(current_project_dir+"/src/main/resources/log4j.properties");
	
	BrowserFactory obj = new BrowserFactory();
	
	obj.checkBrowser(browserName);
	driver = obj.getBrowser();
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
	
	driver.get(prop.getProperty("url"));
}

@BeforeSuite
public void setUp()
{
	initialization();
	loginPage = new LoginPage();
	
}

@AfterSuite
public void tearDown()
{
	driver.quit();
}
}
