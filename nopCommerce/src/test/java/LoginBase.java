import org.testng.annotations.BeforeClass;

public class LoginBase extends TestBase{
	protected HomePage homePage;
	protected LoginPage loginPage;

	@BeforeClass
	public void validLoginsScenario() throws InterruptedException {
		 homePage = new HomePage(driver);
		 loginPage =  homePage.clickOnLoginButton();
		 loginPage.enterEmail("hossam19@gmail.com"); //16
		 loginPage.enterPassword("123456");
		 loginPage.clickOnLoginButton();
	}
}
