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
import OrangeHRM.Jobs;
import OrangeHRM.Login_Page;


public class TC03_Add_Jobs {
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
	  Datatable=eat.getDataTable("E:\\HTML Report\\OrangeHRM\\TC03_Add_Jobs.xlsx","Sheet1");
	  TestScriptName=(Datatable.get("TC03").get("TestName"));
	  
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
  public void TC_Jobs() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
	  String UserName = Datatable.get("TC03").get("UserName");
	  String Password = Datatable.get("TC03").get("Password");
	  String JobTitle = Datatable.get("TC03").get("JobTitle");
	  String JobDescr = Datatable.get("TC03").get("JobDescr");
	  String JobNote  = Datatable.get("TC03").get("JobNote");
	  
	  Login_Page L1=new Login_Page();
	  L1.Login(driver, logger, extent, TestScriptName);
	  L1.Login_Details(UserName, Password);
	  
	  Jobs J1 = new Jobs();
	  J1.Test_Jobs(driver, logger, extent, TestScriptName);
	  J1.Job_Details(JobTitle,JobDescr,JobNote);
	  
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
