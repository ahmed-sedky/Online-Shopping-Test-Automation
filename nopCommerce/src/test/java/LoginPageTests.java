import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{
	
	private HomePage homePage;
	private LoginPage loginPage;
	
	@DataProvider (name = "invalidLoginData")
	public Object[][] login(){
		return new Object[][]{
		{"Hossam@gmail.com" , "123456789" , "Login was unsuccessful. Please correct the errors and try again"},  //invalid email
		{"Hossam@gmail.com" , "56789" , "Login was unsuccessful. Please correct the errors and try again"}, //invalid password
		{"Hossam@gmail.com" , "" , "Login was unsuccessful. Please correct the errors and try again"}, //empty password field
		};
	}
	
	@DataProvider (name = "invalidLoginData2")
	public Object[][] login2(){
		return new Object[][]{
		{"" , "123456789"} ,  //empty email
		{"" , "" } //empty email & password
		};
	}
	 @Test (dataProvider = "invalidLoginData")
	public void invalidLoginsScenario_3(String email , String password ,String ExpextedMsg ) throws InterruptedException {
		 homePage = new HomePage(driver);
		 loginPage =  homePage.clickOnLoginButton();
		 loginPage.enterEmail(email);
		 loginPage.enterPassword(password);
		 loginPage.clickOnLoginButton();
		 Thread.sleep(2000);
		 String actualMsg =  loginPage.showErrorMsg();
		 Assert.assertTrue(actualMsg.contains(ExpextedMsg));
		 Thread.sleep(1000);
	 }
	 @Test (dataProvider = "invalidLoginData2")
	public void invalidLoginsScenario_4(String email ,String password) throws InterruptedException {
		 homePage = new HomePage(driver);
		 loginPage =  homePage.clickOnLoginButton();
		 loginPage.enterEmail(email);
		 loginPage.enterPassword(password);
		 loginPage.clickOnLoginButton();
		 Thread.sleep(2000);
		 String actualMsg =  loginPage.showEmailErrorMsg();
		 Assert.assertTrue(actualMsg.contains("Please enter your email"));
		 Thread.sleep(1000);
	 }
	 @Test 
	public void validLoginsScenario() throws InterruptedException {
		 homePage = new HomePage(driver);
		 loginPage =  homePage.clickOnLoginButton();
		 loginPage.enterEmail("hossam3@gmail.com");
		 loginPage.enterPassword("654321");
		 loginPage.clickOnLoginButton();
		 Thread.sleep(2000);
		 String currentUrl = driver.getCurrentUrl();
		 Assert.assertEquals(currentUrl,loginPage.getHomePageUrl());
		 Thread.sleep(1000);
	 }


}
