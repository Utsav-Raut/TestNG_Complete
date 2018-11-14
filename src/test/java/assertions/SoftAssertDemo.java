package assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {
	
	@Test
	public void softAssert() {
		SoftAssert softAssertion = new SoftAssert();
		
		System.out.println("This will print");
		softAssertion.assertTrue(false);
		System.out.println("This will also print");
		softAssertion.assertAll();
		System.out.println("Let's be sure about this");	//This does not get printed since it comes after assertAll()
	}

}
