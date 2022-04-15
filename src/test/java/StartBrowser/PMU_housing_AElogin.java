package StartBrowser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PMU_housing_AElogin {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {

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
		
//		String Captchacode = JOptionPane.showInputDialog("Enter Captcha");
		dr.findElement(By.name("txtcaptcha")).click();
//		dr.findElement(By.name("txtcaptcha")).sendKeys(Captchacode);
		Thread.sleep(8000);
		dr.findElement(By.name("btnlogin")).click();
		
		dr.get("https://pmuhousing.ap.gov.in/APSHCLPMU/OTS/BeneficiaryStatus.aspx");
		
		
		File f = new File("C:\\Users\\swaroop reddy\\Downloads\\parigi-2OTS.xls");
		
		FileInputStream fi =new FileInputStream(f);
		
		Workbook wb = WorkbookFactory.create(fi);
		
		Sheet s1=wb.getSheet("Sheet1");
		System.out.println(s1.getLastRowNum());
		
		for(int r=2;r<s1.getLastRowNum();r++) {
			int c=2;
			Row row=s1.getRow(r);
			Cell cell=row.getCell(c);
				System.out.print(cell.getStringCellValue()+"\t");
				dr.findElement(By.id("ContentPlaceHolder1_txtbenid")).sendKeys(cell.getStringCellValue());
				dr.findElement(By.id("ContentPlaceHolder1_lnksubmit")).click();
				
				cell=row.createCell(c+7);	
				cell.setCellValue(dr.findElement(By.id("ContentPlaceHolder1_txtschemename")).getAttribute("value"));
				System.out.print(cell.getStringCellValue()+"\t");
				
				cell=row.createCell(c+8);	
				cell.setCellValue(dr.findElement(By.id("ContentPlaceHolder1_txtschemeyear")).getAttribute("value"));
				System.out.print(cell.getStringCellValue()+"\t");
				
				cell=row.createCell(c+9);
				cell.setCellValue(dr.findElement(By.id("ContentPlaceHolder1_txtPrincipleComponent")).getAttribute("value"));
				System.out.print(cell.getStringCellValue()+"\t");
				
				cell=row.createCell(c+10);	
				cell.setCellValue(dr.findElement(By.id("ContentPlaceHolder1_txtinterest")).getAttribute("value"));
				System.out.print(cell.getStringCellValue()+"\t");
				
				dr.findElement(By.id("ContentPlaceHolder1_txtbenid")).clear();
				System.out.println();
			}
		
		FileOutputStream fo =new FileOutputStream(f);
		
		wb.write(fo);
		
		fo.close();
		fi.close();
		wb.close();
	
	
		
		
		
		
		
//		wait.until(ExpectedConditions
//				.visibilityOfElementLocated(By.xpath("//*[@role='textbox']"))).click();
//		List<WebElement> labels = dr.findElements(By.xpath("//*[@role='option']"));
//
//		for (WebElement label : labels) {
//
//			System.out.println(label.getText());
//		}
//		dr.findElement(with(By.linkText("Signin")).toLeftOf(By.xpath(("(//*[@type='submit'])[2]")))).click();  // NosuchElementFound
//		wait.until(ExpectedConditions
//				.presenceOfElementLocated(with(By.linkText("Signin"))
//				.toLeftOf(By.xpath(("(//*[@type='submit'])[2]")))))
//				.click();

	}


	

}
