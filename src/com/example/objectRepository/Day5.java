package com.example.objectRepository;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Day5 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
 
  /*@Test
  public void loginTest() {
	  WebDriver driver = null;
	  //LoginPage.loggingToApplication(driver, "user789", "user789");
	LoginPage.userName(driver).sendKeys("user789");
	LoginPage.password(driver).sendKeys("user789");
	LoginPage.loginButton(driver).click();
  }
  */
  
  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  
	 /*give the path of geckodriver jar;if its chrome;
	  System.setProperty("webdriver.chrome.driver", " path");
	  */
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\csc27\\Downloads\\Shehan\\geckodriver-v0.17.0-win32\\geckodriver.exe");
	
	//create firefox instance(open a firefox window)
    driver = new FirefoxDriver();
    baseUrl = "http://newtours.demoaut.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDay5() throws Exception {
    driver.get(baseUrl + "/");
    //driver.findElement(By.name("userName")).clear();
    Day5objectclass.typeUserName(driver).clear();
    
    //driver.findElement(By.name("userName")).sendKeys("user789");
    Day5objectclass.typeUserName(driver).sendKeys("user789");
    
    
    //driver.findElement(By.name("password")).clear();
    Day5objectclass.typePassword(driver).clear();
    
    //driver.findElement(By.name("password")).sendKeys("user789");
    Day5objectclass.typePassword(driver).sendKeys("user789");
    
    //driver.findElement(By.name("login")).click();
    Day5objectclass.clickloginButton(driver).click();
    
    //assertEquals(driver.findElement(By.cssSelector("td.mouseOver")).getText(), "SIGN-OFF");
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
