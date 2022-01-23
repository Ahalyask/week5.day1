package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AssignIncident extends BaseForServiceNow{
  @Test
  public void Assignincident() throws InterruptedException {
	  
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
		driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']/span[@class='icon icon-search']")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Software",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
		Thread.sleep(2000);
		driver.switchTo().window(window.get(0));
		driver.switchTo().frame("gsft_main");
		
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("testing");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='form_action_button header  action_context btn btn-default'])[1]")).click();
		Thread.sleep(3000);
		String assignedGroup = driver.findElement(By.xpath("//tbody[@class='list2_body']//td[10]")).getText();
		if(assignedGroup.equals("Software")) {
			System.out.println("Assigned group updated successfully -"+assignedGroup);
		}else {
			System.out.println("Assigned group is not updated -"+assignedGroup);
		}
		
		
  }
}
