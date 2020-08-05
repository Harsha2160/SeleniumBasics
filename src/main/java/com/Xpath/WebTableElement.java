package com.Xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableElement {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\101139\\eclipse\\eclipse-workspace\\Test\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.timeanddate.com/worldclock/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Kolkata')]//parent::td//preceding-sibling::td"
				+ "//following-sibling::td//following-sibling::td//a[text()=\"Casablanca\"]")).click();

	}

}
