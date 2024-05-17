package mycompany.AppiumLearning2024;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class LongPressGesture extends BaseTest {

	@Test
	public void LongPressGesture1() throws MalformedURLException, URISyntaxException {

		
		//driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		WebElement elementToBeLongPressed = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));
		
		
		longPressElement(elementToBeLongPressed);
		
		
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text=\"Sample menu\"]")).isDisplayed());
	}

}
