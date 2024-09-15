package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BasePage{

	public OrderPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h1[normalize-space()='Your order has been placed!']")
	WebElement txtSuccessMsg;
	
	public boolean isOrderSuccess()
	{
		System.out.println( "Order Status : " + txtSuccessMsg.getText());
		if(txtSuccessMsg.getText().equals("Your order has been placed!"))
		{
			System.out.println("Success");
			return true;
		}
		else 
		{
			System.out.println("Fail");
			return false;
		}
	}
}
