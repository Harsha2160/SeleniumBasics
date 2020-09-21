package com.SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClass {

	public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\101139\\eclipse\\"
    		+ "eclipse-workspace\\Test\\ChromeDriver\\chromedriver.exe");
    WebDriver driver=null;
    driver=new ChromeDriver();
    String url="http://demo.guru99.com/test/newtours/register.php";
    driver.get(url);
    driver.manage().window().maximize();
    Select S=new Select(driver.findElement(By.xpath("//select[@name='country']")));
    S.selectByIndex(0);
    Thread.sleep(4000);
    S.selectByValue("ALGERIA");
    Thread.sleep(4000);
    S.selectByVisibleText("AMERICAN SAMOA");
    Thread.sleep(4000);
    driver.quit();
    

	}

}
