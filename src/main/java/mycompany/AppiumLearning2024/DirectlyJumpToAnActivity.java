package mycompany.AppiumLearning2024;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class DirectlyJumpToAnActivity extends BaseTest {

	@Test
	public void ScrollToWebElement1() throws MalformedURLException, URISyntaxException {

		// go to cmd/terminal , run this adb devices to make sure your emulator is up
		// and running to find the package name and activity name
		//
		//run this command for windows
		//adb shell dumpsys window | find "mCurrentFocus"
		
		// run this command for mac
		//adb shell dumpsys window | grep -E 'mCurrentFocus'

	    driver.executeScript("mobile: startActivity", ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.media.VideoViewDemo"));
		
	    
	    //((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.media.VideoViewDemo"));

	}

}
