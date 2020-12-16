package org.test;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProgramFirst {
	
	public WebDriver driver;
	
	@BeforeClass
	private void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Punis\\eclipse-workspace-ashok\\Example\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Parameters({"searchkey","heading","heading1","heading2"})
	@Test
	private void tc1(String a,String b,String c,String d) throws InterruptedException {
		
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys(a);
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		
		Thread.sleep(3000);
		List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		System.out.println(b);
		Set<String> s= new TreeSet<String>();
 		
		for(int i=0;i<productNames.size();i++) {
			WebElement webElement = productNames.get(i);
			String productName = webElement.getText();
			System.out.println(productName + '\n');
			s.add(productName);
		}
		
		System.out.println('\n' + c);
		for (String temp : s) {
			System.out.println(temp);
		}
		
		List<WebElement> productCostList = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		System.out.println('\n' + d);
		
		for(int j=0;j<productCostList.size();j++) {
			WebElement webElement1 = productCostList.get(j);
			String productCost = webElement1.getText();
			String productCost1 = productCost.substring(1);
			String productCost2 = productCost1.replace(",", "");
			
			if((Integer.parseInt(productCost2))> 10000) {
				System.out.println(productCost1+'\n');
			}
		}
		}
	
	@AfterClass
	private void quitBrowser() {
        //driver.quit();
	}
	

}
