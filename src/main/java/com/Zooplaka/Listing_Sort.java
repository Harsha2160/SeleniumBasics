package com.Zooplaka;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Listing_Sort {

public static void main(String[] args) {

//Navigate to the URL
	
System.setProperty("webdriver.chrome.driver","C:\\Users\\101139\\eclipse\\eclipse-workspace\\Test\\ChromeDriver\\chromedriver.exe");
WebDriver driver = null;
driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
String url = "https://www.zoopla.co.uk/";
driver.get(url);
driver.manage().window().maximize();

//Search for a city

driver.findElement(By.xpath("//button[text()='Save my preferences']")).click();
WebElement Search = driver.findElement(By.id("search-input-location"));
Search.sendKeys("london");
Search.sendKeys(Keys.ENTER);

//Locate the price Tags of listings

List<WebElement> listing = driver.findElements(By.xpath("//*[@class='listing-results-price text-price']"));
String myRegex = "[^0-9]";

//Instantiation of ArrayList and TreeSet

ArrayList<Long>listing_list=new ArrayList<Long>();
TreeSet<Long>listing_Set=new TreeSet<Long>();

//Converting PriceTags into Long values and adding to a list

for (Iterator<WebElement> iterator = listing.iterator(); iterator.hasNext();) {
	WebElement webElement = iterator.next();
	String S=webElement.getText();
	String price=S.replaceAll(myRegex,"");
	Long price_value=Long.parseLong(price);
	listing_list.add(price_value);
	
}
//HashSet is unordered. TreeSet by default displays in ascending order.

//Adding list of values into TreeSet

for (Iterator<Long>iterator = listing_list.iterator(); iterator.hasNext();) {
	Long listing_price_final = iterator.next();
	listing_Set.add(listing_price_final);
	
}
//Sorting a List in ascending order
Collections.sort(listing_list);
//Sorting a List in descending order
Collections.sort(listing_list, Collections.reverseOrder());

//displaying List in descending order
System.out.println("displaying List in descending order with duplicates");

Iterator<Long>it_list=listing_list.iterator();
while(it_list.hasNext())
{
	System.out.println(it_list.next());
	
}

for(int i=0;i<5;i++)
System.out.println("\n");

//displaying TreeSet by default in ascending order without duplicates

System.out.println("displaying TreeSet by default in ascending order without duplicates");
Iterator<Long>it_set=listing_Set.iterator();
while(it_set.hasNext())
{
	System.out.println(it_set.next());
	
}
for(int i=0;i<5;i++)
System.out.println("\n");

System.out.println("displaying TreeSet in descending order without duplicates");

Iterator<Long>it_set_desc=listing_Set.descendingIterator();
while(it_set_desc.hasNext())
{
	System.out.println(it_set_desc.next());
	
}


}

		
		

}
