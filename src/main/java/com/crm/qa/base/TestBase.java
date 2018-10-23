package com.crm.qa.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Saurav Saha\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();

		} 

		driver.manage().window().maximize();// maximize window
		driver.manage().deleteAllCookies();// delete all cookies
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		

	}

}
