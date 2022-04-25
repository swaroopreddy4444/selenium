package Udemy_Assignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.SelectBrowser;

public class ElementScreenShot extends SelectBrowser{

	public static void main(String[] args) throws IOException {

		driver=getBrowser();
		
		driver.get("https://www.google.co.in/");
		WebElement logo=driver.findElement(By.xpath("//*[@alt='Google']"));

		ElementScreenShot(logo,".//screenshots//google.png");
	}

}
