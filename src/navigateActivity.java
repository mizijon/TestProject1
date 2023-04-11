import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigateActivity {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\khilo\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		navigateEbay(); 
		//elementStatus();	
	}
	
	
public static void navigateEbay() {
	WebDriver driver = new ChromeDriver();
	//maximize window. implicitly wait for 5 seconds.
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//  go to ebay.com.   search coffee mug
	driver.get("https://ebay.com");
	WebElement searchBox = driver.findElement(By.xpath("//input[@id='gh-ac']"));
	searchBox.sendKeys("Cofee Mug" + Keys.ENTER);
	// find all the results and store them in a list of webelements.
	  List<WebElement> coffeeMugs = driver.findElements(By.xpath("//span[@class='s-item__price']"));
	//loop through all those and get the prices of each item and print it out. 
	  
	 for (WebElement mug : coffeeMugs) {
	  WebElement priceElement = mug.findElement(By.xpath("./ancestor::div[@class='s-item__info clearfix']//span[@class='s-item__price']"));
	  String price = priceElement.getText();
	  System.out.println(price);
	    }
	 driver.quit();
}
	public static void elementStatus() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://indeed.com");
		
		 //check if the search fields are enabled and displayed.
		WebElement whatField = driver.findElement(By.id("text-input-what"));
		WebElement whereField = driver.findElement(By.id("text-input-where"));
		
		System.out.println(whatField.isEnabled());
		System.out.println(whatField.isDisplayed());
		
		System.out.println(whereField.isEnabled());
		System.out.println(whereField.isDisplayed());
		
		
		
		if (whatField.isEnabled() && whatField.isDisplayed()) {
			System.out.println("What field is enabled and displayed!");
		}else {
			System.out.println("What field is either not enabled or displayed!");
		}
		if (whereField.isEnabled() && whereField.isDisplayed()) {
			System.out.println("Where field is enabled and displayed!");
		}else {
			System.out.println("Where field is either not enabled or displayed!");
		}
		driver.quit();
	}
}
