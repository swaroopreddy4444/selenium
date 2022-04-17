package StartBrowser;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testCheckBox {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		driver.get("https://endtest.io/guides/docs/how-to-test-checkboxes/");
	
		
		List<WebElement> cbs=driver.findElements(By.xpath("//*[@type=\"checkbox\"]"));
		System.out.println(cbs.size());
		for(WebElement cb:cbs)
			if(cb.getAttribute("checked")==null)
				cb.click();
	}

}
