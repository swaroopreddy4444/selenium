package TestNG_Learning;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1_Annotations {

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Launching Chrome");
	}
	
	@AfterMethod
	public void closeBrowser() {
		System.out.println("Closing browser");
	}
	
	@Test(priority = 2,groups= {"low","med"})
	public void doLogin1() {
		Reporter.log("Inside doLogin Method logging");
		System.out.println("Executing Login test");
	}

	@Test(priority = 1,groups= "high")
	public void doUserReg1() {

		System.out.println("Reg User test");
		Reporter.log("Inside doUserReg Method logging");
	}
	
	@BeforeTest
	public void getDBconnection() {
		System.out.println("Start DB Connection");
	}
	@AfterTest
	public void closeDBconnection() {
		System.out.println("closing DB Connection");
	}
}
