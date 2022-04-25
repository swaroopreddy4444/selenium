package Udemy_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utils.SelectBrowser;

public class MovebyOffSet extends SelectBrowser {

	public static void main(String[] args) {

		driver = getBrowser();
		driver.get("https://www.google.co.in/");
		WebElement gmail = driver.findElement(By.linkText("Gmail"));
		
		int x = gmail.getRect().getX();
		int y = gmail.getRect().getY();
		
		Actions a = new Actions(driver);
		a.moveByOffset(x, y).click().perform();

	}

}
