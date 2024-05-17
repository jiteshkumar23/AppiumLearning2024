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
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest_BrowserOnly {
	
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
				options.setDeviceName("Pixel 8");

				//set the app not required
				options.setCapability("browserName", "Chrome");
				options.setChromedriverExecutable("C:\\Users\\jites\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
				
				
				
				driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	
	
	@AfterTest
	public void tearDown()  {
        System.out.println("Tear down executing");
		service.stop();
		 System.out.println("Tear down executed");
}
}