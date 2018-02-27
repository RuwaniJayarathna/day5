package com.example.objectRepository;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoanCalChange {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  /*execution order
	   * @BeforeClass
	   * @Test
	   * @AfterClass
  */
   
  
  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  
	 /*give the path of geckodriver jar;if its chrome;
	  System.setProperty("webdriver.chrome.driver", " path");
	  */
	System.setProperty("webdriver.gecko.driver", "F:\\Gecko\\geckodriver.exe");
	
	//create firefox instance(open a firefox window)
    driver = new FirefoxDriver();
    baseUrl = "http://www.calculator.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCalPercentage() throws Exception {
	  
	  //give the url mentioned above, which page should be tested.
    driver.get(baseUrl + "/");
    
    
  
    
    PageObjectPerCalc.lnk_loan(driver).click();
    // driver.findElement(By.linkText("Loan Calculator")).click();
    
    
    PageObjectPerCalc.loan_amount(driver).clear();
    //driver.findElement(By.id("cloanamount")).clear();
    
    PageObjectPerCalc.loan_amount(driver).sendKeys("200000");
    //driver.findElement(By.id("cloanamount")).sendKeys("200000");
   
    PageObjectPerCalc.loan_term(driver).clear();
    //driver.findElement(By.id("cloanterm")).clear();
    
    PageObjectPerCalc.loan_term(driver).sendKeys("10");
    //driver.findElement(By.id("cloanterm")).sendKeys("10 ");
    
    PageObjectPerCalc.loan_month(driver).clear();
    //driver.findElement(By.id("cloantermmonth")).clear();
    
    PageObjectPerCalc.loan_month(driver).sendKeys("6");
    //driver.findElement(By.id("cloantermmonth")).sendKeys("6 ");
   
    PageObjectPerCalc.loan_interestRate(driver).clear();
    //driver.findElement(By.id("cinterestrate")).clear();
    
    PageObjectPerCalc.loan_interestRate(driver).sendKeys("13");
    //driver.findElement(By.id("cinterestrate")).sendKeys("13 ");
    
    
    Select dropdown = new Select(PageObjectPerCalc.loan_compound(driver));
    dropdown.selectByVisibleText("Annually (APY)");
    //Select dropdown = new Select(driver.findElement(By.id("ccompound")));
    //dropdown.selectByVisibleText("Annually (APY)");
    
    
    Select dropdown1 = new Select(PageObjectPerCalc.loan_payback(driver));
    dropdown1.selectByVisibleText("Every Year");
    //Select dropdown1 = new Select(driver.findElement(By.id("cpayback")));
    //dropdown1.selectByVisibleText("Every Year");
    
    
    
    driver.findElement(By.cssSelector("input[type=\"image\"]")).click(); 
    String payment= driver.findElement(By.xpath("//td[contains(text(),'Payment Every Year')]/../td[2]/b")).getText();
    Assert.assertEquals(payment, "$35,967.51");
    
    //to avoid the demo execute fast.othervwise cant see the execution in browser;incresse the time
    Thread.sleep(8000);
    //assertEquals(driver.findElement(By.cssSelector("h2.h2result")).getText(), "Result: 10");
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
