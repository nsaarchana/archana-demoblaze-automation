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
import org.testng.annotations.Test;

import Base.TestBase;
import pages.CartPage;
import pages.PaymentInfoPage;
import util.TestUtil;

public class PaymentInfoPageTest extends TestBase{

	PaymentInfoPage paymentInfoPage;
	CartPage cartPage;
	Alert alert;
	
	
	
	
	@Test(priority = 0)
	public void verifyPurchaseWithoutInfo()
	{	
		cartPage = new CartPage();
		logger.info("Going to Payment Page");
		paymentInfoPage = cartPage.goToPaymentPage();
		
		logger.info("Click on Purchase Button-->verifyPurchaseWithoutInfo");
		paymentInfoPage.clickPurchaseBtn();
		
		String txt = TestUtil.handleAlert(driver, alert);
		logger.info("Get Pop ups alert text");
		
		logger.info("Verifying Purchase Page without entering any order details");
		AssertJUnit.assertEquals(txt, "Please fill out Name and Creditcard.");
	}
	
	@Test(priority = 1)
	public void verifyPurchaseWithInfo()
	{
		logger.info("Send Order details in Payment Page");
		paymentInfoPage.sendDetails();
		
		logger.info("Click on Purchase Button-->verifyPurchaseWithInfo");
		paymentInfoPage.clickPurchaseBtn();
		
		logger.info("Verifying Purchase Page without entering any order details");
		AssertJUnit.assertEquals(paymentInfoPage.getSuccessMsg(), "Thank you for your purchase!");
		
	}
}
