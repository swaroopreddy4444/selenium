package mar01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class launchchrome {

	public static void main(String[] args) {

	//	System.setProperty("webdriver.chrome.driver","C://selenium_driver/chromedriver_win32/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		
		WebDriver wb =new ChromeDriver();
		
		wb.get("https://mail.google.com");
		wb.findElement(By.id("identifierId")).sendKeys("swaroopreddy4444");
		
	}

}