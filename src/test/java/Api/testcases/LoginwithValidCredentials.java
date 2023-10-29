package Api.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import Api.utilities.DataProviders;

public class LoginwithValidCredentials {

	@Test(dataProvider="UserNamesData",dataProviderClass = DataProviders.class)
	public void testRegister1(String username) throws InterruptedException {
		   
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\PRAVEENA\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver.exe");
  	// install the che driver
		 
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
	WebDriver	driver = new ChromeDriver(options);		
				
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(username);
		Thread.sleep(3000);
		
		//driver.findElement(By.name("pwd")).sendKeys(password);
		Thread.sleep(3000);
		/*driver.findElement(By.id("username")).sendKeys(lastname);
		Thread.sleep(3000);
		driver.findElement(By.name("pwd")).sendKeys(phonenumber);
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys(address);
		Thread.sleep(3000);
		driver.findElement(By.name("pwd")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys(city);
		Thread.sleep(3000);
		driver.findElement(By.name("pwd")).sendKeys(state);
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys(postercode);
		Thread.sleep(3000);
		driver.findElement(By.name("pwd")).sendKeys(username);
		Thread.sleep(3000);
		driver.findElement(By.name("pwd")).sendKeys(password);
		Thread.sleep(3000);
		
		
		
	System.out.println("yes");*/
}
}
	

