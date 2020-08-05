package com.WindowHandles;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\101139\\eclipse\\eclipse-workspace\\Test\\ChromeDriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.toolsqa.com/selenium-webdriver/handling-multiple-browsers-in-selenium-webdriver/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()=' http://toolsqa.com/automation-" + "practice-switch-windows/']"))
				.click();
       
		Set<String> S = driver.getWindowHandles();
		// The Set interface does not provide any ordering guarantees.
		Iterator<String> it = S.iterator();
		while (it.hasNext()) {
			String string = it.next();
			System.out.println(string);
			driver.switchTo().window(string);
			try 
			{
				driver.findElement(By.xpath("//h1[text()='403 - Forbidden']"));
				System.out.println("Window Handle found");
				break;
			} 
			catch (Exception e) 
			{
				driver.switchTo().window(string).close();
				System.out.println("Exception thrown-Wrong Window");
				continue;
			}

		}
		driver.get("https://www.google.co.in/");

	}

}
