package testCases;

import java.io.IOException;

import org.apache.hc.client5.http.impl.auth.AuthCacheKeeper;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.CheckOut_Step_One_Page;
import pages.CheckOut_Step_Two_Page;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshot;

public class CheckOut_Step_Two_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	Cart_Page cart;
	CheckOut_Step_One_Page check1;
	CheckOut_Step_Two_Page check2;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		cart=new Cart_Page();
		check1=new CheckOut_Step_One_Page();
		check2=new CheckOut_Step_Two_Page();
		login.loginToApplication();
		invent.add6Products();
		invent.clickOnCart();
		cart.clickonCheckOutBtn();
		check1.inputInformation();
	}
	@Test
	public void verifyPaymentInfoLableTest()
	{
		String expLable="Payment Information:";
		String actLable=check2.verifyPaymentInfoLable();
		Assert.assertEquals(expLable,actLable);
		Reporter.log("Payment Information lable is = "+actLable);
		
	}
	@Test
	public void verifySauceCradLableTest()
	{
		String expLable="SauceCard #31337";
		String actLable=check2.verifySauceCradLable();
		Assert.assertEquals(expLable,actLable);
		Reporter.log(" Sauce Card lable is = "+actLable);
	}
	@Test
	public void clickOnFinishBtnTest()
	{
		String expURL="https://www.saucedemo.com/checkout-complete.html";
		String actURL=check2.clickOnFinishBtn();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("Complete Page URL = "+actURL);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.cs(it.getName());
		}
		driver.close();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
