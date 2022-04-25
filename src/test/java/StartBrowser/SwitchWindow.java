package StartBrowser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import Utils.SelectBrowser;

public class SwitchWindow extends SelectBrowser {

	public static void main(String[] args) {

		driver = getBrowser();
		driver.get("https://retail.onlinesbi.com/retail/login.htm#");
		driver.findElement(By.xpath("(//*[contains(text(),'CONTINUE TO LOGIN')])[1]")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");

		driver.findElement(By.xpath("//*[@tabindex='23']")).click();

		Set<String> win = driver.getWindowHandles();
		Iterator<String> itr = win.iterator();
		ArrayList<String> WinID = new ArrayList<String>();
		int i = 0;
		while (itr.hasNext()) {
			WinID.add(itr.next());
			System.out.println(WinID.get(i));
			System.out.println(driver.switchTo().window(WinID.get(i)).getTitle());
			i++;
		}

		// win-2
		driver.switchTo().window(WinID.get(1));
		driver.findElement(By.id("nextStep")).click();

		// win-1
		driver.switchTo().window(WinID.get(0));
		driver.findElement(By.name("userName")).sendKeys("swaroopreddy123");
		driver.findElement(By.name("password")).sendKeys("sbi@123");

	}

}
