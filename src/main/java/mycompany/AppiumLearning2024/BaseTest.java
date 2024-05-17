package mycompany.AppiumLearning2024;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	
	@BeforeTest
	public void start() throws MalformedURLException, URISyntaxException {
		// Start Appium Server
				 service = new AppiumServiceBuilder()
						.withAppiumJS(
								new File("C:\\Users\\jites\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
						.withIPAddress("127.0.0.1").usingPort(4723).build();
				service.start();

				UiAutomator2Options options = new UiAutomator2Options();
				
				//set the device name
				options.setDeviceName("Pixel 8 Pro");

				//set the app
//				options.setApp(
//						"C:\\Users\\jites\\eclipse-workspace\\AppiumLearning2024\\src\\main\\java\\resources\\ApiDemos-debug.apk");

				options.setApp(
						"C:\\Users\\jites\\eclipse-workspace\\AppiumLearning2024\\src\\main\\java\\resources\\General-Store.apk");

				
				options.setChromedriverExecutable("C:\\Users\\jites\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
				
				driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	public void longPressElement(WebElement elementToBeLongPressed) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) elementToBeLongPressed).getId()
			));
	}
	
	public void ScrollInDirection(String direction) {
		//values of direction - up, down, left and right
		boolean canScrollMore;
		do {
			 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
					ImmutableMap.of(

							"left", 100, "top", 100, "width", 200, "height", 200, "direction", direction, "percent", 1.0));

		} while (canScrollMore);
	}
	
	public void SwipeElementInDirection(WebElement elementToBeSwiped , String direction) {
	
	((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			"elementId", ((RemoteWebElement) elementToBeSwiped).getId(),
	    "direction", direction,
	    "percent", 0.1
	));
	}
	
	
	public void dragAndDropWebElement(WebElement elementToBeDragged , int X , int Y) {
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) elementToBeDragged).getId(),
			    "endX", X,
			    "endY", Y
			));
	}
	
	public void scrollDownToText(String text) {
		
		//Using androidUIAutomator = googleEngine Script
		System.out.println("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text("+text+").instance(0))");
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+text+"\").instance(0))"));

		
	}
	
	
	@AfterTest
	public void tearDown()  {
        System.out.println("Tear down executing");
		service.stop();
		 System.out.println("Tear down executed");
}
}