package Udemy_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utils.SelectBrowser;

public class RightclickTest extends SelectBrowser{

	public static void main(String[] args) throws InterruptedException {

		driver=getBrowser();
		driver.get("https://deluxe-menu.com/popup-mode-sample.html");
		WebElement img=driver.findElement(By.xpath("//*[@src='data-samples/images/popup_pic.gif']"));
		Actions a= new Actions(driver);
		a.contextClick(img).perform();
		a.moveToElement(driver.findElement(By.xpath("//*[@id=\"dm2m1i1tdT\"]"))).perform();
		a.moveToElement(driver.findElement(By.xpath("//*[@id=\"dm2m2i1tdT\"]"))).perform();
		a.moveToElement(driver.findElement(By.xpath("//*[@id=\"dm2m3i1tdT\"]"))).click().perform();
		a.click();
		
	}

}
