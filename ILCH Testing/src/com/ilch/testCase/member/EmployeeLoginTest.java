package com.ilch.testCase.member;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ilch.Constants;
import com.thoughtworks.selenium.Selenium;

public class EmployeeLoginTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		selenium = new WebDriverBackedSelenium(driver, Constants.BASE_URL);
	}

	@Test
	public void testAdminLogin() throws Exception {
		selenium.open(Constants.APP_URL);
		selenium.type("name=userName", "");
		selenium.type("name=password", "");
		selenium.type("name=userName", Constants.EMPLOYEE_LOGIN);
		selenium.type("name=password", Constants.EMPLOYEE_PASSWORD);
		selenium.click("name=lsubmit");
		selenium.waitForPageToLoad("30000");
		Assert.assertTrue(selenium.isTextPresent("Member Page"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
