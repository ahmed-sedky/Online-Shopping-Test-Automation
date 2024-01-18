import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBase {
	protected WebDriver driver;
	public PageBase(WebDriver driver) {
		this.driver = driver;
	}
	public static void clicking(WebElement element) {
		element.click();
	}
	public static void sendText(WebElement element, String text) {
		element.sendKeys(text);
	}
	public  String getHomePageUrl() {
		return "https://demo.nopcommerce.com/";
	}
}
