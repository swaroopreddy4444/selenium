package Excel_POI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		File f = new File(".\\src\\test\\java\\Excel_POI\\WriteExcel.xlsx");
		
		FileInputStream fi =new FileInputStream(f);
		
		Workbook wb = WorkbookFactory.create(fi);
		
		Sheet s1=wb.getSheetAt(0);
		
		for (Row r:s1) {
			
			for(Cell c:r){
			
				switch(c.getCellType()) {
				
					case STRING :
						System.out.print(c.getStringCellValue()+"\t");break;
					case NUMERIC :
						System.out.print((int)c.getNumericCellValue()+"\t");break;
					case BLANK :
						System.out.print("Blank Cell"+"\t");break;
					case FORMULA:
						System.out.print(c.getStringCellValue()+"\t");break;
					default:
						break;
				}
			}
			System.out.println();
		}
		fi.close();
		wb.close();
	}
	
}
