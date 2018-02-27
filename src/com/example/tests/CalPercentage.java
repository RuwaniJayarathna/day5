package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CalPercentage {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  
	 //give the path of geckodriver jar
//	System.setProperty("webdriver.gecko.driver", "F:\\Gecko\\geckodriver.exe");
	
	//create firefox instance(open a firefox window)
    driver = new FirefoxDriver();
    baseUrl = "http://www.calculator.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCalPercentage() throws Exception {
	  
	  //give the url mentioned above which page should be tested.
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText(" Calculator")).click();
    
    //find elements in the web page using id
    driver.findElement(By.id("cpar1")).clear();
    driver.findElement(By.id("cpar1")).sendKeys("10");
    driver.findElement(By.id("cpar2")).clear();
    driver.findElement(By.id("cpar2")).sendKeys("100");
    driver.findElement(By.cssSelector("input[type=\"image\"]")).click();
    assertEquals(driver.findElement(By.cssSelector("h2.h2result")).getText(), "Result: 10");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
