package mar01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class launchchrome {

	public static void main(String[] args) throws InterruptedException {

	//	System.setProperty("webdriver.chrome.driver","C://selenium_driver/chromedriver_win32/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		
		WebDriver wb =new ChromeDriver();
		wb.manage().window().maximize();
		
		wb.get("https://opensource-demo.orangehrmlive.com/");
		wb.findElement(By.id("txtUsername")).sendKeys("Admin");
		wb.findElement(By.id("txtPassword")).sendKeys("admin123");
//		Thread.sleep(5000);
//		wb.findElement(By.id("txtUsername")).clear();
//		Thread.sleep(5000);
//		wb.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(5000);
		String str= wb.findElement(By.partialLinkText("Forgot your")).getText();
		System.out.println(str);
		boolean x=wb.findElement(By.id("btnLogin")).isDisplayed();
		boolean y=wb.findElement(By.id("btnLogin")).isEnabled();
		boolean z=wb.findElement(By.id("btnLogin")).isSelected();
		System.out.println("is Displayed : "+x+"\nis Enabled : "+y+"\nis Selected : "+z);
		
		String a=wb.findElement(By.id("txtPassword")).getAttribute("type");
		System.out.println(a);	
		Thread.sleep(5000);
		wb.close();
		
	}

}