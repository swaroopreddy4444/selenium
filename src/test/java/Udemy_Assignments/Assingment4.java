package Udemy_Assignments;

import org.openqa.selenium.Dimension;

import Utils.SelectBrowser;

public class Assingment4 extends SelectBrowser {

	public static void main(String[] args) {

		driver =getBrowser();
		driver.get("https://www.google.com/");
		
		for(int i=100;i<700;i+=20) {
			Dimension d=new Dimension(i,i);
			driver.manage().window().setSize(d);
		}
	}

}
