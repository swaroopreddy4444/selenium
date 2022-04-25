package StartBrowser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.SelectBrowser;

public class IframesTestW3schools extends SelectBrowser {

	public static void main(String[] args) {

		driver=getBrowser();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		
		driver.switchTo().parentFrame();
		List<WebElement> frames= driver.findElements(By.tagName("iframe"));
		System.out.println("Frames-->"+frames.size());

		for(WebElement frame:frames)
			System.out.println(frame.getAttribute("id")==""?"NO_ID":frame.getAttribute("id"));
	}

}
