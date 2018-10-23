package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contacsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	////form[@id='vContactsForm']//a[contains(text(),'George Bailey')]/../preceding-sibling::*//input[@type='checkbox']

	// Initializing the Page Objects: using initElements method in PageFactory class
	public ContactsPage() {
		PageFactory.initElements(driver, this);

	}

	public boolean verifyContactsLabel() {
		return contacsLabel.isDisplayed();
	}

	public void selectContacsByName(String name) {
		driver.findElement(By.xpath(
				"//form[@id='vContactsForm']//a[contains(text(),'"+name+"')]/../preceding-sibling::*//input[@type='checkbox']"))
				.click();
	}
	
	public void createNewContact(String title,String ftname,String ltname,String comp) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftname);
		lastName.sendKeys(ltname);
		company.sendKeys(comp);
		saveBtn.click();
		
	}

}
