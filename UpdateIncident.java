package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateIncident extends BaseForServiceNow{
  @Test
  public void updateIncident() throws InterruptedException {
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
		
		Select UrgSel = new Select(driver.findElement(By.xpath("//select[@id='incident.urgency']")));
		UrgSel.selectByVisibleText("1 - High");
		Thread.sleep(1000);
		Select statusSel = new Select(driver.findElement(By.xpath("//select[@id='incident.state']")));
		statusSel.selectByVisibleText("In Progress");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@id='activity-stream-work_notes-textarea']")).sendKeys("testing");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='form_action_button header  action_context btn btn-default'])[1]")).click();
		Thread.sleep(3000);
		String updatesStatus = driver.findElement(By.xpath("//tbody[@class='list2_body']//td[8]")).getText();
		if(updatesStatus.equals("In Progress")) {
			System.out.println("status updated successfully -"+updatesStatus);
		}else {
			System.out.println("status is not updated -"+updatesStatus);
		}		
		
		String updatesPriority = driver.findElement(By.xpath("//tbody[@class='list2_body']//td[7]")).getText();
		if(updatesPriority.equals("3 - Moderate")) {
			System.out.println("Priority updated successfully -"+updatesPriority);
		}else {
			System.out.println("Priority is not updated -"+updatesPriority);
		}
  }
}
