import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase{
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
    WebDriverWait wait ;

	
	private By registerButton = By.className("ico-register");
	private WebElement registerButtonElement; 

	private By loginButton = By.className("ico-login");
	private WebElement loginButtonElement; 
	
	private By myAccountButton = By.className("ico-account");
	private WebElement myAccountButtonElement;
	
	private By searchBox = By.xpath("//input[@type='text']");
	private WebElement searchBoxElement;
	
	private By searchButton = By.xpath("//button[@type='submit']");
	private WebElement searchButtonElement;
	
	private By customerCurrency = By.id("customerCurrency");
	private WebElement customerCurrencyElement;
	
	private By itemPrice = By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div > div.center-2 > div > div.page-body > div.search-results > div > div.products-wrapper > div > div > div:nth-child(1) > div > div.details > div.add-info > div.prices > span");
	private WebElement itemPriceElement;

	private By category = By.xpath("(//a[@href='/computers'])[1]");
	private WebElement categoryElement;
	
	private By subCategory = By.xpath("(//a[@href='/desktops'])[3]");
	private WebElement subCategoryElement;
	
	private By tag = By.xpath("//a[@href='/camera']");
	private WebElement tagElement;
	
	private By shoesTag = By.xpath("//a[text()='shoes']");
	private WebElement shoesTagElement;
	
	private By shoes = By.xpath("(//h2[@class='product-title'])[2] ");
	private WebElement shoesElement;
	
	private By greyColor = By.xpath("//li[@data-attr-value='27']//span//span");
	private WebElement greyColorElement;
	
	private By selectSize = By.xpath("//select[@data-attr='9']");
	private WebElement selectSizeElement;
	
	private By addToCartButton = By.className("add-to-cart-button");
	private WebElement addToCartButtonElement;
	
	private By addToWishlistButton = By.className("add-to-wishlist");
	private WebElement addToWishlistButtonElement;
	
	private By addToCompareListButton = By.className("compare-products");
	private WebElement addToCompareListButtonElement;
	
	private By successMsg = By.xpath("//p[@class='content']//a");
	private WebElement successMsgElement;
	
	
	public RegisterPage clickOnRegisterButton() {
		registerButtonElement = driver.findElement(registerButton);
		clicking(registerButtonElement);
		return new RegisterPage(driver);
	}
	public LoginPage clickOnLoginButton() {
		loginButtonElement = driver.findElement(loginButton);
		clicking(loginButtonElement);
		return new LoginPage(driver);
	}
	public MyAccountPage clickOnMyAccountButton() {
		myAccountButtonElement = driver.findElement(myAccountButton);
		clicking(myAccountButtonElement);
		return new MyAccountPage(driver);
	}
	
	public void enterSearchBox(String text) {
		searchBoxElement  = driver.findElement(searchBox);
		sendText(searchBoxElement, text);
	}
	
	public void clickOnSearcButton() {
		searchButtonElement  = driver.findElement(searchButton);
		clicking(searchButtonElement);
	}
	
	public String chooseCustomerCurrency(String currency) {
		customerCurrencyElement = driver.findElement(customerCurrency);
		Select dropdown = new Select(customerCurrencyElement);
		if(currency == "dollar") {
			dropdown.selectByVisibleText("US Dollar");
		}else {
			dropdown.selectByVisibleText("Euro");
		}
		itemPriceElement = driver.findElement(itemPrice);
		return itemPriceElement.getText();
	}
	
	public void chooseSubCategory() {
		categoryElement = driver.findElement(category);
		clicking(categoryElement);
		subCategoryElement = driver.findElement(subCategory);
		clicking(subCategoryElement);
	}
	
	public void chooseTag() {
		categoryElement = driver.findElement(category);
		clicking(categoryElement);
		tagElement = driver.findElement(tag);
		clicking(tagElement);
	}
	public void chooseShoes() {
		categoryElement = driver.findElement(category);
		clicking(categoryElement);
		
		shoesTagElement = driver.findElement(shoesTag);
		clicking(shoesTagElement);
		
		shoesElement = driver.findElement(shoes);
		clicking(shoesElement);
	}
	
	public void chooseColorItem() {
		chooseShoes();

		greyColorElement = driver.findElement(greyColor);
		clicking(greyColorElement);
	}
	
	public void chooseSizeShoes() {
		selectSizeElement = driver.findElement(selectSize);
		Select dropDown = new Select(selectSizeElement);
		dropDown.selectByVisibleText("11");
	}
	
	public String addToCart() {
		chooseColorItem();
		chooseSizeShoes();
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout

		addToCartButtonElement = driver.findElement(addToCartButton);
		clicking(addToCartButtonElement);

		successMsgElement= wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
		return successMsgElement.getText();
	}
	
	public String addToWishlist() {
		chooseColorItem();
		chooseSizeShoes();
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
	    
		addToWishlistButtonElement = driver.findElement(addToWishlistButton);
		clicking(addToWishlistButtonElement);

		successMsgElement= wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
		return successMsgElement.getText();
	}
	
	public String compareProducts() {
		chooseColorItem();
		chooseSizeShoes();
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
	    
		addToCompareListButtonElement = driver.findElement(addToCompareListButton);
		clicking(addToCompareListButtonElement);

		successMsgElement= wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
		return successMsgElement.getText();
	}
	
	public void clickOnAddToCartButton() {
		addToCartButtonElement = driver.findElement(addToCartButton);
		clicking(addToCartButtonElement);
	}
	
	public CartPage clickOnAddToShoppingCart() {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
		successMsgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)); //click on cartList
		clicking(successMsgElement);
		return new CartPage(driver);

	}
}
