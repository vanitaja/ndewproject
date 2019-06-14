package com.test.pkg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Maven_Simple_Class 
{
	public WebDriver driver;
  
  @Test(priority=1,description="valid user 1 enter the mercury tours application successfully")
  public void loginValidDetails() 
  {
	String act_title=driver.getTitle();
	String exp_title="Welcome: Mercury Tours";
	Assert.assertEquals(act_title, exp_title);
	driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("Suvidyap1");
	driver.findElement(By.cssSelector("input[name='password']")).sendKeys("P@ssword1");
	driver.findElement(By.cssSelector("input[name='login']")).click();
	System.out.println("user 1 is valid enter successfully");
	boolean act_flag=driver.findElement(By.cssSelector("img[src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	boolean exp_flag=true;
	Assert.assertEquals(act_flag,exp_flag);
	System.out.println("fight finder page open successfully");
	driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]")).click();
	System.out.println("sign off successfully");
  }
  
  @Test(priority=2,description="valid user 2 enter the mercury tours application successfully")
  public void loginValidDetails1() 
  {
	driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("Suvidyap2");
	driver.findElement(By.cssSelector("input[name='password']")).sendKeys("P@ssword2");
	driver.findElement(By.cssSelector("input[name='login']")).click();
	System.out.println("user 2 is valid enter successfully");
	boolean act_flag=driver.findElement(By.cssSelector("img[src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	boolean exp_flag=true;
	Assert.assertEquals(act_flag,exp_flag);
	System.out.println("fight finder page open successfully");
	driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]")).click();
	
  }
  
  
  @Test(priority=3,description="invalid user 3 does not enter the mercury tours application successfully")
  public void logininValidDetails() 
  {
	driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("Suvidy");
	driver.findElement(By.cssSelector("input[name='password']")).sendKeys("P@sswor");
	driver.findElement(By.cssSelector("input[name='login']")).click();
	System.out.println("user 3 is valid enter successfully");
	boolean act_flag=driver.findElement(By.cssSelector("img[src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	boolean exp_flag=true;
	Assert.assertEquals(act_flag,exp_flag);
	System.out.println("fight finder page open successfully");
  }
  
  
  @BeforeMethod
  public void getAllCookie() 
  {
	  Set<Cookie> c=driver.manage().getCookies();
	  for(Cookie coo:c)
	  {
		  System.out.println("get the all cookies:-"+coo);
	  }
  }

  @AfterMethod
  public void captureScreenshot(ITestResult result) throws IOException 
  {
	  if(result.FAILURE==result.getStatus())
	  {
		  System.out.println("Fail test result is:"+result.getName());
		  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  String timestamp= new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss").format(new Date());
		  FileUtils.copyFile(src, new File("E:\\Selenium_Programs\\Maven_Simple_Project\\src\\test\\resorces\\screen.jpg"));
		  System.out.println("screen shot capture successfully");
	  }
  }

  @BeforeClass
  public void maximizeWindow() 
  {
	  driver.manage().window().maximize();
	  System.out.println("maximize the window successfully");
  }

  @AfterClass
  public void deleteAllCookie() 
  {
	  System.out.println("delete all the cookies successfully");
  }

  @BeforeTest
  public void enterApplicationURL() 
  {
	  driver.get("http://www.newtours.demoaut.com/");
	  System.out.println("enter the application url successfully...");
  }

  @AfterTest
  public void dbConnectionClose() 
  {
	  System.out.println("close the connection successfully");
  }

  @BeforeSuite
  public void openBrowser() 
  {
	  System.setProperty("webdriver.chrome.driver","E:\\Selenium_Java\\Selenium1\\chromedriver_win32(1)\\chromedriver.exe");
	  driver= new ChromeDriver();
	  System.out.println("open chrome browser successfully...");
  }

  @AfterSuite
  public void close() 
  {
	  driver.close();
	  System.out.println("close the browser successfully");
  }

}
