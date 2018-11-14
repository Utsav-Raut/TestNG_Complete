package tdd_demo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CRMLoginDemo {
	
	WebDriver driver;

	@DataProvider(name = "getExcelData")
	public String[][] getData() throws IOException{
		ExcelReadImplementation read = new ExcelReadImplementation();
		String excelPath = System.getProperty("user.dir") + "/test-data";
		return read.getCellData(excelPath, "Test_Data.xlsx", 0);
	}
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "/home/boom/Pictures/geckodriver");
		FirefoxOptions opt = new FirefoxOptions();
		opt.addArguments("--disable-infobars");
		opt.addArguments("--start-maximized");
		driver = new FirefoxDriver(opt);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://freecrm.com/");
	}
	
	@Test(testName = "CRM login Test",  dataProvider = "getExcelData")
	public void loginToCRM(String username, String password) throws InterruptedException {
		Thread.sleep(6000);
		System.out.print(username + " --> " + password);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.getTitle().equals("CRMPRO"));
		Thread.sleep(3000);
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Shutting down the driver");
		driver.quit();
	}
}
