package com.test.automation.JenkinsTestAutomation;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Util {
	WebDriver driver;
	
	public boolean checkElementIsExistByLocator(By locator) {
		try {
			this.driver.findElement(locator);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	public WebElement waitUntilVisibleByLocator(By locator) {
		WebElement element = null;
		
		try {
			Wait<WebDriver> wait = (new FluentWait(this.driver)).withTimeout(Duration.ofSeconds(60L)).pollingEvery(Duration.ofMillis(100L)).ignoring(StaleElementReferenceException.class).ignoring(NoSuchElementException.class);
			element = (WebElement)wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}catch(Exception ex) {
			System.out.println("Web Element gorunur degil");
		}
	
		return element;
	}
}
