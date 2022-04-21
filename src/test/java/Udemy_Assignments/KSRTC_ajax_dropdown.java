package Udemy_Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KSRTC_ajax_dropdown {
	public static void main(String[] args) {

			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

			driver.get("https://ksrtc.in/oprs-web/");
			driver.findElement(By.id("fromPlaceName")).sendKeys("BENG");
			driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN,Keys.DOWN);
			System.out.println(driver.findElement(By.id("fromPlaceName")).getAttribute("value"));
	}

}
