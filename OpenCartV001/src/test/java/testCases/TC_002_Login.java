package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass {

	@Test(groups= {"regression", "master"})
	public void verify_login() {
		try {
			logger.info("Starting Test Cases.....");
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
			System.out.println(map.isSuccessMsgDisplayed());

			if (map.isSuccessMsgDisplayed()) {
				map.clickLogout();
				Assert.assertTrue(true);
			} else {

				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("Finished Test Cases...");
	}
}
