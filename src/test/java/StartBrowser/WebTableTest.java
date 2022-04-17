package StartBrowser;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		driver.get("https://in.investing.com/indices/indices-futures");
//		Thread.sleep(20000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class=\"common-table medium js-table js-streamable-table\"]")));
		
		List<WebElement> head = driver.findElements(By.xpath("//table[@class=\"common-table medium js-table js-streamable-table\"]/thead/tr/th"));
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class=\"common-table medium js-table js-streamable-table\"]/tbody/tr"));
		List<WebElement> cols = driver.findElements(By.xpath("//table[@class=\"common-table medium js-table js-streamable-table\"]/tbody/tr[1]/td"));
		
		System.out.println(head.size()+" "+rows.size()+" "+cols.size());
		
		for(int h=3;h<=head.size();h++){
			System.out.print(driver.findElement(By.xpath("//table[@class=\"common-table medium js-table js-streamable-table\"]/thead/tr/th["+h+"]")).getText()+"\t\t");
		}
		System.out.println();
		
		for(int r=1;r<=rows.size();r++) {
			
			for(int c=3;c<=cols.size();c++) {
				
				System.out.print(driver.findElement(By.xpath("//table[@class=\"common-table medium js-table js-streamable-table\"]/tbody/tr["+r+"]/td["+c+"]")).getText()+"\t\t");
			}
			System.out.println();
		}
		
		
	}

}
