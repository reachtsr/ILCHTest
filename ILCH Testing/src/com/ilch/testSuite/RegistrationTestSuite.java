package com.ilch.testSuite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ilch.testCase.admin.EmployerRegistrationTest;
import com.ilch.testCase.member.EmployeeRegistrationTest;

@RunWith(Suite.class)
@SuiteClasses({ EmployerRegistrationTest.class, EmployeeRegistrationTest.class })
public class RegistrationTestSuite {

	@BeforeClass
	public static void setUpClass() {
		System.out.println("Started Initilializing...");
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("Execution Completed...");
	}
}
