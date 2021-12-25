package testngproj;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends Base implements ITestListener
{
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("FAILED Test");
			try {
				failed(result.getMethod().getMethodName());
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
