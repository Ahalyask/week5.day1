package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead extends BaseForLeaftaps{
	
	
	  @BeforeMethod
	  public void beforeMethod() {
		  WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps/control/login");
			driver.manage().window().maximize();
			driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Contacts")).click();
	  }

	
	@Test
	public void mergeLead() {		
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();		
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::a[1]")).click();		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> window1 = new ArrayList<String>(windowHandles1);		
		driver.switchTo().window(window1.get(1));
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();		
		driver.switchTo().window(window1.get(0));
		
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::a[2]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> window2 = new ArrayList<String>(windowHandles2);		
		driver.switchTo().window(window2.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		driver.switchTo().window(window2.get(0));
		
		
		driver.findElement(By.linkText("Merge")).click();
		driver.switchTo().alert().accept();
		
		String title = driver.getTitle();
		if(title.contains("View Contact | opentaps CRM")) {
			System.out.println("title verified successfully");
		}else {
			System.out.println("wrong page");
		}
		
		driver.close();
	}
}
