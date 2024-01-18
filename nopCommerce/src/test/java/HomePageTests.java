import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends LoginBase{

	@Test (priority = 1)
	public void searchTest() throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.enterSearchBox("cell Phones");
		homePage.clickOnSearcButton();
		String actualUrl = driver.getCurrentUrl();
		String ExpectedUrl = "https://demo.nopcommerce.com/search";
		Assert.assertTrue(actualUrl.contains(ExpectedUrl));
		Thread.sleep(1000);
	}
	
	@Test (priority = 2)
	public void changeCurrencyTest() throws InterruptedException {
		homePage = new HomePage(driver);
		String actualcurrency = homePage.chooseCustomerCurrency("euro");
		String expectedcurrency = "€";
		Assert.assertTrue(actualcurrency.contains(expectedcurrency));
		Thread.sleep(1000);
	}
	
	@Test (priority = 3)
	public void subCategoryTest() throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.chooseSubCategory();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://demo.nopcommerce.com/desktops";
		System.out.println(actualUrl);
		Assert.assertEquals(actualUrl,expectedUrl);
		Thread.sleep(1000);
	}
	
	@Test (priority = 4)
	public void tagTest() throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.chooseTag();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://demo.nopcommerce.com/camera";
		Assert.assertEquals(actualUrl,expectedUrl);
		Thread.sleep(1000);
	}
	
	@Test (priority = 5)
	public void chooseByColorTest() throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.chooseColorItem();
		Thread.sleep(1000);
	}
	
	@Test (priority = 6)
	public void addToCartTest() throws InterruptedException {
		homePage = new HomePage(driver);
		String ActualMsg = homePage.addToCart();
		String expectedMsg = "shopping cart";
		Assert.assertTrue(ActualMsg.contains(expectedMsg));

		Thread.sleep(3000);
	}
	
	@Test (priority = 7)
	public void addToWishListTest() throws InterruptedException {
		homePage = new HomePage(driver);
		String ActualMsg = homePage.addToWishlist();
		String expectedMsg = "wishlist";
		Assert.assertTrue(ActualMsg.contains(expectedMsg));

		Thread.sleep(3000);
	}
	
	@Test (priority = 8)
	public void addToCompareListTest() throws InterruptedException {
		homePage = new HomePage(driver);
		String ActualMsg = homePage.compareProducts();
		String expectedMsg = "product comparison";
		Assert.assertTrue(ActualMsg.contains(expectedMsg));

		Thread.sleep(3000);
	}
	
}
