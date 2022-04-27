package TestNG_Learning;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase3_DependsOn {

	@Test(priority = 1,groups= {"low","med"})
	public void doUserReg3() {
		System.out.println("User registering");
		Assert.fail("Registration failed");
	}
	
	@Test(priority = 2,dependsOnMethods = {"doUserReg3"}, groups= {"low"})
	public void doLogin3() {
		System.out.println("Login processing");
		
	}
	@Test(priority = 3,groups={"high"})
	public void isSkip() {
		if(true /*Condition*/ ) {
		throw new SkipException("User already registered");
		}
	}
}
