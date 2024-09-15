package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//div[@id='product-list']//div[@class='content']//a")
	List<WebElement> productList;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement inputQuantity;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement btnAddToCart;
	
	@FindBy(xpath="//div[@id='alert']//div[@class='alert alert-success alert-dismissible']")
	WebElement txtSuccessMsg;
	
	@FindBy(xpath="//a[@class='check_out']")
	WebElement btnCheckOut;
	
	public boolean isProductExist(String productName)
	{
		for(WebElement element: productList)
		{
			if(element.getText().equalsIgnoreCase(productName))
			{
				return true;
			}
		}
		return false;
	}
	
	public void selectProduct(String productName)
	{
		for(WebElement element: productList)
		{
			if(element.getText().equalsIgnoreCase(productName))
			{
				System.out.println("Product Selected");
				element.click();
				break;
			}
		}
	}
	
	public void setQuantity(String quantity)
	{
		System.out.println("Setting quantity");
		inputQuantity.clear();
		inputQuantity.sendKeys(quantity);
		
	}
	
	public void clickAddToCart()
	{
		btnAddToCart.click();
	}
	
	public boolean checkConfirmMsg()
	{
		System.out.println(txtSuccessMsg.getText());
		if(txtSuccessMsg.getText().equals("Success: You have added MacBook to your shopping cart!"))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void clickCheckout()
	{
		btnCheckOut.click();
	}
}
