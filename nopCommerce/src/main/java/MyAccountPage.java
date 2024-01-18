import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	By changePassword = By.xpath("//a[@href= '/customer/changepassword']");
	WebElement changePasswordElement;
	
	By oldPass = By.id("OldPassword");
	WebElement oldPassELement;
	
	By newPass = By.id("NewPassword");
	WebElement newPassELement;
	
	By confirmNewPass = By.id("ConfirmNewPassword");
	WebElement confirmNewPassELement;
	
	By resultMsg = By.className("content");
	WebElement resultMsgELement;
	
	By changePassButton = By.className("change-password-button");
	WebElement changePassButtonELement;
	
	public void clickOnChangePassword() {
		changePasswordElement = driver.findElement(changePassword);
		clicking(changePasswordElement);
	}
	
	public void enterOldPassword(String pass) {
		oldPassELement =driver.findElement(oldPass);
		oldPassELement.sendKeys(pass);
	}
	
	public void enterNewPassword(String pass) {
		newPassELement =driver.findElement(newPass);
		newPassELement.sendKeys(pass);
	}
	
	public void enterConfirmNewPassword(String pass) {
		confirmNewPassELement =driver.findElement(confirmNewPass);
		confirmNewPassELement.sendKeys(pass);
	}
	
	public void clickOnChangePasswordButton() {
		changePassButtonELement = driver.findElement(changePassButton);
		clicking(changePassButtonELement);
	}
	
	public String getResultMsg() {
		resultMsgELement = driver.findElement(resultMsg);
		return resultMsgELement.getText();
	}

}
