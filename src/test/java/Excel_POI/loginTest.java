package Excel_POI;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginTest {

	public static void main(String[] args) {

	WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://gmail.com");
	String expected_Value="Gmail";
	String actual_value =driver.getTitle();
	Assert.assertEquals(expected_Value, actual_value,"Titles Mismatch");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.getElementById('identifierId').value='swaroopreddy4444@gmail.com'");
	
	
	}

}
