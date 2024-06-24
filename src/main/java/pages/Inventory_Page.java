package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandleDropDwonList;

public class Inventory_Page extends TestBase
{
	//object repository
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-backpack']") private WebElement productBackpack;
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-bike-light']") private WebElement productBikeLight;
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']")private WebElement productBoltTShirt;
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-fleece-jacket']") private WebElement productJacket;
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-onesie']") private WebElement productOnesie;
	@FindBy(xpath="//button[@name='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement productRedtShirt;
	@FindBy(xpath="//span[@class='title']") private WebElement pageTitle;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement linkdInLogo;
	
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement dropDwon;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath="//button[@name='remove-sauce-labs-bolt-t-shirt']") private WebElement removeProdBoltTShirt;
	@FindBy(xpath="//button[@name='remove-sauce-labs-fleece-jacket']") private WebElement removePprodJacket;
	
	//calling
	public Inventory_Page()
	{
		PageFactory.initElements(driver,this);
	}
	//methods
	public String verifyPageTitle()
	{
		return pageTitle.getText();	
	}
	public boolean verifyTwitterLogo()
	{
		return twitterLogo.isDisplayed();
	}
	public boolean verifyFacebookLogo()
	{
		return facebookLogo.isDisplayed();
	}
	public boolean verifyLinkdInLogo()
	{
		return linkdInLogo.isDisplayed();
	}
	public String add6Products() throws InterruptedException
	{
		HandleDropDwonList.handleSelect(dropDwon,"Price (low to high)");
		Thread.sleep(2000);
		productBackpack.click();
		productBikeLight.click();
		productBoltTShirt.click();
		productJacket.click();
		productOnesie.click();
		productRedtShirt.click();
		return cartIcon.getText();
	}
	public String remove2Products() throws InterruptedException
	{
		add6Products();//calling add method
		Thread.sleep(2000);
		removePprodJacket.click();
		removeProdBoltTShirt.click();
		return cartCount.getText();	
	}
	public void clickOnCart()
	{
		cartIcon.click();
	}
}
