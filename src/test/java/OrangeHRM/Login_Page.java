package OrangeHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import CommonUtil.OR;
import Extent_Reports.ExtentReport;

public class Login_Page {
	WebDriver driver = null;
	ExtentTest logger;
	ExtentReports extent;
	String screenShotPath;
	String TestScriptName;
	
	
	
	
  
  public void Login(WebDriver driver,ExtentTest logger,
	ExtentReports extent,String TestScriptName) {
	  this.driver=driver;
	  this.extent=extent;
	  this.logger=logger;
	  this.TestScriptName=TestScriptName;
	  
	  
	  
	  
  }
  @Test
  public void Login_Details(String UsrName,String PW) throws Exception
  {
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  findElement(By.xpath(OR.Vamsi_UserName)).sendKeys(UsrName);
	  findElement(By.xpath(OR.Password)).sendKeys(PW);
	  findElement(By.xpath(OR.Loginbutton));
	  screenShotPath=ExtentReport.capture(driver, TestScriptName);
	  logger.pass("Login Page - ScreenShot",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
	  findElement(By.xpath(OR.Loginbutton)).click();
  }
  
  public WebElement findElement(By by)throws Exception{
	  WebElement elem= driver.findElement(by);
	  if(driver instanceof JavascriptExecutor);
	  {
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);		 
	  }
	  
	return elem;
	  
  }
}
