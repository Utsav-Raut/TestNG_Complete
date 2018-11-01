package basics.testng;

import org.testng.annotations.Test;

public class Grouping {
  @Test(groups = { "Car" })
  public void car1() {
	  System.out.println("Batch car - Test Car 1");
  }
  
  @Test(groups = { "Car" })
  public void car2() {
	  System.out.println("Batch car - Test Car 2");
  }
  
  @Test(groups = { "Scooter" })
  public void scooter1() {
	  System.out.println("Batch scooter - Test scooter 1");
  }
  
  @Test(groups = { "Scooter" })
  public void scooter2() {
	  System.out.println("Batch scooter - Test scooter 1");
  }
  
  @Test(groups = { "Car", "Sedan Car" })
  public void sedan1() {
	  System.out.println("Batch sedan car - Test sedan car 1");
  }
}
