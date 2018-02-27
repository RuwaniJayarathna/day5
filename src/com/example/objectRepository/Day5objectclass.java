package com.example.objectRepository;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Day5objectclass {
	public static WebElement typeUserName(WebDriver driver){
		WebElement element = driver.findElement(By.name("userName"));
				return element;
	}	
	
	public static WebElement typePassword(WebDriver driver){
		WebElement element = driver.findElement(By.name("password"));
				return element;
	}	
	public static WebElement clickloginButton(WebDriver driver){
		WebElement element = driver.findElement(By.name("login"));
				return element;
	}	
	
}
