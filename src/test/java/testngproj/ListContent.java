package testngproj;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListContent {
	@Test
	public void validateList()
	{
		List<String> listConent = new ArrayList<String>();
		listConent.add("abc");
		listConent.add(" ");
		listConent.add("bac");
		System.out.println(listConent);
		AssertJUnit.assertTrue(listConent.contains(" "));
		
	}

}
