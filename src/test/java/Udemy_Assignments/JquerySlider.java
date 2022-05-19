package Udemy_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utils.SelectBrowser;

public class JquerySlider extends SelectBrowser {

	public static void main(String[] args) {

		driver = getBrowser();

		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		WebElement slider = driver.findElement(By.id("slider"));

//		slider is divided into -end 0 +end 

		int width = slider.getSize().getWidth() / 2; // +end = 675 = 100%
		int slide = -width / 2; // -end/2 = -337.5 = 25%

		Actions a = new Actions(driver);
		a.dragAndDropBy(slider, slide, 0).perform();
		
	}
}
