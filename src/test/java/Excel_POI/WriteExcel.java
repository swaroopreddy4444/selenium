package Excel_POI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook wb =new XSSFWorkbook();
		
		XSSFSheet s1= wb.createSheet("Sheet1");
		
//		Row r1 =s1.createRow(0);
//		
//		Cell A1=r1.createCell(0);
//		Cell B1=r1.createCell(1);
//
//		A1.setCellValue("A1 value");
//		B1.setCellValue("B1 value");
		
		for(int r=0;r<10;r++) {
			Row row=s1.createRow(r);
			for(int c=0;c<10;c++) {
				Cell cell=row.createCell(c);
				cell.setCellValue((int)(Math.random()*100));
				
			}
		}

		
		
	File f =new File("E:\\bablu\\JavaPractice\\selenium\\src\\test\\java\\Excel_POI\\WriteExcel.xlsx");

	FileOutputStream fo =new FileOutputStream(f);
	
	wb.write(fo);
	
	fo.close();
	wb.close();
		
	}

}
