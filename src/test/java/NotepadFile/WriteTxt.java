package NotepadFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTxt {
	
	public static void main(String[] args) throws IOException {
		
		File f= new File("E:\\bablu\\JavaPractice\\selenium\\src\\test\\java\\NotepadFile\\Test2.txt");
		
		FileWriter fw = new FileWriter(f);
		
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(""+(int)(Math.random()*100));
		bw.newLine();
		bw.write(""+(int)(Math.random()*100));
		
		bw.close();
		fw.close();
		
	}

}
