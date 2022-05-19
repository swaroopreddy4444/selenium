package Udemy_Assignments;

import org.openqa.selenium.By;

import Utils.SelectBrowser;

public class UploadFileTest extends SelectBrowser{

	public static void main(String[] args) throws InterruptedException {

		driver=getBrowser();
		

		driver.get("https://demo.guru99.com/test/upload/");
		driver.findElement(By.xpath("//*[@id=\"uploadfile_0\"]")).sendKeys("C:\\Users\\Parigi-2-DA\\Documents\\IMG_20220104_0002.jpg");
		
//		driver.get("https://www.remove.bg/upload");
//		driver.findElement(By.xpath("//*[@id=\"page-content\"]/div[1]/div/div/div[1]/div/div[1]/div[2]/button")).sendKeys("C:\\Users\\swaroop reddy\\Desktop\\peronsal\\sad.jpeg");
		
	}

}
