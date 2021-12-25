package testngproj;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WordPressTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://wordpress.com/start/user");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("bdtet120456reddy@gmail.com");

		List<WebElement> usernameList = driver.findElements(By.xpath("//input[@type='text']"));
		if (usernameList.size() > 0) {
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys("newuse0rname10108");
		}
		List<WebElement> passwordList = driver.findElements(By.xpath("//input[@type='password']"));
		if (passwordList.size() > 0) {
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("newusername2158608");
		}
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(15000);
		
		driver.findElement(By.xpath("//a[@class='button navigation-link back is-borderless']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[@class='button navigation-link back is-borderless']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		Thread.sleep(5000);

		/*
		 * driver.findElement(By.xpath("//span[text()='Posts']")).click();
		 * Thread.sleep(5000);
		 * 
		 * driver.findElement(By.xpath("//a[text()='Add new post']")).click();
		 * Thread.sleep(5000);
		 */

		/*
		 * driver.findElement(By.xpath("//button[text()='Skip']")).click();
		 * Thread.sleep(5000); //button[text()='Skip']
		 */

		/*
		 * driver.findElement(By.xpath("//p[@role='document']")).
		 * sendKeys("This is first post"); Thread.sleep(5000);
		 * 
		 * driver.findElement(By.xpath("//button[text()='Publish']")).click();
		 * Thread.sleep(5000);
		 * 
		 * driver.findElement(By.xpath("//button[text()='Publish']")).click();
		 * Thread.sleep(5000);
		 * 
		 * driver.findElement(By.xpath("//button[@aria-label='Block editor sidebar']")).
		 * click(); Thread.sleep(5000);
		 * 
		 * driver.findElement(By.
		 * xpath("//a[@aria-description='Returns to the dashboard']")).click();
		 * Thread.sleep(5000);
		 */

		driver.findElement(By.xpath("//img[@alt='My Profile']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Log out']")).click();

		/*
		 * driver.findElement(By.xpath("//input[@id='search-component-search-1']")).
		 * sendKeys("bestbankings.in"); Thread.sleep(5000);
		 * driver.findElement(By.xpath("(//button[text()='Select'])[1]")).click();
		 * Thread.sleep(5000);
		 * driver.findElement(By.xpath("//button[contains(text(),'start with a free')]")
		 * ).click(); Thread.sleep(15000);
		 */

	}

}
