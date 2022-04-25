package Udemy_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import Utils.SelectBrowser;

public class MakeMyTrip_Ajax extends SelectBrowser{

	public static void main(String[] args) throws InterruptedException {
		
		driver=getBrowser("chrome",25);

		driver.get("https://www.makemytrip.com/");

		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	    Actions a=new Actions(driver);
	    a.click().perform();
//		driver.findElement(By.xpath("//li[@data-cy='account']")).click();

		driver.findElement(By.cssSelector(".lbl_input.latoBold.appendBottom5")).click();
		driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).sendKeys("MUMBAI",Keys.DOWN,Keys.ENTER);
			
	}

}
