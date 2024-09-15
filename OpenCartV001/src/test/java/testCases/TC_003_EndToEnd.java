package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.OrderPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_003_EndToEnd extends BaseClass {

	@Test(groups= {"master"})
	public void verify_endToEnd() {
		try {
			logger.info("Starting Test Cases.....");
			SoftAssert myassert = new SoftAssert();
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account...");
			hp.clickLogin();
			logger.info("Clicked on Register...");
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			logger.info("Provided Login Details...");
			lp.clickLogin();
			logger.info("Clicked on Login...");

			MyAccountPage map = new MyAccountPage(driver);
			System.out.println("My account page...");
			logger.info("My Account Page...");
			System.out.println(map.isSuccessMsgDisplayed());
			myassert.assertEquals(map.isSuccessMsgDisplayed(), true);
			//Last line for assert is pending
			
			logger.info("Search Product...");
			map.setSearchText(p.getProperty("searchProduct"));
			map.clickSearch();
			Thread.sleep(3000);
			
			SearchPage sp = new SearchPage(driver);
			if(sp.isProductExist(p.getProperty("searchProduct")))
			{
				logger.info("Product Exist...");
				logger.info("Selecting Product...");
				sp.selectProduct(p.getProperty("searchProduct"));
				logger.info("Specifying quantity...");
				sp.setQuantity("2");
				logger.info("Click Add To Cart...");
				sp.clickAddToCart();
			}
			else 
			{
				logger.error("Product doesn't exist!");
				myassert.fail();
				return;
			}
			
			logger.info("Checking added to cart");
			myassert.assertEquals(sp.checkConfirmMsg(), true);
			
			logger.info("Clicking checkout...");
			sp.clickCheckout();
			
			CheckoutPage checkout = new CheckoutPage(driver);
			logger.info("Choosing Payment...");
			checkout.clickChoosePayment();
			checkout.clickBankTransfer();
			logger.info("Clicking continue...");
			checkout.clickContinue();
			Thread.sleep(3000);
			
			checkout.clickConfirmOrder();
			
			OrderPage order = new OrderPage(driver);
			logger.info("Checking Order Status...");
			Thread.sleep(2000);
			System.out.println("Order Success : " + order.isOrderSuccess());
			myassert.assertEquals(order.isOrderSuccess(), true);
			
			myassert.assertAll();

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("Finished Test Cases...");
	}
	
}
