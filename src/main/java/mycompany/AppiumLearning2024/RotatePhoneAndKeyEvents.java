package mycompany.AppiumLearning2024;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class RotatePhoneAndKeyEvents extends BaseTest {

	@Test
	public void RotatePhoneAndKeyEvents1() throws MalformedURLException, URISyntaxException, InterruptedException 	 {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		DeviceRotation dr1 = new DeviceRotation(0,0,90);
		DeviceRotation dr2 = new DeviceRotation(0,0,180);
		DeviceRotation dr3 = new DeviceRotation(0,0,270);
		DeviceRotation dr4 = new DeviceRotation(0,0,0);
		
		driver.rotate(dr1);
		Thread.sleep(4000);
		driver.rotate(dr2);
		Thread.sleep(4000);
		driver.rotate(dr3);
		Thread.sleep(4000);
		driver.rotate(dr4);
		Thread.sleep(4000);
		
		//pressing back key
		driver.pressKey(new KeyEvent (AndroidKey.HOME));
		
	}

}
