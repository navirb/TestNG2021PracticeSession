package testngproj;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmbitionBoxTest1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ambitionbox.com/overview/tcs-overview");
		Thread.sleep(20000);
		List<WebElement> elements =driver.findElements(By.xpath("//div[@id='salary-cards']//div/following-sibling::div[@class='shadow-buffer lslide']//a"));
		List<String> names= new ArrayList<String>();
		for(WebElement ele :elements)
		{
			names.add(ele.getAttribute("href"));
		}
		for(WebElement ele :elements)
		{
			ele.click();
			break;
		}
		System.out.println("My URL:"+names.get(0));
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(names.get(0), driver.getCurrentUrl());
	}
}
