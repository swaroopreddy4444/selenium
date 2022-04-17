package StartBrowser;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testCheckBox1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		driver.get("https://www.way2automation.com/angularjs-protractor/checkboxes/");
	
		List<WebElement> cbs=driver.findElements(By.xpath("//*[@type='checkbox']"));
		System.out.println(cbs.size());
		for(WebElement cb:cbs) {
			if(cb.getAttribute("checked")==null)
				cb.click();
				Thread.sleep(2000);
		}
	}

}
