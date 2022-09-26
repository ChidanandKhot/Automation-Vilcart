package vilcart.app;

import org.testng.annotations.Test;

import com.vilcart.util.AngularWait;
//import com.vilcart.util.Login;
//import com.vilcart.util.LoginFile;
import com.vilcart.util.LoginTest;

import io.github.bonigarcia.wdm.WebDriverManager;

//import com.vilcart.util.AngularWait;
//import com.vilcart.util.Login;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.math3.analysis.function.Log;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
//import org.openqa.selenium.WebDriver.manage();

public class CreateSKU {
	
	    private WebDriver driver;
	    private JavascriptExecutor js;
	    private AngularWait aw;
	    private WebDriverWait wait;
//		private LoginNew LoginObj4;
		private LoginTest loginObj;
	    XSSFWorkbook workbook;
	    XSSFSheet sheet;
	    XSSFCell cell;
//	    loginObj login;
	
	
  @Test
  public void f() throws IOException, InterruptedException {
	    
	  loginObj.logintest();
	  WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"main-menu-content\"]/div[1]/input"));
	  mainMenu.sendKeys("SKU"); 
	  mainMenu.sendKeys(Keys.ENTER);

	  WebElement clickSKU = driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li/a"));
	  clickSKU.click();
	  WebElement AddSKU  = driver.findElement(By.xpath("//*//button[@type=\"button\"]"));
      AddSKU.click();
	  
      WebElement hsnCode = driver.findElement(By.xpath("//*[@id=\'itemHSNCode']"));
      hsnCode.sendKeys("112233");
      
      FileInputStream fs = new FileInputStream("properties\\Login credential for buy.xlsx");
      XSSFWorkbook workbook = new XSSFWorkbook(fs);
		DataFormatter formatter = new DataFormatter();
		XSSFSheet sheet = workbook.getSheetAt(1);
		Row row = sheet.getRow(1);
		
		 XSSFCell SkuName = (sheet.getRow(1).getCell(1));
		 String SkuNameString = SkuName.toString();
//		System.out.println(sheet.getRow(1).getCell(1));
		
//		WebElement SkuName1 = driver.findElement(By.xpath("//div[3]//div[1]//div[1]//input[1]"));   //Vilcart-buy 
		WebElement SkuName1 = driver.findElement(By.xpath("//input[@id='skuName']"));
        SkuName1.sendKeys(SkuNameString); 
        
        XSSFCell SkuLocalName = (sheet.getRow(1).getCell(2));
		 String SkuLocalNameString = SkuLocalName.toString();
//		WebElement localSkuName = driver.findElement(By.xpath("//div[3]//div[1]//div[1]//input[1]")); //Vilcart-buy 
		WebElement skuLocalName = driver.findElement(By.xpath("//input[@id='localName']"));
		skuLocalName.sendKeys(SkuLocalNameString);           
		//local name entered
		
		
		XSSFCell description = (sheet.getRow(1).getCell(3));
		String descriptionField = description.toString();
		WebElement descriptionsku = driver.findElement(By.xpath("//*[@id=\'description\'] "));
		descriptionsku.sendKeys(descriptionField);
		
		
		  JavascriptExecutor j = (JavascriptExecutor) driver;
	      j.executeScript("window.scrollBy(0,500)");
		
		WebElement categoryDropdown = driver.findElement(By.xpath("//*[@id=\'category\']/div/div/div[3]/input "));
		categoryDropdown.click();	
		
		WebElement categorySelect = driver.findElement(By.xpath("//*[@id=\"category\"]/ng-dropdown-panel/div/div[2]/div[3]/span"));
		categorySelect.click();
		
		
//		Select select = new Select(categoryDropdown);
//		  select.selectByValue("SUGAR");  //select.selectByIndex(2); 
//		Thread.sleep(1000);
//		 Select s = new Select(driver.findElement(By.xpath("//select[@name=’selType’]")));
		
		
		WebElement subCategory = driver.findElement(By.xpath("//*[@id=\"subCategory\"]/div/div/div[2]/input"));
		subCategory.click();
		
		WebElement subCategorySelect = driver.findElement(By.xpath("//*[@id=\"subCategory\"]/ng-dropdown-panel/div/div[2]/div[1]/span"));
		subCategorySelect.click();
		
		WebElement gstRate = driver.findElement(By.xpath("//*[@id=\"gstRate\"]"));
	      gstRate.sendKeys("5");		
	      
	     WebElement brandName = driver.findElement(By.xpath("//*[@id=\"brandName\"]/div/div/div[2]/input"));
	     brandName.sendKeys("ITC");
	     brandName.sendKeys(Keys.ENTER);
	     
	     WebElement AddVariation = driver.findElement(By.xpath("//span[@id='variationButton']"));
	     AddVariation.click();

	     WebElement primaryVariation = driver.findElement(By.xpath("//*[@id=\"textbox2\"]"));
	     primaryVariation.sendKeys("Box(40 Pkt)");
	     
	     WebElement primaryPrice = driver.findElement(By.xpath("//*[@id=\"price\"]"));
	     primaryPrice.sendKeys("500");

	     WebElement secondaryVariation = driver.findElement(By.xpath("//span[@id='variationButton']"));
	     secondaryVariation.click();
	     
//	     WebElement primaryVariation = driver.findElement(By.xpath("//*[@id=\"textbox2\"]"));
//	     primaryVariation.sendKeys("Box(40 Pkt)");             // //*[@id="textbox2"]
	     
	     
	     
	     JavascriptExecutor k = (JavascriptExecutor)driver;
			k.executeScript("window.scrollBy(0,-800)");
			
			
		 WebElement saveButton = driver.findElement(By.xpath("//button[@id=\"saveButton\"]"));
		 saveButton.click();
			      
//		WebElement s = (WebElement) new Select(driver.findElement(By.xpath("//*[@id=\\\"category\\\"]/div/div/div[3]/input")));
//		Select select = new Select(s);
//		select.selectByIndex(2);
		
  }
  @BeforeTest
  public void beforeTest() throws IOException {
	 
	  System.setProperty("webdriver.chrome.driver","F:\\webdriver\\chromedriver.exe" );
		driver = new ChromeDriver();
//		driver.get("https://vilcart-buy.web.app/");
		driver.get("http://localhost:4200/");
		driver.manage().window().maximize();
		driver.manage().window().maximize(); 
	  	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  	Reporter.log(driver.getTitle(), true);
	  	js=((JavascriptExecutor) driver);
	  	wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  	aw = new AngularWait(driver);
	  	loginObj = new LoginTest(driver,aw);       
	  
  }


@AfterTest
  public void afterTest() {
  }

};

