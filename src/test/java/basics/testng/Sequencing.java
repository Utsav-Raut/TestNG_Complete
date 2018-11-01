package basics.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Sequencing {
  @Test
  public void testCase1() {
	  System.out.println("This is test case 1");
  }
  
  @Test
  public void testCase2() {
	  System.out.println("This is test case 2");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This will execute before every method");
  }
  

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This will execute after every method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("This will execute before every class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This will execute after every class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This will execute before every test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This will execute after every test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This will execute before every suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This will execute after every suite");
  }

}
