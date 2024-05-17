package mycompany.AppiumLearning2024;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragAndDropGesture extends BaseTest {

	@Test
	public void DragAndDropGesture1() throws MalformedURLException, URISyntaxException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		
		
		WebElement elementToBeDragged = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        
		
		
		dragAndDropWebElement(elementToBeDragged,712,592);
		
		
	}

}
