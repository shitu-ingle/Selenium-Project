package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class VerifyMultiCredsTest extends TestBase
{
	LoginPage login;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login=new LoginPage();
	}
	@DataProvider(name="Validation")
	public Object[][] getData()
	{
		
		return new Object [][]
				{
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
			{"error_user","secret_sauce"},
			{"visual_user","secret_sauce"}
			};
	}
	@Test(dataProvider = "Validation")
	public void verifyMultiCredentialsTest(String un,String password)
	{
		SoftAssert s=new SoftAssert();
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=login.verifyMultiCredentials(un, password);
		s.assertEquals(expURL,actURL);
		s.assertAll();
		
	}
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.cs(it.getName());
		}
		driver.close();
	}

}

