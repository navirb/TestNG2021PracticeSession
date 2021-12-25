package testngproj;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmbitionBoxTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.ambitionbox.com/reviews/tcs-reviews");
		driver.manage().window().maximize();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//p[contains(text(),'If you are a fresher')]")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//p[contains(text(),'Rate the company')]")).click();
		Thread.sleep(20000);
		Set<String> windowList = driver.getWindowHandles();
		for (String windowsId : windowList) {
			driver.switchTo().window(windowsId);
		}
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}
}
