package StartBrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.SelectBrowser;

public class JSalerts extends SelectBrowser{

	public static void main(String[] args) {

		driver=getBrowser();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://demoqa.com/alerts");
		
		driver.findElement(By.xpath("//*[@id=\"timerAlertButton\"]")).click();
		wait.until(ExpectedConditions.alertIsPresent()).accept();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		
		driver.findElement(By.xpath("//*[@id=\"promtButton\"]")).click();
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().sendKeys("swaroop super");
		driver.switchTo().alert().accept();
		
		
	}

}
