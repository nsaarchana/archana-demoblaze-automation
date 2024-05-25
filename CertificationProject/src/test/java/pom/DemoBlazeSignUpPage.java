package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoBlazeSignUpPage {
private WebDriver driver;
	
	@CacheLookup
	@FindBy(xpath = "//h5[text()='Sign up']")
	WebElement actualResult;
	
	@CacheLookup
	@FindBy(id = "sign-username")
	WebElement username;
		
	public DemoBlazeSignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getText() {
		return actualResult.getText();
		
	}
	
	public void userNameCheck() {
		username.isDisplayed();
		username.isEnabled();		
	}
		
	public void userNameSendValue(String userName) {
		username.sendKeys(userName);

	}
}
