package com.example.testsNew;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.objectRepository.LoginPage;


public class LoginTestOfFlight {
	private WebDriver driver;
  @Test
  public void loginTest() {
	  WebDriver driver = null;
	  LoginPage.loggingToApplication(driver, "user789", "user789");
	//LoginPage.userName(driver).sendKeys("user789");
	//LoginPage.password(driver).sendKeys("user789");
	//LoginPage.loginButton(driver).click();
  }
  
  @BeforeMethod
  public void beforeMethod(){
  System.setProperty("webdriver.gecko.driver", "F:\\Gecko\\geckodriver.exe");
	
  FirefoxDriver driver = new FirefoxDriver();
  String baseUrl = "http://www.newtours.demoaut.com/";
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  driver.manage().window().maximize();
  driver.get(baseUrl + "/mercurysignon.php");
}
  @AfterMethod
  public void afterMethod(){
	  driver.close();
  }
}
  

