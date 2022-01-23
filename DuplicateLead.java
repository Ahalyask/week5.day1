package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead extends BaseForLeaftaps{
	
	@Test
	public void duplicateLead() throws InterruptedException {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.linkText("Email")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("aa");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		String name = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]")).getText();
		System.out.println(name);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a[@class='linktext']")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		String title = driver.getTitle();
		if(title.contains("Duplicate Lead")) {
			System.out.println("correct page - "+title);
		}else {
			System.out.println("wrong page - "+title);
		}
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		String name1 = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(name1);
		if(name.contains(name1)) {
			System.out.println("yes "+name+ " is duplicate lead");
		}else {
			System.out.println(name+" is not duplicate lead");
		}
	}

}
