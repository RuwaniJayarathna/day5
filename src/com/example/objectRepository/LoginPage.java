package com.example.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage{
	//web elements
	public static WebElement userName(WebDriver driver){
		WebElement element = driver.findElement(By.name("userName"));
				return element;
	}	
	public static WebElement password(WebDriver driver){
		WebElement element = driver.findElement(By.name("password"));
				return element;
	}	
	public static WebElement loginButton(WebDriver driver){
		WebElement element = driver.findElement(By.name("login"));
				return element;
	}	
	public static void loggingToApplication(WebDriver driver, String userName, String password) {
		LoginPage.userName(driver).sendKeys("user789");
		LoginPage.password(driver).sendKeys("user789");
		LoginPage.loginButton(driver).click();
	}
}
