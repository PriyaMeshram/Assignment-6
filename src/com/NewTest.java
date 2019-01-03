package com;

import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.ThreadedRefreshHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;

public class NewTest {
	public WebDriver driver;
  @Test(priority=1)
  public void click_on_myaccount() throws InterruptedException {
	  System.out.println("Linked with GitHub");
	  System.out.println("click on my account");
	 driver.findElement(By.linkText("MY ACCOUNT")).click();
	 Thread.sleep(2000);
  }
  @Test(priority=2)
  public void login_with_details() throws InterruptedException {
	  System.out.println("login with details");
	  driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("meshrampriya11@gmail.com");
	  driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("priya@123");
	  driver.findElement(By.xpath("//button[@name='send']")).click();
	  
	  Thread.sleep(2000);
  }
  
  @Test(priority=3)
  public void click_mywishlist() throws InterruptedException {
	  System.out.println("please click on my wishlist");
	  driver.findElement(By.linkText("MY WISHLIST")).click();
	  driver.findElement(By.xpath("//input[@name='order_items[]']")).click();
	  Thread.sleep(2000);
  }
  @Test(priority=4)
  public void click_addtocard() throws InterruptedException {
	  System.out.println("click on add to card");
	  driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
	  Thread.sleep(2000);
  } 
  @Test(priority=5)
  public void enter_shipping_information() throws InterruptedException {
	  System.out.println("enter shipping information");
 // driver.findElement(By.xpath("//span[text()='Proceed to Checkout']")).click();
	  WebElement countey1=driver.findElement(By.xpath("//select[@name='country_id']"));
	  Select ss=new Select(countey1);
	  ss.selectByValue("AE");
	  driver.findElement(By.xpath("//input[@name='region']")).sendKeys("newyork");
	  driver.findElement(By.xpath("//input[@name='estimate_postcode']")).sendKeys("456567");
	  driver.findElement(By.xpath("//span[text()='Estimate']")).click();
	  String actual=driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']")).getText();
	  String expected="s_method_flatrate_flatrate";
	//  Assert.assertEquals(actual, expected);
	  driver.findElement(By.xpath("//span[text()='Update Total']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//span[text()='Proceed to Checkout']")).click();
  }
  
  @Test(priority=6)
  public void enter_biling_details() throws InterruptedException {
	  
	  String ps="Select a billing address from your address book or enter a new address.";
	  String ps1=driver.findElement(By.xpath("//label[@for='billing-address-select']")).getText();
	  System.out.println(ps);
	  if(ps.equals(ps1)) {
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[@id='checkout-step-billing']/form/div/div/button")).click();
	  }
	  else {
	  System.out.println("enter billing address");
	  driver.findElement(By.xpath("//input[@name='billing[company]']")).sendKeys("extrimity india pune");
	  driver.findElement(By.xpath("//input[@name='billing[street][]']")).sendKeys("Karvenagar pune");
	  driver.findElement(By.xpath("//input[@name='billing[street][]']")).sendKeys("cumins college road");
	  driver.findElement(By.xpath("//input[@name='billing[city]']")).sendKeys("Pune");
	  
	  WebElement state=driver.findElement(By.xpath("//select[@id='billing:region_id']"));
	  Select s=new Select(state);
	  s.selectByValue("43");
	  driver.findElement(By.xpath("//input[@name='billing[postcode]']")).sendKeys("41111");
	  WebElement country=driver.findElement(By.xpath("//select[@name='billing[country_id]']"));
	  Select s1=new Select(country);
	  s1.selectByValue("UM");
	  driver.findElement(By.xpath("//input[@name='billing[telephone]']")).sendKeys("8421795993");
	  driver.findElement(By.xpath("//input[@name='billing[fax]']")).sendKeys("456788");
	  
	  ////click on countinue///
	  
	  driver.findElement(By.xpath("//div[@class='buttons-set']/button/span/span")).click();
	  Thread.sleep(2000);
	  }
  }
  @Test(priority=7)
  public void cick_on_countinue_inshippingmethod() throws Exception {
	  Thread.sleep(2000);
	  System.out.println("click on countinue");
	  driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/button")).click();
  }
  
  @Test(priority=8)
  public void enter_moneyorder() throws Exception {
	  Thread.sleep(2000);
	  System.out.println("click on money order");
	  driver.findElement(By.xpath("//input[@value='checkmo']")).click();
	  driver.findElement(By.xpath("//div[@id='payment-buttons-container']//button/span/span")).click();
  }
  
  @Test(priority=9)
  public void click_on_placeorder() throws Exception {
	  Thread.sleep(2000);
	  System.out.println("click on place order");
	  driver.findElement(By.xpath("//span[text()='Place Order']")).click();
  }
  @Test(priority=10)
  public void check_order_done() throws Exception {
	  Thread.sleep(2000);
	  System.out.println("order done succesfully");
	  String order=driver.findElement(By.xpath("//h1[text()='Your order has been received.']")).getText();
	  System.out.println(order);
	  
  }
  
  @BeforeClass
  public void maximize_page() {
	  System.out.println("maximize the webpage");
	  driver.manage().window().maximize();
  }

  @BeforeTest
  public void enter_appliacton_url() {
	  System.out.println("enter-application-url");
	  driver.get("http://live.guru99.com/	");
  }

  @BeforeSuite
  public void open_browser() {
	  System.out.println("Open---browser");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\PARESHAN\\Desktop\\Selenium\\chromedriver_win32(1)\\chromedriver.exe");
	  driver=new ChromeDriver();
	  
	  
  }

}
