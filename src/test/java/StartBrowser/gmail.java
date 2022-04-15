package StartBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class gmail {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		ChromeOptions options = new ChromeOptions().setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
//		WebDriver driver = new ChromeDriver(options);

		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		Thread.sleep(8000);
//		driver.manage().window().minimize();
//		Thread.sleep(4000);
//		driver.manage().window().fullscreen();
//		Thread.sleep(5000);
		
		
		WebElement username= driver.findElement(By.id("identifierId"));
		username.sendKeys("swaroopreddy4444");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		
		Thread.sleep(4000);
		driver.close();
		
	}

}
