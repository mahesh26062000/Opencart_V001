package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterAccountPage;
import testBase.BaseClass;

public class TC_001_AccountRegister extends BaseClass {

	@Test(groups= {"sanity", "master"})
	public void verify_register_account()
	{
	
		try 
		{
			logger.info("Starting Test Cases.....");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account...");
			hp.clickRegister();
			logger.info("Clicked on Register...");
			
			RegisterAccountPage rp = new RegisterAccountPage(driver);
			String fName = randomString().toUpperCase();
			rp.setFirstName(fName);
		
			rp.setLastName(randomString().toUpperCase());
			rp.setEmail(randomString() + "@gmail.com");
			
			String password = randomAlphaNumeric();
			
			rp.setPassword(password);
			
			rp.clickIsAgree();
			logger.info("Providing the customer details...");
			
			rp.clickContinue();
			logger.info("Clicked on Continue...");
			
			logger.info("Validating expected message");
			String msg = rp.getConfirmMessage();
			if(msg.equals("Your Account Has Been Created!"))
			{
				logger.info("Test Passed...");
				Assert.assertTrue(true);
			}
			else 
			{
				logger.error("Test Failed");
				logger.debug("Debug...");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug...");
			Assert.fail();
		}
		logger.info("Finished Test Cases.....");
	}
}
