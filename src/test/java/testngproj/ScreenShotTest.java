package testngproj;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class ScreenShotTest extends Base {
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void takeScreenShotTest() {
		AssertJUnit.assertEquals(true, true);
	}
	@Test
	public void takeScreenShotTestA() {
		AssertJUnit.assertEquals(true, true);
	}
}
