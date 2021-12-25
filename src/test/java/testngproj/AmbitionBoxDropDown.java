package testngproj;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmbitionBoxDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ambitionbox.com/reviews/tcs-reviews");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//p[normalize-space()='Designation']")).click();
		Thread.sleep(1000);
		List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='checkbox']//label//div"));
		// System.out.println(elementList);
		List<String> departmentList = new ArrayList<String>();
		int i=1;
		for (WebElement ele : elementList) {
			if (!ele.getText().isEmpty()) {
				//System.out.println(ele.getText());
				departmentList.add(ele.getText());
				
			}
			i++;
			
		}
		
		//System.out.println(newEle);
		for(String newEle:departmentList)
		{			
			System.out.println(newEle);
		}
	}

}
