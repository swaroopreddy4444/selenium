package Javalaya_assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkboxQAdemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/checkbox");
		driver.findElement(By.xpath("//*[text()='Home']/../../button[@aria-label='Toggle']")).click();
		driver.findElement(By.xpath("//*[text()='Desktop']/../../button[@aria-label='Toggle']")).click();
		driver.findElement(By.xpath("//*[text()='Notes']/..//span")).click();
	}

}
