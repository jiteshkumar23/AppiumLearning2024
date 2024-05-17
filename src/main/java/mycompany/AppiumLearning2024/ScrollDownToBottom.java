package mycompany.AppiumLearning2024;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDownToBottom extends BaseTest {

	@Test
	public void ScrollToWebElement1() throws MalformedURLException, URISyntaxException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		// Using JavascriptExecutor
		// canScrollMore is true if there is more scrolling that can be done
		//up, down, left and right
		ScrollInDirection("down");

	}

}
