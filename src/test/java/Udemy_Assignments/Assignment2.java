package Udemy_Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://qa.way2automation.com/");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText("Signin")));
		driver.findElement(By.name("name")).sendKeys("super");
		
		driver.findElement(RelativeLocator.with(By.className("button")).toRightOf(By.partialLinkText("Signin"))).click();
	
	}
}