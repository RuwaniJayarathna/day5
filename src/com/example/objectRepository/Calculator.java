package com.example.objectRepository;
 //to tell to use this  library when execution
import org.openqa.selenium.*;

public class Calculator {
	private static WebElement element =null;
	
	public static WebElement button_five(WebDriver driver){
		element= driver.findElement(By.xpath("//span[@onclick='r(5)']"));
				return element;
	}	
	public static WebElement button_zero(WebDriver driver){
		element= driver.findElement(By.xpath("//span[@onclick='r(0)']"));
				return element;
	}	
	public static WebElement button_two(WebDriver driver){
		element= driver.findElement(By.xpath("//span[@onclick='r(2)']"));
				return element;
	}	
	public static WebElement button_equal(WebDriver driver){
		element= driver.findElement(By.xpath("//span[@onclick=\"r('=')\"]"));
				return element;
	}
}
