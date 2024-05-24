package testCases;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import pages.HomePage;

public class HomePageTest extends TestBase {

HomePage homePage;
	
	@BeforeMethod
	public void set()
	{
		homePage = new HomePage();
		logger.info("Initiating HomePage Contructor");
	}
	
	@Test
	public void verifyTitle()
	{	
		try
		{
		AssertJUnit.assertEquals(homePage.validateHomePageTitle(), "STORE");
		logger.info("Title is correct");
		}
		catch(Exception e)
		{
			logger.info("Title is incorrect");
		}
	}
	
	@Test
	public void verifyLogo()
	{	
		logger.warning("Validating Logo of DemoBlaze");
		AssertJUnit.assertTrue(homePage.isLogoDisplayed());
	}
}
