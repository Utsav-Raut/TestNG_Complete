package prioritizing_sequencing;

import org.testng.annotations.Test;

public class MultipleTest {
  @Test(priority = 0)
  public void One() {
	  System.out.println("This is test case 1");
  }
  
  @Test(priority = 1)
  public void Two() {
	  System.out.println("This is test case 2");
  }
  
  @Test(priority = 2)
  public void Three() {
	  System.out.println("This is test case 3");
  }
  
  @Test(priority = 3) 
  public void Four() {
	  System.out.println("This is test case 4");
  }
}
