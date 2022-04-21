package Udemy_Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOverActions {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions a= new Actions(driver);
		
		driver.get("https://www.americangolf.co.uk/");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".//screenshots//shot1.png"));
		
		a.moveToElement(driver.findElement(By.xpath("(//a[contains(text(),'Golf Clubs')])[4]"))).build().perform();
		Thread.sleep(1000);
		src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".//screenshots//shot2.png"));
		
		driver.findElement(By.xpath("//*[@id=\"CLUBS_1\"]/ul/li[1]/ul/li[1]/a/span")).click();
		Thread.sleep(1000);
		src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".//screenshots//shot3.png"));
		
	}

}
