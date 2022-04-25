package Udemy_Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.SelectBrowser;

public class yahoo_ajax extends SelectBrowser{

	public static void main(String[] args) {

		driver=getBrowser("chrome", 25);
		
		driver.get("https://in.search.yahoo.com/");
		driver.findElement(By.id("yschsp")).sendKeys("hello");
		List<WebElement> options= driver.findElements(By.xpath("//li[@class='sa-item prog-sugg']"));
		
		for(WebElement option:options)
			System.out.println(option.getText());
	}

}
