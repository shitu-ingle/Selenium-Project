package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOut_Step_Two_Page extends TestBase
{
	@FindBy(xpath="//div[text()='Payment Information:']") private WebElement paymentInfoLable;
	@FindBy(xpath="//div[text()='SauceCard #31337']") private WebElement sauceCardLable;
	@FindBy(xpath="//button[@id='finish']") private WebElement finishBtn;
	public CheckOut_Step_Two_Page()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyPaymentInfoLable()
	{
		return paymentInfoLable.getText();
	}
	public String verifySauceCradLable()
	{
		return sauceCardLable.getText();
	}
	public String clickOnFinishBtn()
	{
		finishBtn.click();
		return driver.getCurrentUrl();
	}
}
