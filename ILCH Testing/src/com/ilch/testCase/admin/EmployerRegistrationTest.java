package com.ilch.testCase.admin;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ilch.Constants;
import com.thoughtworks.selenium.Selenium;

public class EmployerRegistrationTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		
		selenium = new WebDriverBackedSelenium(driver, Constants.BASE_URL);
	}

	@Test
	public void testAdminRegistration() throws Exception {
		selenium.open(Constants.APP_URL);
		selenium.click("//div[@id='loginTabs']/ul/li[3]");
		selenium.click("name=businessName");
		selenium.type("name=businessName", "AlliBilli");
		selenium.type("document.adminRegistrationBean.elements['listAddress[0].address1']", "7575 Frankford Rd");
		selenium.type("document.adminRegistrationBean.elements['listAddress[0].address2']", "APT 1114");
		selenium.type("document.adminRegistrationBean.elements['listAddress[0].city']", "Dallas");
		selenium.type("document.adminRegistrationBean.elements['listAddress[0].state']", "TX");
		selenium.type("document.adminRegistrationBean.elements['listAddress[0].country']", "USA");
		selenium.type("document.adminRegistrationBean.elements['listAddress[0].zip']", "75252");
		selenium.type("name=logo", "C:\\Users\\GeetaKrishna\\Desktop\\coloredallibilli.jpg");
		selenium.type("document.adminRegistrationBean.phoneNumber", "1231231233");
		selenium.type("document.adminRegistrationBean.contactEmail", Constants.EMPLOYER_EMAIL);
		selenium.click("css=p > input[name=\"create\"]");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=firstName", "Gopi");
		selenium.type("name=middleName", "Krishna");
		selenium.type("name=lastName", "K");
		selenium.type("id=dob", "02-26-2013");
		selenium.type("name=countryCitizenship", "USA");
		selenium.type("name=listAddress[1].address1", "7575 Frankford Rd");
		selenium.type("name=listAddress[1].address2", "ghghj");
		selenium.type("name=listAddress[1].city", "Dallas");
		selenium.type("name=listAddress[1].state", "TX");
		selenium.type("name=listAddress[1].country", "USA");
		selenium.type("name=listAddress[1].zip", "75252");
		selenium.type("name=login", Constants.EMPLOYER_LOGIN);
		selenium.type("name=password", Constants.EMPLOYER_PASSWORD);
		selenium.type("name=confirmPassword", Constants.EMPLOYER_PASSWORD);
		selenium.click("name=Next");
		selenium.waitForPageToLoad("30000");
		selenium.click("name=confirm");
		selenium.waitForPageToLoad("30000");
		Assert.assertTrue(selenium.isTextPresent("A Confirmation Email was sent for your business Email with a link."));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
