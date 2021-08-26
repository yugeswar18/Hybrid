package OrangeHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Jobs {
	 WebDriver driver;
	ExtentTest logger;
	ExtentReports extent;
	String TestScriptName;
	String screenShotPath;
	
	
  
  public void Test_Jobs(WebDriver driver,
	ExtentTest logger,
	ExtentReports extent,
	String TestScriptName) {
	  
	  this.driver=driver;
	  this.logger=logger;
	  this.extent=extent;
	  this.TestScriptName=TestScriptName;
	  
  }
 @Test
  public void Job_Details(String JobTtl,String JobDes,String JobNt) throws Exception
{
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	  findElement(By.id("menu_admin_viewAdminModule")).click();
	  findElement(By.id("menu_admin_Job")).click();
	  findElement(By.id("menu_admin_viewJobTitleList")).click();
	 
	  findElement(By.id("btnAdd")).click();
	  findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTtl);
	  findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDes);
	  findElement(By.id("jobTitle_note")).sendKeys(JobNt);
	  findElement(By.id("btnSave")).click();
			 
		
	  
}

public  WebElement findElement(By by)throws Exception {
	WebElement elem = driver.findElement(by);
	if(driver instanceof JavascriptExecutor);
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red", elem);
	}
	return elem;
}
  
}
