package parameterization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProviders {
	
	public static WebDriver driver;
	public String url = "https://freecrm.com/";
	
	@DataProvider(name = "Authentication")
	public static Object[][] credentials(){
		return new Object[][] { 
			{"utsavr", "utsav123"},
			{"kaustabh", "kaustabh123"}
		};
	}
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "/home/boom/Pictures/geckodriver");
		FirefoxOptions opt = new FirefoxOptions();
		opt.setAcceptInsecureCerts(true);
		opt.addArguments("--start-maximized");
		opt.addArguments("--disable-infobars");
		driver = new FirefoxDriver(opt);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@Test(dataProvider = "Authentication")
	public void loginToCRM(String username, String password) throws InterruptedException{
		Thread.sleep(6000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("This is over");
		driver.quit();
	}
	

}
