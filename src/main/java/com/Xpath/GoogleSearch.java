package com.Xpath;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearch {

	    public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\101139\\eclipse\\eclipse-workspace\\Test\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http:Google.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Testing");
		//using Explicit wait to overcome Stale Element Exception.
		
		WebDriverWait ww = new WebDriverWait(driver, 30);
				
		try
		{
		ww.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("//ul[@role='listbox' and @class='erkvQe']//li//div//div"
							+ "//following-sibling::div[@role='option']//div[@class='sbl1']//span")));	
		}
		catch(Exception e)
		{
		System.out.println("Exception throwed");
		try                                      //nested Try-Catch to make it fail proof
		{
		ww.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("//ul[@role='listbox' and @class='erkvQe']//li//div//div"
							+ "//following-sibling::div[@role='option']//div[@class='sbl1']//span")));	
		}
		catch(Exception ex)
		{
		System.out.println("Exception throwed second time");
		try                                      //nested Try-Catch to make it fail proof
		{
		ww.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("//ul[@role='listbox' and @class='erkvQe']//li//div//div"
							+ "//following-sibling::div[@role='option']//div[@class='sbl1']//span")));	
		}
		catch(Exception exa)
		{
		System.out.println("Exception throwed Third time");
		ww.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("//ul[@role='listbox' and @class='erkvQe']//li//div//div"
							+ "//following-sibling::div[@role='option']//div[@class='sbl1']//span")));
		}
		}
		}
		
		
	
		// Refer XPath Axes for more info.
		//Good example of locating Dynamic Element using XPATH. 
		
		
		
		
		
		List<WebElement> list = driver.findElements(
				By.xpath("//ul[@role='listbox' and @class='erkvQe']//li//div//div"
						+ "//following-sibling::div[@role='option']//div[@class='sbl1']//span"));
		for (int i = 0; i < list.size(); i++) {
			String S = list.get(i).getText();
			System.out.println(S);
		}
		for (int i = 0; i < list.size(); i++) {
			String S = list.get(i).getText();
			if (S.equals("testing types")) 
			{
				list.get(i).click();
				list.clear();
				break; // Break is mandatory else stale element reference exception is displayed
			}
			}
		driver.quit();

	        }

            }


