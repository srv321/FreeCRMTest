package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: Saurav Saha')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	// Initializing the Page Objects: using initElements method in PageFactory class
	public HomePage() {

		PageFactory.initElements(driver, this); // this means pointing to all current class
												// objcts-loginpage.username,etc

	}

	// Actions:
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();// this returns ContactsPage Object
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();// this returns ContactsPage Object
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();// this returns ContactsPage Object
		return new TasksPage();
	}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	
	
	

}
