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

public class OutageNotificationCreateAndDisplay {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		
		selenium = new WebDriverBackedSelenium(driver, Constants.BASE_URL);
	}

	@Test
	public void testOutageNotificationDisplay() throws Exception {

		// superadmin submitting the outage notification
		
		selenium.open(Constants.APP_URL);
		selenium.typeKeys("name=userName", "superadmin");
		selenium.typeKeys("name=password", "allibilli");
		selenium.click("name=lsubmit");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Set Outage Notification");
		selenium.waitForPageToLoad("30000");
		selenium.typeKeys("id=outageDate", "09-18-2013");
		selenium.typeKeys("name=startTime", "13:00");
		selenium.typeKeys("name=endTime", "13:50");
		selenium.click("css=input.ButtonStyle");
		selenium.waitForPageToLoad("300000");

		selenium.open(Constants.APP_URL);
		selenium.waitForPageToLoad("450000");
		selenium.click("link=Signout");
		
//		Demoemployer login 
		selenium.open(Constants.APP_URL);
		selenium.typeKeys("name=userName", "demoemployer");
		selenium.typeKeys("name=password", "allibilli");
		selenium.click("name=lsubmit");
		selenium.waitForPageToLoad("350000");
		selenium.click("id=websiteIfnoTxt");
		selenium.click("link=Signout");
		
		Assert.assertTrue(selenium.isTextPresent("ILCH is about to have an upgrade and will be down during"));
		
//		demoWeekly login 
		selenium.waitForPageToLoad("350000");

		selenium.open(Constants.APP_URL);
		selenium.waitForPageToLoad("350000");
		selenium.typeKeys("name=userName", "demoweekly");
		selenium.typeKeys("name=password", "allibilli");
		selenium.click("name=lsubmit");
		selenium.waitForPageToLoad("350000");
		selenium.click("link=Signout");
		selenium.waitForPageToLoad("350000");		
		
		Assert.assertTrue(selenium.isTextPresent("ILCH is about to have an upgrade and will be down during"));
		
		
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}


