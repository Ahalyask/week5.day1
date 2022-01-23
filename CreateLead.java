package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseForLeaftaps{
	
	@Test(invocationCount = 3)
	public void createLead() throws InterruptedException {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Noesys");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Ahalya");		
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("S K");
		driver.findElement(By.name("submitButton")).click();
		driver.close();
}

}
