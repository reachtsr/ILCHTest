package com.ilch.testCase.superAdmin;

import com.ilch.Constants;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

import junit.framework.Assert;
import static org.apache.commons.lang3.StringUtils.join;

public class SuperAdminActivateDeActivateEmployer {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();

		selenium = new WebDriverBackedSelenium(driver, Constants.BASE_URL );
	}

	@Test
	public void testSuperAdminDeActivateEmployer() throws Exception {
		
		selenium.open(Constants.APP_URL);
		selenium.typeKeys("name=userName", "superadmin");
		selenium.typeKeys("name=password", "allibilli");
		selenium.click("name=lsubmit");
		selenium.waitForPageToLoad("90000");
		selenium.click("link=Enable or Disable Business");
		selenium.waitForPageToLoad("90000");
		selenium.click("name=deActive");
		selenium.click("link=Signout");
		selenium.waitForPageToLoad("90000");
		selenium.click("link=Home");
		selenium.waitForPageToLoad("90000");
		selenium.typeKeys("name=userName", "demoemployer");
		selenium.typeKeys("name=password", "allibilli");
		selenium.click("name=lsubmit");
		selenium.waitForPageToLoad("90000");
		selenium.click("name=active");
		selenium.click("link=Signout");
		selenium.waitForPageToLoad("90000");
		selenium.click("link=Home");
		selenium.waitForPageToLoad("90000");
		selenium.typeKeys("name=userName", "superadmin");
		selenium.typeKeys("name=password", "allibilli");
		selenium.click("name=lsubmit");
		selenium.waitForPageToLoad("90000");
		selenium.click("link=Enable or Disable Business");
		selenium.waitForPageToLoad("90000");
		selenium.click("link=Signout");
		selenium.waitForPageToLoad("90000");
		selenium.click("link=Home");
		selenium.waitForPageToLoad("90000");
		
		Assert.assertTrue(selenium.isTextPresent("This user has been removed. Please contact us if you need help. "));		
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
