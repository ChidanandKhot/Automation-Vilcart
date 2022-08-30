package Dmodule;

import java.util.concurrent.TimeUnit;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Place_order {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.get("http://localhost:4200/");
		driver.get("https://vilcart-buy.web.app/");
		String title = driver.getTitle();
		System.out.println("you are my : "+ title);
					
		//System.out.println("You are printed and completed"); 
		
		driver.findElement(By.id ("usr")).sendKeys("user1@uat.com");
		driver.findElement(By.xpath ("//button[@type='submit']")).sendKeys("123456");
		
		//driver.findElement(By.xpath(" //button[@type='submit']")).click();
	
	}
}

////button[@type='submit']
// type='password'
