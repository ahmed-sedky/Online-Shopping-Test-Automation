import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends PageBase{

	public CartPage(WebDriver driver) {
		super(driver);
	}
    WebDriverWait wait ;

	private By termsOfServices = By.xpath("//div[@class='terms-of-service']//input");
	private WebElement termsOfServicesElement;
	
	private By checkOutButton = By.xpath("//div[@class='checkout-buttons']//button");
	private WebElement checkOutButtonElement;
	
	private By chooseCountry = By.xpath("//select[@data-trigger = 'country-select']");
	private WebElement chooseCountryElement;
	
	private By chooseCity = By.id("BillingNewAddress_City");
	private WebElement chooseCityElement;
	
	private By address = By.id("BillingNewAddress_Address1");
	private WebElement addressElement;
	
	private By zipCode = By.id("BillingNewAddress_ZipPostalCode");
	private WebElement zipCodeElement;
	
	private By phoneNumber = By.id("BillingNewAddress_PhoneNumber");
	private WebElement phoneNumberElement;
	
	private By continueButton = By.xpath("(//button[@name='save'])[1]");
	private WebElement continueButtonElement;
	
	private By ground = By.id("shippingoption_0");
	private WebElement groundElement;
	
	private By nextDayAir = By.id("shippingoption_1");
	private WebElement nextDayAirElement;
	
	private By secondDayAir = By.id("shippingoption_2");
	private WebElement secondDayAirElement;
	
	private By continue2Button = By.className("shipping-method-next-step-button");
	private WebElement continue2ButtonElement;
	
	private By moneyOrder = By.id("paymentmethod_0");
	private WebElement moneyOrderElement;	
	
	private By creditCard = By.id("paymentmethod_1");
	private WebElement creditCardElement;		
	
	private By continue3Button = By.className("payment-method-next-step-button");
	private WebElement continue3ButtonElement;
	
	private By continue4Button = By.className("payment-info-next-step-button");
	private WebElement continue4ButtonElement;
	
	private By confirmButton = By.className("confirm-order-next-step-button");
	private WebElement confirmButtonElement;
	
	private By chickOutMsg = By.xpath("(//div[@class='title']//strong)[1]");
	private WebElement chickOutMsgElement;
	
	
	public void clickOnTermsOfServices() {
		termsOfServicesElement = driver.findElement(termsOfServices); 
		clicking(termsOfServicesElement);
	}
	public void clickOnCheckOutButton() {
		checkOutButtonElement = driver.findElement(checkOutButton);  
		clicking(checkOutButtonElement);
	}
	public void enterCity(String city) {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		chooseCityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(chooseCity)); 
		sendText(chooseCityElement, city);
	}
	public void enterAddress(String Address) {
	    addressElement = driver.findElement(address); 
		sendText(addressElement, Address);
	}
	public void enterZipCode(String ZipCode) {
	    zipCodeElement = driver.findElement(zipCode);  
		sendText(zipCodeElement, ZipCode);
	}
	public void enterPhoneNumber(String PhoneNumber) {
		phoneNumberElement = driver.findElement(phoneNumber);  
		sendText(phoneNumberElement, PhoneNumber);
	}
	public void chooseCountryByValue(String Country) {
		chooseCountryElement = driver.findElement(chooseCountry); 
		Select dropDown = new Select(chooseCountryElement);
		dropDown.selectByValue(Country);
	}
	public void clickContinue() {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		continueButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)); 
		clicking(continueButtonElement);
	}
	public void chooseShippingMethods(String ShippingMethod) {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    if (ShippingMethod == "ground") {
	    	groundElement = wait.until(ExpectedConditions.visibilityOfElementLocated(ground)); 
	 		clicking(groundElement);
	    }
	    else if (ShippingMethod == "next day air") {
		    nextDayAirElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nextDayAir));
			clicking(nextDayAirElement);
	    }else {
	    	secondDayAirElement = wait.until(ExpectedConditions.visibilityOfElementLocated(secondDayAir));
			clicking(secondDayAirElement);
	    }
	    continue2ButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(continue2Button)); 
		clicking(continue2ButtonElement);
	}
	public void choosePaymentMethods(String paymentMethod) {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    if (paymentMethod == "money order") {
	    	moneyOrderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(moneyOrder)); 
	 		clicking(moneyOrderElement);
	    }
	    else {
		    creditCardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(creditCard));
			clicking(creditCardElement);
	    }
	    continue3ButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(continue3Button)); 
		clicking(continue3ButtonElement);
	}
	public void paymentInformation() {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    continue4ButtonElement= wait.until(ExpectedConditions.visibilityOfElementLocated(continue4Button)); 
		clicking(continue4ButtonElement);
	}
	public void clickConfirm() throws InterruptedException {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		confirmButtonElement= wait.until(ExpectedConditions.visibilityOfElementLocated(confirmButton)); 
		clicking(confirmButtonElement);
		Thread.sleep(1000);
	}
	public String checkOutMessage() throws InterruptedException {
		chickOutMsgElement= wait.until(ExpectedConditions.visibilityOfElementLocated(chickOutMsg));
		System.out.println(chickOutMsgElement.getText());
		return chickOutMsgElement.getText();
		}
}
