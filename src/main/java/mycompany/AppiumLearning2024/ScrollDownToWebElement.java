package mycompany.AppiumLearning2024;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollDownToWebElement extends BaseTest {

	@Test
	public void ScrollToWebElement1() throws MalformedURLException, URISyntaxException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		//Using androidUIAutomator = googleEngine Script
		
		//use textContains or text based on need
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WebView\").instance(0))"));

		WebElement elementToBeScrolledDownTo = driver.findElement(AppiumBy.accessibilityId("WebView"));

		Assert.assertTrue(elementToBeScrolledDownTo.isDisplayed());
	}

}
