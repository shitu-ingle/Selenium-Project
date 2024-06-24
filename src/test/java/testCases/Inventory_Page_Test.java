package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import base.TestBase;
import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForField.Read;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class Inventory_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		login.loginToApplication();
	}
	@Test(priority = 1,enabled = true,groups = "Retest")
	public void verifyTwitterLogoTest()
	{
		boolean result = invent.verifyTwitterLogo();
		Assert.assertEquals(result,true);
		Reporter.log("Twitter Logo is present= "+result);
	}
	@Test(priority = 2,enabled =true,groups = "Sanity")
	public void verifyFacebookLogoTest()
	{
		boolean result = invent.verifyFacebookLogo();
		Assert.assertEquals(result,true);
		Reporter.log("Facebook Logo is present= "+result);
	}
	@Test(priority = 3,enabled = true,groups = "Retest")
	public void verifyLinkdInLogo()
	{
		boolean result = invent.verifyLinkdInLogo();
		Assert.assertEquals(result,true);
		Reporter.log("LinkdIn Logo is present= "+result);
	}
	@Test(priority = 6,enabled = true,groups = "Sanity")
	public void add6Products() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExecl(0,3);//6(0,3)
		String actCount=invent.add6Products();
		Assert.assertEquals(expCount,actCount);
		Reporter.log("Total products add to the cart = "+actCount);
	}
	@Test(priority = 5, enabled = true,groups = "Retest")
	public void remove2ProductsTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExecl(0,4);//4(0,4)
		String actCount=invent.remove2Products();
		Assert.assertEquals(expCount,actCount);
		Reporter.log("Total products after removed to the cart = "+actCount);
	}
	@Test(priority = 4,enabled = true,groups = {"Sanity","Regreesion"})
	public void verifyPageTitleTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExecl(0,5);//Products(0,5)
		String actTitle=invent.verifyPageTitle();
		Assert.assertEquals(expTitle,actTitle);
		Reporter.log("Inventory page title = "+actTitle);
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
