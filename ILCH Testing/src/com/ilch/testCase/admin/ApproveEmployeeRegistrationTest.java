package com.ilch.testCase.admin;

import com.ilch.Constants;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

import junit.framework.Assert;
import static org.apache.commons.lang3.StringUtils.join;

public class ApproveEmployeeRegistrationTest {
	private Selenium selenium;
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		selenium = new WebDriverBackedSelenium(driver, Constants.BASE_URL);
	}

	@Test
	public void testApproveEmployeeRegistration() throws Exception {
		selenium.open(Constants.APP_URL);
		selenium.waitForPageToLoad("30000");
		selenium.type("name=userName", "");
		selenium.type("name=password", "");
		selenium.type("name=userName", Constants.EMPLOYER_LOGIN);
		selenium.type("name=password", Constants.EMPLOYER_PASSWORD);
		selenium.click("name=lsubmit");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Admin Page");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Pending Approvals");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Employee Registration Pending Approvals");
		selenium.waitForPageToLoad("30000");
		selenium.click("name=approve");
				
		Assert.assertTrue(new WebDriverWait(driver,10).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {   
	        	System.out.println("Looking for text APPROVED");
	        	return selenium.isTextPresent("APPROVED");
	        }
	    }));
	}

	@After
	public void tearDown() throws Exception {
		//selenium.stop();
	}
}
