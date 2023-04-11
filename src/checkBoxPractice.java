import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkBoxPractice {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\khilo\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://practice.primetech-apps.com/practice/check-box");
		
		driver.findElement(By.xpath("//button[@class='accordion-button collapsed']")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		WebElement textBox = driver.findElement(By.cssSelector("#text-box"));
		WebElement checkBox = driver.findElement(By.cssSelector("#check-box"));
//		Test case 2.
//        go to http://practice.primetech-apps.com/practice/radio-button
//       Find those available radio buttons.
//Check if it's displayed and enabled,  if true, check if it's selected, if false select the button and check if it's selected.
		WebElement radioButton = driver.findElement(By.xpath("//button[@id='radio-button']"));
		
		if (radioButton.isEnabled() || radioButton.isDisplayed() ) {
			System.out.println("Radio Button is enabled and displayed!");
		}else {
			System.out.println("Radio Button is either not enabled or displayed!");
		}
		
		WebElement webTables = driver.findElement(By.cssSelector("#web-tables"));
		WebElement buttons = driver.findElement(By.cssSelector("#buttons"));
		WebElement links = driver.findElement(By.cssSelector("#links"));
		WebElement brokenLinksAndImages = driver.findElement(By.cssSelector("#broken-links-and-images"));
		WebElement uploadAndDownload = driver.findElement(By.cssSelector("#upload-and-download"));
		WebElement dynamicProperties = driver.findElement(By.cssSelector("#dynamic-properties"));
		
		WebElement checkBoxTitle = driver.findElement(By.xpath("//div[@class='title']"));
		WebElement languages = driver.findElement(By.xpath("//h5"));
		WebElement javaLang = driver.findElement(By.xpath("//label[@for='Java']"));
		WebElement javaScript = driver.findElement(By.xpath("//label[@for='JavaScript']"));
		javaLang.click();
		javaScript.click();
	}

}
