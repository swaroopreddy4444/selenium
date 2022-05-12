package TestNG_Learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestParameterization {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "dp")
	public Object[][] getData() {

		ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\Excel\\loginData.xlsx");
		int Rows = excel.getRowCount("Sheet1");
		int Cols = excel.getColumnCount("Sheet1");
//		System.out.println(excel.getCellData("Sheet1", 0, 2));
		System.out.println(Rows-1 + " : " + Cols);
		Object[][] data = new Object[Rows - 1][Cols];

		for (int r=2;r<=Rows;r++) {
			for (int c=0;c<Cols;c++) {
				data[r-2][c]=excel.getCellData("Sheet1", c, r);
			}
		}
//		data[0][0] = "swaroopreddy4444@gmail.com";
//		data[0][1] = "smil@2021";
//		data[1][0] = "csaiswaroopreddy@gmail.com";
//		data[1][1] = "Git4444@2022";
//		data[2][0] = "supergirl@gmail.com";
//		data[2][1] = "super@2022";

		return data;
	}

	@Test(dataProvider = "dp")
	public void doLogin(String username, String password) throws InterruptedException {

		
		driver.get("https://accounts.google.com/");

//		driver.findElement(By.id("user")).sendKeys(username);
//		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("identifierId")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
//		System.out.println(username + " :: " + password);
	}
}
