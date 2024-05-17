package mycompany.AppiumLearning2024;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeneralStoreTest_HybridApp extends BaseTest {
	
	@Test
	public void GeneralStoreTest1() throws MalformedURLException, URISyntaxException, InterruptedException {

		Thread.sleep(6000);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		System.out.println("The error message is --> "+driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name"));
		
		driver.findElement(By.id("android:id/text1")).click();

		String country = "Belgium";

		scrollDownToText(country);
		
		driver.findElement(By.xpath("//android.widget.TextView[@text=\""+country+"\"]")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Jitesh");
		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		
		
		String shoe = "Air Jordan 9 Retro";
		scrollDownToText(shoe);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Air Jordan 9 Retro\"]/../android.widget.LinearLayout/android.widget.TextView[@text=\"ADD TO CART\"]")).click();
		
		//driver.findElement(By.xpath("//android.widget.TextView[@text=\""+shoe+"\"]")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		driver.findElement(By.className("android.widget.CheckBox")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(4000);
		
		Set<String> set = driver.getContextHandles();
		
		for(String e : set) {
			System.out.println(e);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");

		driver.findElement(By.name("q")).sendKeys("Testing");
		
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		
		

	}

}
