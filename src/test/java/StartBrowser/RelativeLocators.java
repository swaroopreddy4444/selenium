package StartBrowser;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver dr = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		dr.get("https://www.way2automation.com/way2auto_jquery/index.php");

		dr.findElement(with(By.tagName("input")).above(By.tagName("select"))).sendKeys("swaroopreddy4444@gmail.com");
		dr.findElement(with(By.tagName("input")).below(By.tagName("select"))).sendKeys("Hindupur");
		List<WebElement> labels = dr.findElements(with(By.tagName("label")).below(By.xpath("//*[@id=\"load_form\"]/h3")));

		for (WebElement label : labels) {

			System.out.println(label.getText());
		}
//		dr.findElement(with(By.linkText("Signin")).toLeftOf(By.xpath(("(//*[@type='submit'])[2]")))).click();  // NosuchElementFound
		wait.until(ExpectedConditions
				.presenceOfElementLocated(with(By.linkText("Signin"))
				.toLeftOf(By.xpath(("(//*[@type='submit'])[2]")))))
				.click();

	}
}
