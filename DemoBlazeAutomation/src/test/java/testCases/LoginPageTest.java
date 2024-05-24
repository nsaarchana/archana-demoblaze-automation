package testCases;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;

public class LoginPageTest extends TestBase {
	
	public LoginPage loginPage;
	HomePage homePage;
	Alert alert;
	
	@BeforeMethod
	public void start()
	{	
		homePage = new HomePage();
		logger.info("Going to Login Page");
		loginPage=homePage.goToLoginPage();
	}
	
	
	@Test(dataProvider = "LoginData", priority = 0)
	public void loginTest(String user, String pwd, String res) throws Exception
	{
		switch (res) {
		case "Valid":
			loginPage.login(user, pwd);
			AssertJUnit.assertTrue(true);
			logger.info("Valid user-"+user);
			
			break;

		case "Invalid":
			loginPage.login(user, pwd);
			String txt = TestUtil.handleAlert(driver, alert);
			AssertJUnit.assertEquals(txt, "User does not exist.");
			loginPage.clickOnClose();
			driver.get(driver.getCurrentUrl());
			break;
		}	
		
	}
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws Exception
	{	
		logger.info("Getting data from Excel File");
		return TestUtil.getDataFromXL();
		
	}

}
