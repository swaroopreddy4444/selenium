package Udemy_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utils.SelectBrowser;

public class DragAndDrop extends SelectBrowser{

	public static void main(String[] args) {

		driver=getBrowser();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		WebElement drag= driver.findElement(By.xpath("//*[@id='draggable']"));
		WebElement drop= driver.findElement(By.xpath("//*[@id='droppable']"));
		
		new Actions(driver).dragAndDrop(drag,drop).perform();
//		new Actions(driver).dragAndDropBy(drag,400,10).perform();
		}

}
