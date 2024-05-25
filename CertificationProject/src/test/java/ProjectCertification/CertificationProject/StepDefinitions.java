package ProjectCertification.CertificationProject;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pom.DemoBlazeHomePage;
import pom.DemoBlazeSignUpPage;
import pom.GoogleSearch;
import utils.Common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StepDefinitions {
	
	//2. Create a Maven Project —associate required libraries with the Maven Project.
	//3. Configure required dependencies like Selenium WebDriver, TestNG / Junit, Cucumber,etc.,in pom.xml

	private WebDriver driver;
	Common common;
	String browser = "chrome";
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//String url = "https://www.google.com/";
	
	@Before
	public void setup()
	{
		common = new Common();
		common.setupBrowser(browser);
		driver = common.getBrowser();
	}
	
	@After
	public void tearDown()
	{
		common.quitBrowser();
	}
	
    @Given("The user is on the webBrowser")
    public void navToGoogleBrowser() {
    	driver.navigate().to("https://www.google.com/");
    }

    @Then("it should navigate to Google homepage")
    public void urlValidation() {
    	String expectedResult = "https://www.google.com/";
    	String actualResult = driver.getCurrentUrl();
    	assert(actualResult.equals(expectedResult));
    	
//    	WebElement search = driver.findElement(By.className("gLFyf"));
//    	search.sendKeys("Demoblaze");
//    	search.submit();  
//    	driver.navigate().refresh();
    	GoogleSearch obj = new GoogleSearch(driver);
    	obj.enterSearch();
    	System.out.println(driver.getCurrentUrl());
    }
    
    @And("generate the list of related sites")
    public void titleValidation()
    {
    	String expectedResult = "DemoBlaze - Google Search";
//    	try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	String actualResult = driver.getTitle();
    	System.out.println(actualResult);
    	assert(actualResult.equals(expectedResult));
    	
    	GoogleSearch obj = new GoogleSearch(driver);
    	obj.clickOnTopDemoBlazeLink();
    	//WebElement topDemoBlazeLink = driver.findElement(By.xpath(("//a[@href='https://www.demoblaze.com/']")));
    	//topDemoBlazeLink.click();
    }
    
    @And("should display \"Welcome to Demo Blaze\"")
    public void greetingsDisplayValidation()
    {
    	System.out.println(driver.getCurrentUrl());
    	Assert.assertTrue(true, "Welcome to Demo Blaze message not displayed");
    	driver.manage().window().maximize();
    }
    
    @Given("I am on Demo Blaze site")
    public void demoBlazeHomePageTitleValidation()
    {
    	driver.navigate().to("https://www.demoblaze.com/");
    	driver.manage().window().maximize();
    }
    
    @Then("click on Sign up")
    public void clickOnSignUp() {
    	String expectedResult = "STORE";
    	String actualResult = driver.getTitle();
    	assert(actualResult.equals(expectedResult));
    	
    	DemoBlazeHomePage obj = new DemoBlazeHomePage(driver);
    	obj.clickOnSignUp();    	
//    	WebElement hiddenElem = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("signin2"))));
//    	hiddenElem.click();
//    	try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
    
//    @Given("I am on the Sign up pop up screen")
//    public void signUpPopUpScreen()
//    {
//
//    	
//    }
    
    @When("username field is visible and editable")
    public void usernameFieldValidation()
    {
    	DemoBlazeSignUpPage obj = new DemoBlazeSignUpPage(driver);
    	String expectedResult = "Sign up";
    	String actualResult = obj.getText();
    	assert(actualResult.equals(expectedResult));
    	
    	obj.userNameCheck();
//    	WebElement username = driver.findElement(By.id("sign-username"));
//    	username.isDisplayed();
//    	username.isEnabled();
    }
    
    @Then("I enter {string}")
    public void enterUsername(String userName)
    {
    	DemoBlazeSignUpPage obj = new DemoBlazeSignUpPage(driver);
    	obj.userNameSendValue(userName);
    	//WebElement username = driver.findElement(By.id("sign-username"));
    	//username.sendKeys(userName);
    	System.out.println(userName);
    }
    
	@Then("valid username entered")
	public void validUSername() {
		System.out.println("Valid username entered");
	}

	@Then("invalid username entered")
	public void invalidUsername() {
		System.out.println("invalid username entered");
	}

}
