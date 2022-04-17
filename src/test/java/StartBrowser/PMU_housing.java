package StartBrowser;

//import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PMU_housing {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.edgedriver().setup();
		WebDriver dr = new EdgeDriver();

		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		dr.get("https://pmuhousing.ap.gov.in/APSHCLPMU/Views/Loginform.aspx");

		dr.findElement(By.name("txtusername")).sendKeys("AE-PARI-58");
		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.name("txtpassword")))
				.sendKeys("709393");	
		
		dr.findElement(By.name("txtcaptcha")).click();
		Thread.sleep(20000);
		dr.findElement(By.name("btnlogin")).click();
		
		dr.get("https://pmuhousing.ap.gov.in/APSHCLPMU/OTS/BeneficiaryStatus.aspx");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@role='textbox']"))).click();
		List<WebElement> labels = dr.findElements(By.xpath("//*[@role='option']"));

		for (WebElement label : labels) {

			System.out.println(label.getText());
		}
//		dr.findElement(with(By.linkText("Signin")).toLeftOf(By.xpath(("(//*[@type='submit'])[2]")))).click();  // NosuchElementFound
//		wait.until(ExpectedConditions
//				.presenceOfElementLocated(with(By.linkText("Signin"))
//				.toLeftOf(By.xpath(("(//*[@type='submit'])[2]")))))
//				.click();

	}


	

}
