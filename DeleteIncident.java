package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class DeleteIncident extends BaseForServiceNow{
  @Test
  public void deleteIncident() throws InterruptedException {
	  driver.findElement(By.xpath("//input[@id='filter']")).click();
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("all");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='sn-widget-list-content']/div[text()='All'])[2]")).click();
		driver.switchTo().frame("gsft_main");	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys("INC0010030");
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys(Keys.ENTER);		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tbody[@class='list2_body']//td[3]/a")).click();		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@id='sysverb_delete']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys("INC0010030");
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys(Keys.ENTER);	
		
		String text = driver.findElement(By.xpath("//tbody[@class='list2_body']//td")).getText();
		if(text.contains("No records to display")) {
			System.out.println("Incident deleted Successfully");
		}
		else {
			System.out.println("Incident is nor deleted");
		}
		
	  
  }
}
