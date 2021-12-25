package testngproj;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sorting {

	@Test
	public void handlingPaginationB() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		List<String> templateNames = new ArrayList<String>();

		//Load the webpage
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");

		//xpath for next button disabled.
		List<WebElement> nextButtonDisabled = driver
				.findElements(By.xpath("//a[@class='paginate_button next disabled']"));

		// Load all the values of first column
		List<WebElement> templateNameElements = driver
				.findElements(By.cssSelector("#example >tbody>tr>td:nth-child(1)"));
		for (WebElement templtNames : templateNameElements) {
			templateNames.add(templtNames.getText());
		}

		//Pagination
		while (nextButtonDisabled.size() == 0) {
			//Click on the next button if enabled.
			driver.findElement(By.id("example_next")).click();
			Thread.sleep(2000);
			//Capture all the templateNames from further pages
			templateNameElements = driver.findElements(By.cssSelector("#example >tbody>tr>td:nth-child(1)"));
			for (WebElement templtNames : templateNameElements) {
				templateNames.add(templtNames.getText());
			}
			//capture the xpath of next button disabled.
			nextButtonDisabled = driver.findElements(By.xpath("//a[@class='paginate_button next disabled']"));
		}
		//Iterate all the template names from the list.
		for (String tmplname : templateNames) {
			System.out.println(tmplname);
		}
		int totalTemplateNames = templateNames.size();
		System.out.println("Total number of Names:" + totalTemplateNames);
		
		//Validate the sorting
		/*
		 * List<String> sortedList =
		 * templateNames.stream().sorted().collect(Collectors.toList());
		 */
		//Assert.assertTrue(templateNames.equals(sortedList));
		driver.quit();

	}
}
