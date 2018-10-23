package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException,IOException,NullPointerException {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		Thread.sleep(2000);
		contactsPage = homePage.clickOnContactsLink();
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacs label is missing on the page");
	}

	@Test(priority = 2)
	public void selectSingleContactsTest() {
		contactsPage.selectContacsByName("George Bailey");

	}
	
	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		contactsPage.selectContacsByName("George Bailey");
		contactsPage.selectContacsByName("test tester");
	}
	
	
	@DataProvider
	public  Object[][] getCRMTestData() {
		Object data [][]= TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 4,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String firstName,String lastName,String company) {
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.","Tom","Peter","Google");
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
