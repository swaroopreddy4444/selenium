package NotepadFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Readtxt {

	public static void main(String[] args) throws IOException {

		File f = new File("E:\\bablu\\JavaPractice\\selenium\\src\\test\\java\\NotepadFile\\Test2.txt");

		FileReader fr = new FileReader(f);

		BufferedReader br = new BufferedReader(fr);
	
		String line=null;
		while (( line=br.readLine()) != null) {
		
			System.out.println(line);
		}

		br.close();
		fr.close();
	}

}
