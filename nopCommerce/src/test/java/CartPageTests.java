import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTests extends LoginBase{
	private CartPage cartPage;
    WebDriverWait wait ;

	@Test
	public void checkOutTest() throws InterruptedException {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout

		homePage.chooseColorItem();
		homePage.chooseSizeShoes();
	    homePage.clickOnAddToCartButton();
		cartPage = homePage.clickOnAddToShoppingCart();
		cartPage.clickOnTermsOfServices();
		cartPage.clickOnCheckOutButton();
		cartPage.enterCity("Giza");
		cartPage.enterAddress("Elsheikh Zayed");
		cartPage.enterZipCode("002");
		cartPage.enterPhoneNumber("01141681530");
		cartPage.chooseCountryByValue("123");
		cartPage.clickContinue();
		cartPage.chooseShippingMethods("ground");
		cartPage.choosePaymentMethods("money order");
		cartPage.paymentInformation();
		cartPage.clickConfirm();
		String ActualMsg = cartPage.checkOutMessage();
		String expectedMsg = "Your order has been successfully processed!";
		Assert.assertTrue(ActualMsg.contains(expectedMsg));

		Thread.sleep(1000);
	}

}
