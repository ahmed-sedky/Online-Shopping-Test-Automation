import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPageTests extends TestBase {
	private HomePage homePage;
	private RegisterPage registerPage;
	@DataProvider (name = "invalidRegisterScenarios")
		public Object[][] register(){
			return new Object[][] {
				{"male" , "" , "sedky" , "Ahmed@gmail.com" , "1233456789" , "1233456789" , "First name is required"}, //fname field empty
				{"male" , "Ahmed" , "" , "Ahmed@gmail.com" , "1233456789" , "1233456789" , "Last name is required"}, //lname field empty
				{"male" , "Ahmed" , "sedky" , "" , "1233456789" , "1233456789" , "Email is required"}, //email field empty
				{"male" , "Ahmed" , "sedky" , "Ahmed@gmail.com" , "" , "1233456789" , "The password and confirmation password do not match."}, //password field empty
				{"male" , "Ahmed" , "sedky" , "Ahmed@gmail.com" , "1233456789" , "" , "Password is required"}, //confirmPassword field empty
				{"male" , "Ahmed" , "sedky" , "Ahmed@gmail.com" , "1233456789" , "456978" , "The password and confirmation password do not match."}, //mismatch Between password field and confrim password field
				{"male" , "Ahmed" , "sedky" , "Ahmed@gmail.com" , "123" , "123" , "must have at least 6 characters"} //weak Password
			};
		}
	@Test (priority = 2 , dataProvider = "invalidRegisterScenarios")
	public void invalidRegisterTests(String gender, String fname ,String lname, String email , String pass , String confirmPass ,String expectedMsg) throws InterruptedException {
		homePage = new HomePage(driver);
		registerPage = homePage.clickOnRegisterButton();
		registerPage.chooseGender(gender);
		registerPage.sendFName(fname);
		registerPage.sendLName(lname);
		registerPage.sendEmail(email);
		registerPage.sendPassword(pass);
		registerPage.sendConfirmPassword(confirmPass);
		registerPage.clickOnRegisterButton();
		String actualMsg = registerPage.getFieldError();
		System.out.println(actualMsg);
		Assert.assertTrue(actualMsg.contains(expectedMsg));
		
		 Thread.sleep(1000);
	}
	@Test (priority = 1)
	public void validRegisterTest() throws InterruptedException {
		homePage = new HomePage(driver);
		registerPage = homePage.clickOnRegisterButton();
		registerPage.chooseGender("male");
		registerPage.sendFName("Ahmed");
		registerPage.sendLName("Hossam");
		registerPage.sendEmail("Hossam3@gmail.com");
		registerPage.sendPassword("123456");
		registerPage.sendConfirmPassword("123456");
		registerPage.clickOnRegisterButton();
		String actualMsg = registerPage.getResultMsg();
		System.out.println(actualMsg);
		Assert.assertTrue(actualMsg.contains("Your registration completed"));
		
		 Thread.sleep(1000);
	}
	
	@Test (priority =3)
	public void InvalidRegisterTest() throws InterruptedException { //email Already exists
		homePage = new HomePage(driver);
		registerPage = homePage.clickOnRegisterButton();
		registerPage.chooseGender("male");
		registerPage.sendFName("Ahmed");
		registerPage.sendLName("Hossam");
		registerPage.sendEmail("Hossam3@gmail.com");
		registerPage.sendPassword("123456");
		registerPage.sendConfirmPassword("123456");
		registerPage.clickOnRegisterButton();
		String actualMsg = registerPage.getMsgError();
		System.out.println(actualMsg);
		Assert.assertTrue(actualMsg.contains("The specified email already exists"));
		
		 Thread.sleep(1000);
	}
}
