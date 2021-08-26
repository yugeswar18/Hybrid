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

import Extent_Reports.ExtentReport;

public class Home_Page {
	WebDriver driver;
	
	ExtentTest logger;
	ExtentReports extent;
	String TestScriptName;
	String screenShotPath;
	
	
  
  public void Home(WebDriver driver,
	ExtentTest logger,
	ExtentReports extent,
	String TestScriptName) {
	  this.driver=driver;
	  this.extent=extent;
	  this.logger=logger;
	  this.TestScriptName=TestScriptName;
	  
  }
  @Test
  public void Home_Details() throws Exception
  {
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	findElement(By.id("welcome")).click();
	
	findElement(By.linkText("Logout"));
	
	screenShotPath=ExtentReport.capture(driver, TestScriptName);
	logger.pass("HomePage- ScreenShot",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
	findElement(By.linkText("Logout")).click();
  }
public  WebElement  findElement(By by)throws Exception {
	WebElement elem= driver.findElement(by);
	if(driver instanceof JavascriptExecutor);
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	}
	return elem;
	// TODO Auto-generated method stub
	
}
}
