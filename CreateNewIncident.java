package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class CreateNewIncident extends BaseForServiceNow{
  @Test
  public void CreateIncident() throws InterruptedException {
	  	driver.findElement(By.xpath("//input[@id='filter']")).click();
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='sn-widget-list-content']/div[text()='Create New'])[1]")).click();
		Thread.sleep(3000);
		driver.switchTo().frame("gsft_main");
//		driver.findElement(By.xpath("//button[text()='New']")).click();
		
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
		
		driver.switchTo().window(window.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("lookup.incident.short_description")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> window2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(window2.get(1));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[1]/td[3]/a")).click();
		driver.switchTo().window(window2.get(0));
		driver.switchTo().frame("gsft_main");
		String incNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("inc1 - "+incNumber);
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		driver.switchTo().defaultContent();
				
		Thread.sleep(3000);
		driver.switchTo().frame("gsft_main");		
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys(incNumber);
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys(Keys.ENTER);
		
		
		Thread.sleep(3000);
		String incnum2 = driver.findElement(By.xpath("//tbody[@class='list2_body']//td[3]/a")).getText();
		System.out.println("inc2 - "+incnum2);
		if(incNumber.contains(incnum2)) {
			System.out.println("correct incedent number searched");
		}else {
			System.out.println("wrong incedent numbe searched");
		}
		
	  
  }
}
