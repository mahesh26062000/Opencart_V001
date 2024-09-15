package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_002_Login_DDT extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_login(String email, String pwd, String exp)
	{
		try
		{
			logger.info("Starting Test Cases.....");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account...");
			hp.clickLogin();
			logger.info("Clicked on Register...");
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			logger.info("Provided Login Details...");
			lp.clickLogin();
			logger.info("Clicked on Login...");
			
			MyAccountPage map = new MyAccountPage(driver);
			System.out.println("My account page...");
			System.out.println(map.isSuccessMsgDisplayed());
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(map.isSuccessMsgDisplayed())
				{
					map.clickLogout();
					Assert.assertTrue(true);
				}
				else 
				{
					
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(map.isSuccessMsgDisplayed())
				{
					map.clickLogout();
					Assert.assertTrue(false);
				}
				else 
				{
					Assert.assertTrue(true);
				}
			}
			
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("Finished Test Cases...");
	}
}
