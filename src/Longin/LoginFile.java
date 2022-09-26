package Longin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Table.Cell;
import com.vilcart.util.AngularWait;

public class LoginFile {
	
	XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    WebDriver driver;
    AngularWait aw;
		
    public void Login(WebDriver driver, AngularWait aw) {
    	this.driver = driver;
    	this.aw = aw;
    }
     
//		public Login(WebDriver driver, AngularWait aw) {
//	    	this.driver = driver;
//	    	this.aw = aw;
//	    }
	
	public void main(String[] args) throws IOException {
		
		
		System.setProperty("webdriver.chrome.driver","F:\\webdriver\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		driver.get("https://vilcart-buy.web.app/");
//				
		//Path of the excel file
		FileInputStream fs = new FileInputStream("properties\\Login credential for buy.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		DataFormatter formatter = new DataFormatter();
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		
		 XSSFCell email = (sheet.getRow(0).getCell(0));
		 String value = email.toString();
		//Cell cell = (Cell) row.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));
		driver.findElement(By.cssSelector("input[ng-reflect-name=email]")).sendKeys(value);
		
		XSSFCell password = (sheet.getRow(0).getCell(1));
//		 double value2 = password.getNumericCellValue();
		
//		DataFormatter formatter = null;
		String value2 = formatter.formatCellValue(password);
		
		 driver.findElement(By.cssSelector("input[ng-reflect-name=password]")).sendKeys(value2);
//		 System.out.println(sheet.getRow(0).getCell(1));
		 
		 driver.findElement(By.xpath("//button[@type='submit']" )).click();
		 		 
		
		String title = driver.getTitle();
		String ActualTitle = "Login - VILCART";
		
		if (title.equals(ActualTitle)) {
			System.out.println("Login testcase passed successfully11");
		}
		else {
			System.out.println("Login testcase failed");
		}
		
//		driver.close();
	}
}

