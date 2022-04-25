package Udemy_Assignments;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Utils.SelectBrowser;

public class ScreenShotTimestamp extends SelectBrowser{

	public static void main(String[] args) throws IOException {

		driver=getBrowser();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		
		driver.switchTo().frame("iframeResult");
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("myFunction()");
		WebElement submit= driver.findElement(By.xpath("//*[@id='mySubmit']"));
		WebElement tryit = driver.findElement(By.xpath("//button[text()='Try it']"));
		js.executeScript("arguments[0].style.border='3px solid green'",submit);
		js.executeScript("arguments[0].style.border='3px solid red'",tryit);
		
		Date d= new Date();
		
		@SuppressWarnings("deprecation")
		String stamp=d.getDate()+"_"+(d.getMonth()+1)+"_"+(d.getYear()+1900)+"_"+d.getHours()+"_"+d.getMinutes()+"_"+d.getSeconds();

		PageScreenShot(".//Screenshots//"+stamp+".png");
		
	}

}
