package testngproj;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationConceptTest {

	@Test
	public void handlingPagination() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		List<String> names = new ArrayList<String>();

		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
		List<WebElement> namesElements = driver.findElements(By.cssSelector("#example >tbody>tr>td:nth-child(1)"));
		for (WebElement namesElement : namesElements) {
			names.add(namesElement.getText());
		}

		String nextButtonClassName = driver.findElement(By.id("example_next")).getAttribute("class");
		while (!nextButtonClassName.contains("disabled")) {
			driver.findElement(By.id("example_next")).click();
			Thread.sleep(4000);
			namesElements = driver.findElements(By.cssSelector("#example >tbody>tr>td:nth-child(1)"));
			for (WebElement namesElement : namesElements) {
				names.add(namesElement.getText());
			}
			nextButtonClassName = driver.findElement(By.id("example_next")).getAttribute("class");
		}
		for (String name : names) {
			System.out.println(name);
		}
		int totalNames = names.size();
		System.out.println("Total number of Names:" + totalNames);

		String displayedCount = driver.findElement(By.id("example_info")).getText().split(" ")[5];
		System.out.println("Total Number of displayed Names count: " + displayedCount);
		AssertJUnit.assertEquals(displayedCount, String.valueOf(totalNames));
		Thread.sleep(5000);
		driver.quit();
		
		

	}
}
