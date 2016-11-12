package datadriventesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;

public class LandingPage {
	WebDriver driver;
	Workbook workbook;
	FileInputStream inputStream;
	By loginURL = By.className("ph-link-gold");
	String registrationURL = "https://www.pizzahut.com/#/registration";
	By loginemailinput = By.id("email_signIn");
	By loginpasswordinput = By.id("password_signIn");
	By loginbtn = By.cssSelector("button[class='center-block btn btn-primary sign-in']");
	By loginsuccess = By
			.cssSelector("span[class='hidden-xs ph-nav-link inline-top header-margin-right header_welcome']");
	// Elements for signup page
	By signupfirstNameinput = By.cssSelector("input[name='firstName']");
	By signuplastNameinput = By.cssSelector("input[name='lastName']");
	By signupphoneNumberinput = By.cssSelector("input[name='phoneNumber']");
	By signupextinput = By.cssSelector("input[name='ext']");
	By signupeMailAddressinput = By.cssSelector("input[name='eMailAddress']");
	By signupconfirmEmailinput = By.cssSelector("input[name='confirmEmail']");
	By signuppasswordinput = By.cssSelector("input[type='password']");
	By signupconfirmPasswordinput = By.cssSelector("input[name='confirmPassword']");
	By signupnoThanksinput = By.cssSelector("input[name='noThanks']");
	By signuptermsinput = By.cssSelector("input[name='terms']");
	By signupcertifyinput = By.cssSelector("input[name='certify']");
	By createUserbtn = By.cssSelector("button[class='btn btn-primary']");
	By accepterror = By.cssSelector("a[class='btn btn-primary btn-block ng-binding']");
	By errormessage = By.cssSelector("p[class='text-center ng-binding']");

	public Sheet loadExcelSheet(String sheetname) throws IOException {
		String excelFilePath = "C://Users//Sagar//Desktop//TestData.xlsx";
		inputStream = new FileInputStream(new File(excelFilePath));
		workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheet(sheetname);
		System.out.println("FS " + firstSheet.getSheetName());
		return firstSheet;
	}

	public void closeWorkBook() throws IOException {
		workbook.close();
	}

	public void closeFile() throws IOException {
		inputStream.close();
	}

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickloginurl() {
		driver.findElement(loginURL).click();
	}

	public void clickRegistrationurl() {
		driver.get(registrationURL);
	}

	public String getErrorMessage() {
		return driver.findElement(errormessage).getText();
	}

	public void close(WebDriver driver) {
		driver.close();
	}
}