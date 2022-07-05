package Udemy_Assignments;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HDFC_Exercise1 {

	public static void main(String[] args) {

		ChromeOptions ops= new ChromeOptions();
		ops.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(ops);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://www.hdfc.com/");
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.linkText("Blogs")));
//		driver.findElement(By.linkText("Blogs")).click();
		
		Iterator<String> iter = driver.getWindowHandles().iterator();
		
		String parentId =iter.next();
		String childId =iter.next();

		driver.switchTo().window(childId);
		System.out.println(driver.getTitle()+"-->"+driver.getCurrentUrl());
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle()+"-->"+driver.getCurrentUrl());
		
		String openinnewtab = Keys.chord(Keys.CONTROL,Keys.ENTER);
		
		driver.findElement(By.linkText("Careers")).sendKeys(openinnewtab);		
	}

}
