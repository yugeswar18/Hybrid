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

public class Nationlities {
	
	WebDriver driver;
	ExtentTest logger;
	ExtentReports extent;
	String screenShotPath;
	String TestScriptName;
	
	
  
  public void Add_Nationality(WebDriver driver,
	ExtentTest logger,
	ExtentReports extent,
	String TestScriptName) {
	  
	  this.driver=driver;
	  this.extent=extent;
	  this.logger=logger;
	  this.TestScriptName=TestScriptName;
	  
  }
  @Test
  public void Nationality_Details(String Nationality) throws Exception
  {
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  findElement(By.xpath(OR.Admin1)).click();
	  findElement(By.xpath(OR.Nationality)).click();
	  findElement(By.xpath(OR.raghu_add)).click();
	  findElement(By.xpath(OR.raghu_name)).sendKeys(Nationality);
	  screenShotPath=ExtentReport.capture(driver, TestScriptName);
	  logger.pass("Entered Nationlity Name - ScreenShot",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
	  findElement(By.xpath(OR.raghu_save)).click();
	  
	  
  }
public WebElement findElement(By by)throws Exception {
	WebElement elem=driver.findElement(by);
	if(driver instanceof JavascriptExecutor);
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		
	}
	
	return elem;
}
}

