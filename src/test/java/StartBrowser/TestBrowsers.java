package StartBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowsers {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://way2automation.com");
		String title=driver.getTitle();
		System.out.println(title.length()+"\n"+title);
		Thread.sleep(5000);
		//driver.close();
		driver.quit();
	}

}
