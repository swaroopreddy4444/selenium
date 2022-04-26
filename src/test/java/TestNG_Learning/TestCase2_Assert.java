package TestNG_Learning;

//import org.testng.Assert;  // used as HARD Assertions for blocking Test 
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2_Assert {

	@Test(groups={"high","med"})
	public void validateTitle() {
		String actualTitle="gmail.com";
		String ExpectedTitle="yahoo.com";
		
		SoftAssert asrt = new SoftAssert(); // to continue the test even assertion fails
		
		System.out.println("Begining of test");
		
		asrt.assertEquals(actualTitle, ExpectedTitle,"Titles Mismatch");
		asrt.assertTrue(false,"Element not found");
		asrt.fail("Failed Forcefully");
		
		System.out.println("Ending of test");
		
		asrt.assertAll(); // to show the FAILURES in test else Test is shown as PASSED
	}
}
