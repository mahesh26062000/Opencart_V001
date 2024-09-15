package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement txtMyAccount;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement inputSearch;
	
	@FindBy(xpath="//div[@id='search']//button[@class='btn btn-light btn-lg']")
	WebElement btnSearch;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btnLogout;
	
	public boolean isSuccessMsgDisplayed()
	{
		
		try
		{
			return (txtMyAccount.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void setSearchText(String searchTerm)
	{
		inputSearch.sendKeys(searchTerm);
	}
	
	public void clickSearch()
	{
		btnSearch.click();
	}
	
	public void clickLogout() throws InterruptedException
	{
		System.out.println("Logout called");
		Thread.sleep(3000);
		btnLogout.click();
		Thread.sleep(3000);
		System.out.println("Logout clicked");
	}
	
}
