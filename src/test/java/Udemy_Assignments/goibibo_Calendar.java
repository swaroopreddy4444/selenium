package Udemy_Assignments;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class goibibo_Calendar {

	public static void main(String[] args) throws ParseException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		
		driver.navigate().to("https://www.goibibo.com/");
		driver.findElement(By.xpath("//p[contains(text(),\"day\")]")).click();
		
		String d= "29/09/2022";
		
		SimpleDateFormat df= new SimpleDateFormat("dd/MM/yyyy");
		Date mydate = df.parse(d);
		Calendar cal = Calendar.getInstance();
		cal.setTime(mydate);
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);   // month index starts from 0 to 11
		int year = cal.get(Calendar.YEAR);
		
		String months[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		
		String travelMonth = months[month]+" "+year;
		String getMonthYear = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]")).getText();
		
		while(!getMonthYear.equals(travelMonth)) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			getMonthYear = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]")).getText();
			
		}
		driver.findElement(By.xpath("(//div/p[@class='fsw__date' and text()='"+day+"'])[1]")).click();
		
	}

}
