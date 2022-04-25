package Udemy_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utils.SelectBrowser;

public class JqueryResizable extends SelectBrowser{

	public static void main(String[] args) {

		driver=getBrowser();
		driver.get("https://jqueryui.com/resources/demos/resizable/default.html");

		WebElement resizable=driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));

		Actions a=new Actions(driver);
		a.dragAndDropBy(resizable, 800,400).perform();
	}
}
