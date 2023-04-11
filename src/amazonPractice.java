import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazonPractice {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\khilo\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		 amazonSignIn();
	}
		public static void amazonSearch() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
		searchBox.sendKeys("Cofee Mug" + Keys.ENTER);
		driver.navigate().back();
		
		WebElement newsearchBox = driver.findElement(By.xpath("//input[@type='text']"));
		newsearchBox.sendKeys("Pretty Cofee Mug" + Keys.ENTER);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
		Thread.sleep(1000);
		driver.navigate().refresh();
		
		driver.quit();
	}
		public static void amazonSignIn() throws InterruptedException {
//		  go to amazon.com    click on signin 
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		driver.findElement(By.id("nav-link-accountList")).click();
	    
//	verify that you are on sign in page (either by sign-in text or email field).
		if(driver.findElement(By.id("ap_email")).isDisplayed()){
			System.out.println("I am On Sign-In page.");
		}else {
			System.out.println("I am not On Sign-In page.");
		}
//	   navigate back, and navigate forward
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
		if(driver.findElement(By.id("ap_email")).isDisplayed()){
			System.out.println("I am On Sign-In page for secon time.");
		}else {
			System.out.println("I am not On Sign-In page for second time.");
		}
//	    click on create new account, verify you are on new account create page.
        driver.findElement(By.id("createAccountSubmit")).click();
        WebElement createAccountText = driver.findElement(By.xpath("//h1[contains(text(), 'Create account')]"));
        if(createAccountText.isDisplayed()) {
        	System.out.println("I am on 'Create Account' page");
        }else {
			System.out.println("I am on not 'Create Account' page");
		}
        //navigate back, verify you are on the sign-in page.
        driver.navigate().back();
        if(driver.findElement(By.id("ap_email")).isDisplayed()){
			System.out.println("I am On Sign-In page for third  time.");
		}else {
			System.out.println("I am not On Sign-In page for third time.");
		}

        //navigate forward, verify you are on the create account page
	    driver.navigate().forward();
	    if(driver.findElement(By.xpath("//h1[contains(text(), 'Create account')]")).isDisplayed()) {
        	System.out.println("I am on 'Create Account' page 2nd time");
        }else {
			System.out.println("I am on not 'Create Account' page");
		}
	   // click on the Continue button without filling the form
	      driver.findElement(By.id("continue")).click();

//	 verify error messages displayed and get text to verify:
	      // Enter your name
		  WebElement nameErrorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Enter your name')]"));
		      
		  if (nameErrorMessage.isDisplayed()) {
			  if (nameErrorMessage.getText().equals("Enter your name")) {
		        System.out.println("Name Error messages displayed and matches");
		      } else {
		        System.out.println("Name Error messages does not displayed or match");
		      }
		  
//	 verify error messages displayed and get text to verify:
			  WebElement emailErrorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Enter your email')]"));
		      
			  if (emailErrorMessage.isDisplayed()) {
				  if (emailErrorMessage.getText().equals("Enter your email")) {
			        System.out.println("Email Error messages displayed and matches");
				  }else {
			        System.out.println("Email Error messages does not displayed or match");
			      }  
			  }
		     //Minimum 6 characters required 
			 WebElement passwordErrorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Minimum 6 characters required')]"));
			      
				  if (passwordErrorMessage.isDisplayed()) {
					  if (passwordErrorMessage.getText().equals("Minimum 6 characters required")) {
				        System.out.println("Password Error messages displayed and matches");
				      } else {
				        System.out.println("Password Error messages does not displayed or match");
				      }  
				  }
		      Thread.sleep(500);
		     driver.quit();
}
}
}