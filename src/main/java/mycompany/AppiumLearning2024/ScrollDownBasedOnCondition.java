package mycompany.AppiumLearning2024;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDownBasedOnCondition extends BaseTest {

	@Test
	public void ScrollToWebElement1() throws MalformedURLException, URISyntaxException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		// Using JavascriptExecutor
		// canScrollMore is true if there is more scrolling that can be done
		boolean canScrollMore;

		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
					ImmutableMap.of(

							"left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 1.0));

			if (driver.findElements(AppiumBy.accessibilityId("Spinner")).size() > 0) {
				System.out.println("Spinner element was displayed, just scrolling little extra");
				((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(

						"left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 1.0));
				canScrollMore = false;
				
			}

		} while (canScrollMore);

	}
}