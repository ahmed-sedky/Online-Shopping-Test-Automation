import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private By email = By.id("Email");
	private WebElement emailElement ;
	
	private By password = By.id("Password");
	private WebElement passwordElement ;
	
	private By loginButton = By.className("login-button");
	private WebElement loginButtonELement;
	
	private By msgError = By.className("message-error");
	private WebElement msgErrorElement ;
	
	private By emailError = By.id("Email-error");
	private WebElement emailErrorElement ;
	
	public void enterEmail(String Email) {
		emailElement = driver.findElement(email);
		sendText(emailElement ,Email );
	}
	
	public void enterPassword(String Password) {
		passwordElement = driver.findElement(password);
		sendText(passwordElement ,Password );
	}
	
	public void clickOnLoginButton() {
		loginButtonELement =  driver.findElement(loginButton);
		clicking(loginButtonELement);
	}
	
	public String showErrorMsg() {
		msgErrorElement = driver.findElement(msgError);
		return msgErrorElement.getText();
	}
	
	public String showEmailErrorMsg() {
		emailErrorElement = driver.findElement(emailError);
		return emailErrorElement.getText();
	}

}
