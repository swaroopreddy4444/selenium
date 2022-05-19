package Udemy_Assignments;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import Utils.SelectBrowser;

public class UploadFileRobotClass extends SelectBrowser{

	public static void main(String[] args) throws InterruptedException, AWTException {

		driver=getBrowser();
		

		driver.get("https://www.remove.bg/");
		driver.findElement(By.xpath("//*[normalize-space(text())='Upload Image']")).click();
		
		Robot robo = new Robot();
		robo.setAutoDelay(1000);
		
		StringSelection ss = new StringSelection("%UserProfile%\\Pictures\\img001.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.setAutoDelay(1000);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		
	}

}
