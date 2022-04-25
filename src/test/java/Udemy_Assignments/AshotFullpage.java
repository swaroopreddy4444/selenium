package Udemy_Assignments;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Utils.SelectBrowser;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AshotFullpage extends SelectBrowser{

	public static void main(String[] args) throws IOException {

		driver=getBrowser();
		
		driver.get("https://www.youtube.com/");
		
		Screenshot src=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(src.getImage(), "png", new File(".//Ashots//capture1.png"));
		
	}

}
