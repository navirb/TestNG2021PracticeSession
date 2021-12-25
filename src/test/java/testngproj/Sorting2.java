package testngproj;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sorting2 {

	@Test
	public void handleSorting() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
		driver.manage().window().maximize();

		List<WebElement> templateNameElements = driver
				.findElements(By.cssSelector("#example >tbody>tr>td:nth-child(1)"));
		List<String> templateNames = new ArrayList<String>();

		for (WebElement namesElement : templateNameElements) {
			templateNames.add(namesElement.getText());
		}

		String nextButtonClassName = driver.findElement(By.id("example_next")).getAttribute("class");

		while (!nextButtonClassName.contains("disabled")) {
			driver.findElement(By.id("example_next")).click();
			Thread.sleep(4000);
			templateNameElements = driver.findElements(By.cssSelector("#example >tbody>tr>td:nth-child(1)"));

			for (WebElement namesElement : templateNameElements) {
				templateNames.add(namesElement.getText());
			}
			nextButtonClassName = driver.findElement(By.id("example_next")).getAttribute("class");
		}

		for (String name : templateNames) {
			System.out.println(name);
		}
		int totalNames = templateNames.size();
		System.out.println("Total names" + totalNames);

		String displayedCount = driver.findElement(By.id("example_info")).getText().split(" ")[5];
		System.out.println("Total Number of Displayed Names count : " + displayedCount);
		driver.quit();

	}
}
