package mycompany.AppiumLearning2024;

import org.testng.annotations.Test;

public class BrowserOnly extends BaseTest_BrowserOnly {
	
	@Test
	public void method1() {
		
		driver.get("https://www.wwe.com");
		System.out.println(driver.getCurrentUrl());
		System.out.println("And the title is -->"+driver.getTitle());
		driver.quit();
		
	}

}
