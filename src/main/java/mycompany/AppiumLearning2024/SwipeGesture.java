package mycompany.AppiumLearning2024;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class SwipeGesture extends BaseTest {

	@Test
	public void ScrollToWebElement1() throws MalformedURLException, URISyntaxException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		
		
		WebElement elementToBeSwiped = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        System.out.println("Value of focusable is -->"+elementToBeSwiped.getAttribute("focusable"));
		//Using JavascriptExecutor to swipe left
		
        SwipeElementInDirection(elementToBeSwiped, "left");


		 System.out.println("Value of focusable is -->"+elementToBeSwiped.getAttribute("focusable"));
	}

}
