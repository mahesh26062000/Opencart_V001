package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver driver)
	{
		super(driver);
	}
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	@FindBy(xpath="//button[@id='button-payment-methods']")
	WebElement btnChoosePayment;
	
	@FindBy(xpath="//input[@id='input-payment-method-bank_transfer-bank-transfer']")
	WebElement radioBankransfer;
	
	@FindBy(xpath="//button[@id='button-payment-method']")
	WebElement btnContinue;
	
	@FindBy(xpath="//button[@id='button-confirm']")
	WebElement btnConfirmOrder;
	
	public void clickChoosePayment()
	{
		btnChoosePayment.click();
	}
	
	public void clickBankTransfer()
	{
		radioBankransfer.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public void clickConfirmOrder() throws InterruptedException
	{
		js.executeScript("arguments[0].scrollIntoView();", btnConfirmOrder);
		Thread.sleep(3000);
		btnConfirmOrder.click();
	}
}
