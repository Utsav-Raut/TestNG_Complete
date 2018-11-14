package parameterization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParams {
	
	public static WebDriver driver;
	public String url = "https://www.freecrm.com/";
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "/home/boom/Pictures/geckodriver");
		FirefoxOptions ffOp = new FirefoxOptions();
		ffOp.addArguments("--start-maximized");
		ffOp.addArguments("--disable-infobars");
		driver = new FirefoxDriver(ffOp);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		
	}
	
	
	@Test
	@Parameters({ "sUserName", "sPassword" })
	public void test(String sUserName, String sPassword) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(sUserName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(sPassword);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

}
