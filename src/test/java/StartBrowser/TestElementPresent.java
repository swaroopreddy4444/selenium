package StartBrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestElementPresent {

	public static WebDriver driver;

	public static boolean iselementpresent(By by) {

		if (driver.findElements(by).size() > 0) 
			return true;
		else
			return false;
	}

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.wikipedia.org");
		
		System.out.println(iselementpresent(By.xpath("//*[@id='searchLanguage']")));
	}

}
