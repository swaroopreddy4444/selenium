package Udemy_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Utils.SelectBrowser;

public class JSexecutor extends SelectBrowser{

	public static void main(String[] args) {

		driver=getBrowser();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		
		driver.switchTo().frame("iframeResult");
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("myFunction()");
		WebElement submit= driver.findElement(By.xpath("//*[@id='mySubmit']"));
		WebElement tryit = driver.findElement(By.xpath("//button[text()='Try it']"));
		js.executeScript("arguments[0].style.border='3px solid green'",submit);
		js.executeScript("arguments[0].style.border='3px solid red'",tryit);
	}

}
