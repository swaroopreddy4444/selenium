package Udemy_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utils.SelectBrowser;

public class Way2auto_MouseOver extends SelectBrowser{

	public static void main(String[] args) {

		driver=getBrowser("chrome", 15);
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("way2automation",Keys.ENTER);
		driver.findElement(By.xpath("(//cite)[1]")).click();
		WebElement res=driver.findElement(By.xpath("(//span[text()='Resources'])[1]"));
		
		Actions a= new Actions(driver);
		a.moveToElement(res).perform();
		
		driver.findElement(By.xpath("(//*[text()='Practice Site 2'])[1]")).click();

	}

}
