package Udemy_Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://timesofindia.indiatimes.com/poll.cms");

		List<WebElement> Radios = driver.findElements(By.xpath("//*[contains(@type,'radio')]"));

		for (WebElement Radio : Radios)
			Radio.click();
		
		String Captcha = driver.findElement(By.id("mathq2")).getText();
		String[] values = Captcha.split(" ");
//		System.out.println(Arrays.toString(values));
		int num1= Integer.valueOf(values[0]);
		int num2= Integer.valueOf(values[2]);
		char operator =  values[1].charAt(0); 
		
		int result = 0;
		
		switch (operator) {     // String not supported switch key (operator) in java 1.5
		case '+':
			result=num1+num2; break;
		case '-':
			result=num1-num2; break;
		case '*':
			result=num1*num2; break;
		case '/':
			result=num1/num2;  break;
		default : break;
		
		}
		driver.findElement(By.id("mathuserans2")).sendKeys(Integer.toString(result));
	}

}
