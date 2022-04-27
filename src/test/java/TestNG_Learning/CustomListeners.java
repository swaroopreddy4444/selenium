package TestNG_Learning;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener{

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a href='..\\screenshots\\25_4_2022_0_45_45.png' target='_blank'>ScreenShot </a>");
		Reporter.log("</br>" + "<a href='..\\screenshots\\25_4_2022_0_45_45.png' target='_blank'>"
				+ "<img src='..\\screenshots\\25_4_2022_0_45_45.png' height=400 width=400> </a>");
		}
}
