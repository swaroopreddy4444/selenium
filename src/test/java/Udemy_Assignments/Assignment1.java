package Udemy_Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.co.in/");
		
		driver.findElement(By.name("q")).sendKeys("way2automation");
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.xpath("//a[@href='https://www.way2automation.com/']")).click();
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		System.out.println("Total links: "+links.size());
		
		for(WebElement link:links)
			System.out.println((link.getText()!=""?link.getText():"null")+"\t"+link.getAttribute("href"));
	}

}
