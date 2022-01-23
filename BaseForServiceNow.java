package week5.day1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseForServiceNow {
	
	ChromeDriver driver;

  @BeforeMethod
  public void beforeMethod() {
	  	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://dev79778.service-now.com/navpage.do");
		driver.manage().window().maximize();		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("C5xHExNbgYz2");
		driver.findElement(By.id("sysverb_login")).click();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  
  }

}
