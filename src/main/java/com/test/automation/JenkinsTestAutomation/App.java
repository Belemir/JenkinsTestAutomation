package com.test.automation.JenkinsTestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class App extends Util{
	By popUp = By.xpath("/html/body/div[8]/div/div/a");
			
	@Test
	public void f() {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Toshiba/Downloads/chromedriver_74.exe");
		driver = new ChromeDriver();
		driver.get("https://tr.aliexpress.com/");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);

		if(this.checkElementIsExistByLocator(popUp)) {
			WebElement close = driver.findElement(popUp);
			waitUntilVisibleByLocator(popUp);
			close.click();
		};
		
		WebElement takiElement = driver.findElement(By.xpath("//*[@id=\'home-firstscreen\']/div/div/div[2]/div/div[2]/dl[6]/dt/span/a"));
		action.moveToElement(takiElement).build().perform();
	}

	
}
