package TestCases;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;
import OrangeHRM.Home_Page;
import OrangeHRM.Login_Page;
import OrangeHRM.Nationlities;

public class TC01_Nationalities {
	WebDriver driver;
	
	Map<String,HashMap<String,String>> Datatable=new HashMap<String,HashMap<String,String>>();
	
	ExtentTest logger;
	ExtentReports extent;
	String screenShotPath;
	String TestScriptName;
	String TestName;
	
  @BeforeTest
  public void Test() throws Exception {
	  driver=TestBrowser.OpenChromeBrowser();
	  String TestURL ="https://opensource-demo.orangehrmlive.com/";
	  driver.get(TestURL);
	  
	  ExcelApiTest4 eat = new ExcelApiTest4();
	  Datatable=eat.getDataTable("E:\\HTML Report\\OrangeHRM\\TC01_EMPExport4.xlsx","Sheet1");
	  TestScriptName=(Datatable.get("TC01").get("TestName"));
	  
	  SimpleDateFormat sdf= new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a");
	  Date now = new Date();
	  String str = sdf.format(now);
	  TestName=TestScriptName+" "+str+".html";
	  TestScriptName=TestScriptName+" "+str;
	  
	  String TestHtmlName="C:/HTML Report/test-output/ExtentReportScreenShots/"+ TestScriptName +"/"+TestName;
	  ExtentHtmlReporter reporter=new ExtentHtmlReporter(TestHtmlName);
		 System.out.println("Html Report path is : "+TestHtmlName);
		 
		 extent=new ExtentReports();
		 extent.attachReporter(reporter);
		 logger=extent.createTest(TestName);
	  
  }
  @Test
  public void Test_Nationality() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
	  String UserName = Datatable.get("TC01").get("UserName");
	  String Password = Datatable.get("TC01").get("Password");
	  String Nationality = Datatable.get("TC01").get("Nationality");
	  
	  Login_Page L1=new Login_Page();
	  L1.Login(driver, logger, extent, TestScriptName);
	  L1.Login_Details(UserName, Password);
	  
	  Nationlities N1 = new Nationlities();
	  N1.Add_Nationality(driver, logger, extent, TestScriptName);
	  N1.Nationality_Details(Nationality);
	  
	  Home_Page H1 = new Home_Page();
	  H1.Home(driver, logger, extent, TestScriptName);
	  H1.Home_Details();
	  
  }
  
  @AfterTest
  public void CloseBrowser()
  {
	  driver.quit();
	  extent.flush();
  }
}
