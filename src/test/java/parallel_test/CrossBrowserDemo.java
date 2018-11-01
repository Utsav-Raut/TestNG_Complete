package parallel_test;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class CrossBrowserDemo {
	
	public WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) {

//		Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")) {
			//Create firefox instance
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver");
			FirefoxOptions opt = new FirefoxOptions();
			opt.addArguments("--start-maximized");
			opt.addArguments("--disable-infobars");
			driver = new FirefoxDriver(opt);
		}
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--start-maximized");
			opt.addArguments("--disable-infobars");
			driver = new ChromeDriver(opt);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
	}
	@Test
	public void testParameterWithXML() throws InterruptedException{
		driver.get("http://demo.guru99.com/V4/");
		//Find user name
		WebElement userName = driver.findElement(By.name("uid"));
		//Fill user name
		userName.sendKeys("guru99");
		//Find password
		WebElement password = driver.findElement(By.name("password"));
		//Fill password
		password.sendKeys("guru99");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
