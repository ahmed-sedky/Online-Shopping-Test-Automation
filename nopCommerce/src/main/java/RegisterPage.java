import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends PageBase{

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	 private By firstName = By.id("FirstName");
	 private WebElement firstNameElement ;
	 
	 private By lastName = By.id("LastName");
	 private WebElement lastNameElement; 
	 
	 private By email = By.id("Email");
	 private WebElement emailElement; 
	 
	 private By passowrd = By.id("Password");
	 private WebElement passwordElement; 

	 private By confirmPassword = By.id("ConfirmPassword");
	 private WebElement confirmPasswordElement; 
	 
	 private By male = By.id("gender-male");
	 private WebElement maleElement; 
	 
	 private By female = By.id("gender-female");
	 private WebElement femaleElement;
	 
	 private By registerButton = By.id("register-button");
	 private WebElement registerButtonElement;
	 
	 private By fieldError = By.className("field-validation-error");
	 private WebElement fieldErrorELement;
	 
	 private By msgError = By.className("message-error");
	 private WebElement msgErrorElement;
	 
	 private By result = By.xpath("//div[@class='result']");
	 private WebElement resultElement;
	 
	 public void sendFName(String fName) {
		 firstNameElement = driver.findElement(firstName);
		 sendText(firstNameElement ,fName);
	 }
	 
	 public void sendLName(String lName) {
		 lastNameElement = driver.findElement(lastName);
		 sendText(lastNameElement ,lName);
	 }
	 
	 public void sendEmail(String Email) {
		 emailElement =  driver.findElement(email);
		 sendText(emailElement ,Email);
	 }
	 
	 public void sendPassword(String Password) {
		 passwordElement = driver.findElement(passowrd);
		 sendText(passwordElement ,Password);
	 }
	 
	 public void sendConfirmPassword(String ConfirmPassword) {
		 confirmPasswordElement = driver.findElement(confirmPassword);
		 sendText(confirmPasswordElement ,ConfirmPassword);
	 }
	 
	 public void chooseGender(String gender) {
		 if (gender == "male") {
			 maleElement = driver.findElement(male);
			 clicking(maleElement);
		 }
		 else {
			 femaleElement = driver.findElement(female);
			 clicking(femaleElement);
		 }
	 }
	 
	 public void clickOnRegisterButton() {
		 registerButtonElement = driver.findElement(registerButton);
		 clicking(registerButtonElement);
	 }
	 
	 public String getFieldError() {
		 fieldErrorELement = driver.findElement(fieldError);
		 return fieldErrorELement.getText();
	 }
	 
	 public String getMsgError() {
		 msgErrorElement = driver.findElement(msgError);
		 return msgErrorElement.getText();
	 }
	 
	 public String getResultMsg() {
		 resultElement = driver.findElement(result);
		 return resultElement.getText();
	 }
	 



}
