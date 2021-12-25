package testngproj;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateSelectDropDownValues {

	@Test
	public void validateSelectDropDown() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		List<String> actualDropDownValues = new ArrayList<String>();
		List<String> expectedDropDownValues = new ArrayList<String>();

		// Load the webpage
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
		driver.manage().window().maximize();
		Select select = new Select(driver.findElement(By.xpath("//select[@name='example_length']")));

		for (WebElement ele : select.getOptions()) {
			actualDropDownValues.add(ele.getText());
		}
		expectedDropDownValues.add("10");
		expectedDropDownValues.add("25");
		expectedDropDownValues.add("50");
		expectedDropDownValues.add("100");

		for (int i = 0; i < actualDropDownValues.size(); i++) {
			System.out.println("actual:"+ actualDropDownValues.get(i) + "& expected:"+ expectedDropDownValues.get(i) );
			AssertJUnit.assertTrue(actualDropDownValues.get(i).equals(expectedDropDownValues.get(i)));
		}
		driver.quit();
	}

}
