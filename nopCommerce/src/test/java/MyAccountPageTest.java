import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountPageTest extends LoginBase {
	private MyAccountPage myAccountPage;
	@Test
	public void changePasstest() throws InterruptedException {
		homePage = new HomePage(driver);
		myAccountPage = homePage.clickOnMyAccountButton();
		myAccountPage.clickOnChangePassword();
		myAccountPage.enterOldPassword("123456");
		myAccountPage.enterNewPassword("654321");
		myAccountPage.enterConfirmNewPassword("654321");
		myAccountPage.clickOnChangePasswordButton();
		String actualMsg =  myAccountPage.getResultMsg();
		Assert.assertTrue(actualMsg.contains("Password was changed"));
		Thread.sleep(2000);

	}

}
