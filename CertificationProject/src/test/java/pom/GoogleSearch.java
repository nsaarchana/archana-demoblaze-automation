package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearch {
	
private WebDriver driver;
	
	@CacheLookup
	@FindBy(className = "gLFyf")
	WebElement search;
	
	@CacheLookup
	@FindBy(xpath = "//a[@href='https://www.demoblaze.com/']")
	WebElement topDemoBlazeLink;
	
	@CacheLookup
	@FindBy(css = "#u_0_0_yd")
	WebElement loginBtn;
	
	
	public GoogleSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterSearch() {
		search.clear();
		search.sendKeys("DemoBlaze");
		search.submit();
	}
	
	public void clickOnTopDemoBlazeLink() {
		topDemoBlazeLink.click();
	}
		
	public void googleSearch() {
		enterSearch();
		clickOnTopDemoBlazeLink();
		
	}


}
