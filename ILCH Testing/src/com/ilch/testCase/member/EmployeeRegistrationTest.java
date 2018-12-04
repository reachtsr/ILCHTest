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

public class EmployeeRegistrationTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		selenium = new WebDriverBackedSelenium(driver, Constants.BASE_URL);
	}

	@Test
	public void testMemberRegistration() throws Exception {
		selenium.open(Constants.APP_URL);
		selenium.click("//div[@id='loginTabs']/ul/li[2]");
		selenium.click("name=firstName");
		selenium.type("name=firstName", "gopi");
		selenium.type("name=middleName", "gopi");
		selenium.type("name=lastName", "K");
		selenium.type("name=contactEmail", Constants.EMPLOYEE_EMAIL);
		selenium.type("name=phoneNumber", "1231231233");
		selenium.type("name=fatherName", "hj");
		selenium.type("name=countryCitizenship", "USA");
		selenium.select("name=timeSheetConfiguredTo", "label=DAYS15");
		selenium.type("id=dob", "02-26-2013");
		selenium.type("name=listAddress[0].address1", "7575 Frankford Rd");
		selenium.type("name=listAddress[0].address2", "hhjhjhj");
		selenium.type("name=listAddress[0].city", "Dallas");
		selenium.type("name=listAddress[0].state", "TX");
		selenium.type("name=listAddress[0].country", "USA");
		selenium.type("name=listAddress[0].zip", "75252");
		selenium.type("name=listAddress[1].address1", "7575 Frankford Rd");
		selenium.type("name=listAddress[1].address2", "ghghj");
		selenium.type("name=listAddress[1].city", "Dallas");
		selenium.type("name=listAddress[1].state", "TX");
		selenium.type("name=listAddress[1].country", "USA");
		selenium.type("name=listAddress[1].zip", "75252");
		selenium.click("name=create");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=businessId", "3");
		selenium.type("name=clientName", "Adesa");
		selenium.type("name=listAddress[2].address2", "ghjghjg");
		selenium.type("name=listAddress[2].city", "ghgh");
		selenium.type("name=listAddress[2].state", "TR");
		selenium.type("name=listAddress[2].country", "USA");
		selenium.type("name=listAddress[2].zip", "78788");
		selenium.type("id=start_date", "06/14/2013");
		selenium.type("name=login", Constants.EMPLOYEE_LOGIN);
		selenium.type("name=password", Constants.EMPLOYEE_PASSWORD);
		selenium.type("name=confirmPassword", Constants.EMPLOYEE_PASSWORD);
		selenium.click("name=Next");
		selenium.waitForPageToLoad("30000");
		selenium.click("name=confirm");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=listAddress[2].address1", "123123");
		selenium.click("name=confirm");
		selenium.waitForPageToLoad("30000");
		selenium.waitForPageToLoad("30000");
		
		Assert.assertTrue(selenium.isTextPresent("A Confirmation Email was sent for your email Email with a link"));
		
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
