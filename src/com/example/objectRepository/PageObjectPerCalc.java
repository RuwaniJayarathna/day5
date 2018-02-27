package com.example.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectPerCalc {
private static WebElement element =null;
	
	public static WebElement lnk_loan(WebDriver driver){
		element= driver.findElement(By.linkText("Loan Calculator"));
				return element;
				
				
	}	

	public static WebElement loan_amount(WebDriver driver){
		element= driver.findElement(By.id("cloanamount"));
				return element;
				
				
	}

	public static WebElement loan_term(WebDriver driver){
		element= driver.findElement(By.id("cloanterm"));
				return element;
				
				
	}
	public static WebElement loan_month(WebDriver driver){
		element= driver.findElement(By.id("cloantermmonth"));
				return element;
				
				
	}
	public static WebElement loan_interestRate(WebDriver driver){
		element= driver.findElement(By.id("cinterestrate"));
				return element;
				
				
	}
	public static WebElement loan_compound(WebDriver driver){
		element= driver.findElement(By.id("ccompound"));
				return element;
				
	}
	public static WebElement loan_payback(WebDriver driver){
		element= driver.findElement(By.id("cpayback"));
				return element;
				
	}
	
}
