package basics.testng;

import org.testng.annotations.Test;

public class Dependent {
	
	@Test(dependsOnMethods = { "openBrowser" })
	public void signIn() {
		System.out.println("This will execute second sign-in");
	}
	
	@Test
	public void openBrowser() {
		System.out.println("This will execute the first (Open Browser)");
	}
	
	@Test(dependsOnMethods = { "signIn" })
	public void logout() {
		System.out.println("This will execute third");
	}
	

}
