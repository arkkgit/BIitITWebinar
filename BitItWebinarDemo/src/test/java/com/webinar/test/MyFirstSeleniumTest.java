package com.webinar.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstSeleniumTest {
	
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();
		
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email")).sendKeys("webinar@bitit.com");
		driver.findElement(By.id("passwd")).sendKeys("password");
		driver.findElement(By.name("SubmitLogin")).click();
		
		boolean isSignOutDisplayed = driver.findElement(By.linkText("Sign out")).isDisplayed();
		System.out.println("Is signout displayed? : "+isSignOutDisplayed);
		
		String phone = driver.findElement(By.className("shop-phone")).getText();
		System.out.println("The phone is : "+phone);
		
		// Actions is to replicate hover, double click, right click, sending key combinations like Alt+A etc.
		Actions myActions = new Actions(driver);
		
		WebElement dressLink = driver.findElement(By.linkText("DRESSES"));
		
		myActions.moveToElement(dressLink).build().perform();
		
		//to upload a file send keys to the choose file element
		//driver.findElement(By.id("fileUpload")).sendKeys("c:/Pros/a.txt");
		
		
		driver.close();
		
	}
	

}
