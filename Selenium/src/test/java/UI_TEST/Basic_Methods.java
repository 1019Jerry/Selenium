package UI_TEST;

import java.awt.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic_Methods {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		//String PSource=driver.getPageSource();
		
		driver.navigate().to("http://www.saucedemo.com");
		String SauceDemourl=driver.getCurrentUrl();
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		String Product = driver.findElement(By.xpath("//*[@class='inventory_item_name ']")).getText();
		//System.out.println(Product);
		
		java.util.List<WebElement> Products = driver.findElements(By.xpath("//*[@class='inventory_item_name ']"));
		int Product_Count= Products.size();
		//System.out.println(Products);
		
		for (int i=0;i<Product_Count;i++) {
			String PName = driver.findElement(By.xpath("//*[@id='item_"+i+"_title_link']")).getText();
			System.out.println("Product No."+(i+1)+" "+PName);
			
				
		}
		
		//System.out.println(Products);
		//System.out.println(Product_Count);
		
		String window = driver.getWindowHandle();
		System.out.println(window);
		driver.findElement(By.xpath("//a[@data-test='social-facebook']")).click();
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		
		
		
		
		driver.navigate().back();
		String Backurl=driver.getCurrentUrl();
		
		driver.quit();
		
		//System.out.println("Current source : "+PSource);
//		System.out.println("Current url is: "+url);
//		System.out.println("Current Title: "+title);
//		System.out.println("Current url is: "+SauceDemourl);
//		System.out.println("Current url is: "+Backurl);
		
		
		
	}

}
