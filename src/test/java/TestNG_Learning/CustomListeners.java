package TestNG_Learning;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener{

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a href='..\\screenshots\\Golf Clubsshot2.png' target='_blank'>ScreenShot </a>");
		Reporter.log("</br>" + "<a href='..\\screenshots\\Golf Clubsshot2.png' target='_blank'>"
				+ "<img src='..\\screenshots\\Golf Clubsshot2.png' height=400 width=400> </a>");
		}
}
