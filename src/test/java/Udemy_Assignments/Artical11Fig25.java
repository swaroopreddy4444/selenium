package Udemy_Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Artical11Fig25 {

	public static void main(String[] args) {

				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				driver.get("https://www.hollisterco.com/shop/wd");
				List<WebElement> links = driver.findElements(By.xpath("//*[@class='icon-link-group-horizontal']//li//a"));
				
				for(WebElement link:links)
					System.out.println(link.getAttribute("aria-label")+" ==> "+link.getAttribute("href"));
	}

}
