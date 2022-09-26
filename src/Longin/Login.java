package Longin;

import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Reporter;
//import com.vilcart.util.AngularWait;


public class Login {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://vilcart-buy.web.app/");
		driver.manage().window().maximize(); 
		
	  	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	  	Reporter.log(driver.getTitle(), true);
//	  	JavascriptExecutor js = ((JavascriptExecutor) driver);
//	  	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	  	Longin.AngularWait aw = new AngularWait(driver);
//	
		driver.findElement(By.id ("usr")).sendKeys("user1@uat.com");
		driver.findElement(By.cssSelector("input[ng-reflect-name=password]")).sendKeys("123456");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String title = "Login - VILCART";
		String capture = driver.getTitle();
		
		if (title.equals(capture)) {
			System.out.println("Login Testcase passed sucessfully");
		}
		else {
			System.out.println("Login Test Case Fail");
		}			
		
		driver.close();
	}
	

}
//By.cssSelector("input[ng-reflect-name=password]")
