package OrangeHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import CommonUtil.OR;
import Extent_Reports.ExtentReport;

public class Skills {
	WebDriver driver;
	ExtentTest logger;
	ExtentReports extent;
	String TestScriptName;
	String screenShotPath;
	
	
  @BeforeTest
  public void Add_Skills(WebDriver driver,
	ExtentTest logger,
	ExtentReports extent,
	String TestScriptName) {
	  this.driver=driver;
	  this.extent=extent;
	  this.logger=logger;
	  this.TestScriptName=TestScriptName;
	  
	  
  }
  @Test
  public void Skills_Details(String SklName,String Descr) throws Exception
  
  {
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  findElement(By.xpath(OR.Admin)).click();
	  screenShotPath=ExtentReport.capture(driver, TestScriptName);
	  logger.pass("Admin Modual Clicked - ScreenShot",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
	  findElement(By.xpath(OR.Qualification_Focus)).click();
	  screenShotPath=ExtentReport.capture(driver, TestScriptName);
	  logger.pass("Admin Modual Clicked - ScreenShot",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
	  findElement(By.xpath(OR.Qualification_skills_click)).click();
	  screenShotPath=ExtentReport.capture(driver, TestScriptName);
	  logger.pass("Admin Modual Clicked - ScreenShot",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
	  findElement(By.xpath(OR.Skills_Add)).click();
	  screenShotPath=ExtentReport.capture(driver, TestScriptName);
	  logger.pass("Admin Modual Clicked - ScreenShot",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
	  findElement(By.xpath(OR.AddSkill_Name)).sendKeys(SklName);
	  screenShotPath=ExtentReport.capture(driver, TestScriptName);
	  logger.pass("Admin Modual Clicked - ScreenShot",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
	  findElement(By.xpath(OR.AddSkill_Description)).sendKeys(Descr);
	  screenShotPath=ExtentReport.capture(driver, TestScriptName);
	  logger.pass("Admin Modual Clicked - ScreenShot",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
	  findElement(By.xpath(OR.AddSkill_Save));
	  screenShotPath=ExtentReport.capture(driver, TestScriptName);
	  logger.pass("Admin Modual Clicked - ScreenShot",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
	  findElement(By.xpath(OR.AddSkill_Save)).click();
	  screenShotPath=ExtentReport.capture(driver, TestScriptName);
	  logger.pass("Admin Modual Clicked - ScreenShot",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
	  
  }

  @AfterTest
  public WebElement findElement(By by)throws Exception{
	  WebElement elem = driver.findElement(by);
	  if(driver instanceof JavascriptExecutor);
	  {
		  ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	  }
	  
	return elem;
	  
  }
}
