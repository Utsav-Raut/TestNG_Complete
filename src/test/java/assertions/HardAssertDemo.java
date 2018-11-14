package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertDemo {
	
	@Test
	public void hardAssert() {
		System.out.println("This one will print");
		Assert.assertTrue(false);
		System.out.println("I KNOW THIS WILL NOT GET PRINTED");
	}

}
