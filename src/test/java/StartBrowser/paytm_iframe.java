package StartBrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class paytm_iframe {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://paytm.com");
		driver.findElement(By.xpath("//*[contains(text(),'Paytm for Consumer')]")).click();
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		Thread.sleep(3000);
		System.out.println("No of frames--> "+driver.findElements(By.tagName("iframe")).size());
		
	}

}
