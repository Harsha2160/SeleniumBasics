package com.Javascript_Alerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\101139\\eclipse\\eclipse-workspace\\Test\\ChromeDriver\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//alert method which is part of Target Locator Interface returns Alert interface.
		Alert alert=driver.switchTo().alert();
		alert.accept();//to click on Ok. dismiss method will click on cancel.
		
		
		

	}

}
