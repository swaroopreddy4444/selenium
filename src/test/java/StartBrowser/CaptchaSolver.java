package StartBrowser;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class CaptchaSolver {

	public static void main(String[] args) throws InterruptedException, IOException, TesseractException {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://pmuhousing.ap.gov.in/APSHCLPMU/Views/Loginform.aspx");

		driver.findElement(By.name("txtusername")).sendKeys("11290654-DA");
		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.name("txtpassword")))
				.sendKeys("515261");
		
		
		WebElement imgcap= driver.findElement(By.id("imgCaptcha"));
		File src = imgcap.getScreenshotAs(OutputType.FILE);
		String path =".\\src\\test\\java\\StartBrowser\\captchas\\captcha.png";
		
		FileHandler.copy(src, new File(path));
		Thread.sleep(2000);
		
		ITesseract image = new Tesseract();
		
		String Captchatype = image.doOCR(new File(path));
//	
		System.out.println(Captchatype);
//		driver.findElement(By.name("txtcaptcha")).sendKeys(Captchatype);
//		
//		driver.findElement(By.name("btnlogin")).click();
//		
//		driver.get("https://pmuhousing.ap.gov.in/APSHCLPMU/OTS/Registrationdocstatusupdate.aspx");
//		wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@role='textbox']"))).click();
//		List<WebElement> labels = driver.findElements(By.xpath("//*[@role='option']"));
//
//		for (WebElement label : labels) {
//
//			System.out.println(label.getText());
//		}

	}

}
