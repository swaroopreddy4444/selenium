package Utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class SelectBrowser {

	public static WebDriver driver =null;

	public static WebDriver getBrowser(String browser,int ImpWait) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ImpWait));
		
		return driver;		
	}
	
public static WebDriver getBrowser() {
		
		ChromeOptions ops = new ChromeOptions();
       
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(ops);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		return driver;		
	}
public static WebDriver getBrowser(String headless) {
		
		ChromeOptions ops = new ChromeOptions();
		if(headless=="headless") {
        ops.addArguments("--disable-notifications");
        ops.addArguments("--headless");

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(ops);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		}
		else {
			getBrowser();
		}
		return driver;		
	}
	
	public static void PageScreenShot(String savePath) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(savePath));
	}
	public static void ElementScreenShot(SearchContext element, String savePath) throws IOException {
		File src = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(savePath));
	}
	public static void FullPageAShot(String savePath) throws IOException {
		Screenshot src = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(src.getImage(), "png", new File(".//Ashots//capture1.png"));
	}
	public static void ElementAShot(String savePath,WebElement element) throws IOException {
		Screenshot src = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver,element);
		ImageIO.write(src.getImage(), "png", new File(".//Ashots//capture1.png"));
	}
	
	
	
	
}
