package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase
{
	//object repository
	@FindBy(xpath="//input[@id='user-name']") private WebElement userTxtBox;
	@FindBy(xpath="//input[@id='password']") private WebElement passWordTxtBox;
	@FindBy(xpath="//input[@id='login-button']") private WebElement loginBtn;
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	public String loginToApplication() throws IOException
	{
		logger=report.createTest("Login to Sauce Lab Application");
		userTxtBox.sendKeys(ReadData.readPropertyFile("Username"));//stanuser
		logger.log(Status.INFO,"User name is entered");
		passWordTxtBox.sendKeys(ReadData.readPropertyFile("Password"));//scretsc
		logger.log(Status.INFO,"Password is entered");
		loginBtn.click();
		logger.log(Status.INFO,"Login button is cliked");
		logger.log(Status.PASS,"Login is sucessfull");
		return driver.getCurrentUrl();
	}
	public String verifyMultiCredentials(String un,String password)
	{
		userTxtBox.sendKeys(un);
		passWordTxtBox.sendKeys(password);
		loginBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();	
	}
	public String verifyTitleOfApplication()
	{
		return driver.getTitle();
	}

}//firstname 
//last name 
//eamild id
//login button 
