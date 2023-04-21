package com.selenium.pages;

import java.time.Duration;
import java.util.Set;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MRSPage {

	WebDriver ldriver;
	WebDriverWait lwait;
	static Logger logger = LogManager.getLogger(MRSPage.class.getName());

	public MRSPage(WebDriver rdriver, WebDriverWait rwait) {
		ldriver = rdriver;
		lwait = rwait;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "username")
	WebElement usernameBox;

	@FindBy(name = "password")
	WebElement passwordBox;

	@FindBy(id = "Laboratory")
	WebElement locationBox;

	@FindBy(id = "loginButton")
	WebElement loginButton;

	@FindBy(xpath = "//*[@class='col-12 col-sm-12 col-md-12 col-lg-12']/h4")
	WebElement dashboardPage;

	@FindBy(xpath = "//*[@class='icon-user']")
	WebElement registerPatIcon;

	@FindBy(name = "givenName")
	WebElement givenNameBox;

	/*
	 * @FindBy(name = "middleName") WebElement middleNameBox;
	 */

	@FindBy(name = "familyName")
	WebElement familyNameBox;

	@FindBy(xpath = "//*[@id='gender-field']//*[text()='Male']")
	WebElement genderBox;

	@FindBy(name = "birthdateDay")
	WebElement birthdateDayBox;

	@FindBy(name = "birthdateMonth")
	WebElement birthdateMonthBox;

	@FindBy(name = "birthdateYear")
	WebElement birthdateYearBox;

	@FindBy(id = "address1")
	WebElement patAddress1Box;

	@FindBy(id = "address2")
	WebElement patAddress2Box;

	@FindBy(id = "cityVillage")
	WebElement patCityBox;

	@FindBy(id = "stateProvince")
	WebElement patStateBox;

	@FindBy(id = "country")
	WebElement patCountryBox;

	@FindBy(id = "postalCode")
	WebElement patPostalCodeBox;

	@FindBy(name = "phoneNumber")
	WebElement patPhonenumberBox;

	@FindBy(id = "next-button")
	WebElement nextButton;

	@FindBy(id = "submit")
	WebElement conformButton;

	@FindBy(xpath = "//*[@class='float-left']//h3[1]")
	WebElement patientDetailscheck;

	@FindBy(xpath = "//*[@class='col-12 col-lg-3 p-0']/div/ul/li[1]/a/div/div[2]")
	WebElement startVisitmenu;

	@FindBy(id = "start-visit-with-visittype-confirm")
	WebElement windowButton;

	@FindBy(xpath = "//*[@class='visit-actions active-visit']/a[5]")
	WebElement attachmentLink;

	@FindBy(xpath = "//*[@class='att_file-upload-container']/div/div[1]/form")
	WebElement uploadFile;

	@FindBy(xpath = "//*[@class='att_file-upload-container']/div/div[2]/textarea")
	WebElement uploadComment;

	@FindBy(xpath = "//*[@class='confirm ng-binding']")
	WebElement uploadButton;

	@FindBy(xpath = "//*[@class='PersonName-familyName']")
	WebElement familyNameClick;

	@FindBy(xpath = "//*[@class='att_thumbnails-container']")
	WebElement imageName;

	@FindBy(xpath = "//*[@class='float-left d-none d-lg-block']/li[1]")
	WebElement endVisit;

	@FindBy(xpath = "//*[@id='end-visit-dialog']/div[2]/button[1]")
	WebElement yesButton;

	@FindBy(xpath = "//*[@class='col-12 col-lg-3 p-0']/div/ul/li[8]/a/div/div[2]")
	WebElement deletePatientmenu;

	@FindBy(id = "delete-reason")
	WebElement deleteReason;

	@FindBy(xpath = "//*[@class='dialog simplemodal-data']/div[2]//*[@class='confirm right']")
	WebElement confirmDelete;

	@FindBy(id = "patient-search")
	WebElement searchPatient;

	@FindBy(xpath = "//*[@class='dataTables_empty']")
	WebElement conformDelete;

	public void setUsername(String username) {
		logger.info("**entering the username");
		lwait.until(ExpectedConditions.visibilityOf(usernameBox)).sendKeys(username);
	}

	public void setPassword(String password) {
		logger.info("**entering the password");
		lwait.until(ExpectedConditions.visibilityOf(passwordBox)).sendKeys(password);
	}

	public void ClickLocation() {
		logger.info("**Selecting the location");
		lwait.until(ExpectedConditions.visibilityOf(locationBox)).click();
	}

	public void clickLoginButton() {
		logger.info("**Clicking the login button");
		loginButton.click();
		// lwait.until(ExpectedConditions.visibilityOf(loginButton));
	}

	public void clickRegisterPatButton() {
		logger.info("**Clicking the Register a Patient Icon");
		registerPatIcon.click();
		// lwait.until(ExpectedConditions.visibilityOf(registerPatIcon));
	}

	public void setGivenName() {
		logger.info("**entering the givenname");
		lwait.until(ExpectedConditions.visibilityOf(givenNameBox)).sendKeys("uattest");
	}

	/*
	 * public void setMiddleName() { logger.info("**entering the middlename");
	 * lwait.until(ExpectedConditions.visibilityOf(middleNameBox)).sendKeys("devi");
	 * }
	 */

	public void setFamilyName() {
		logger.info("**entering the familyname");
		lwait.until(ExpectedConditions.visibilityOf(familyNameBox)).sendKeys("uattest");
		clickNextbutton();
	}

	public void selectGender() {
		logger.info("**selecting the gender as Male");
		lwait.until(ExpectedConditions.visibilityOf(genderBox)).click();
		clickNextbutton();
	}

	public void setBirthDateDay() {
		logger.info("**entering the birthdateday");
		lwait.until(ExpectedConditions.visibilityOf(birthdateDayBox)).sendKeys("10");
	}

	public void setBirthDateMonth() {
		logger.info("**entering the birthdatemonth");
		lwait.until(ExpectedConditions.visibilityOf(birthdateMonthBox));
		Select dp = new Select(birthdateMonthBox);
		dp.selectByVisibleText("February");
	}

	public void setBirthDateYear() {
		logger.info("**entering the birthdateyear");
		lwait.until(ExpectedConditions.visibilityOf(birthdateYearBox)).sendKeys("2000");
		clickNextbutton();
	}

	public void setpatAddress1() {
		logger.info("**entering the address1");
		lwait.until(ExpectedConditions.visibilityOf(patAddress1Box)).click();
		// JavascriptExecutor jse = (JavascriptExecutor)ldriver;
		// jse.executeScript("arguments[0].value='Test';", patAddress1Box);
		patAddress1Box.sendKeys("Test");
	}

	public void setpatAddress2() {
		logger.info("**entering the address2");
		lwait.until(ExpectedConditions.visibilityOf(patAddress2Box)).sendKeys("Main Street");
	}

	public void setpatCity() {
		logger.info("**entering the city");
		lwait.until(ExpectedConditions.visibilityOf(patCityBox)).sendKeys("Newyork");
	}

	public void setpatState() {
		logger.info("**entering the state");
		lwait.until(ExpectedConditions.visibilityOf(patStateBox)).sendKeys("NY");
	}

	public void setpatCountry() {
		logger.info("**entering the country");
		lwait.until(ExpectedConditions.visibilityOf(patCountryBox)).sendKeys("USA");
	}

	public void setpatPostalCode() {
		logger.info("**entering the postalcode");
		lwait.until(ExpectedConditions.visibilityOf(patPostalCodeBox)).sendKeys("10022");
		clickNextbutton();
	}

	public void setpatPhonenumber() {
		logger.info("**entering the phonenumber");
		lwait.until(ExpectedConditions.visibilityOf(patPhonenumberBox)).sendKeys("8877665544");
		clickNextbutton();

	}

	public void clickNextbutton() {

		logger.info("**clicking next button");
		nextButton.click();
		

	}

	public void clickConformbutton() {

		conformButton.click();
		logger.info("**selecting conform button");
	}

	public void clickStartvisit() {

		startVisitmenu.click();
		logger.info("**clicking start visit");

		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		windowButton.click();

	}

	public void clickEndvisit() {
		logger.info("**clicking end visit");
	
		lwait.until(ExpectedConditions.visibilityOf(endVisit)).click();
		lwait.until(ExpectedConditions.visibilityOf(yesButton)).click();
		lwait.until(ExpectedConditions.visibilityOf(deletePatientmenu)).click();
		lwait.until(ExpectedConditions.visibilityOf(deleteReason)).sendKeys("Duplicate Patient");
		lwait.until(ExpectedConditions.visibilityOf(confirmDelete)).click();
		lwait.until(ExpectedConditions.visibilityOf(searchPatient)).sendKeys("uattest uattest");

		

	}

	public boolean clickAttachment() {
		boolean isAttachedimage = true;
		attachmentLink.click();
		// lwait.until(ExpectedConditions.visibilityOf(uploadFile)).sendKeys("src//test//resources//Defect_15.png");
		// uploadFile.sendKeys("src//test//resources//Defect_15.png");
		lwait.until(ExpectedConditions.visibilityOf(uploadComment)).sendKeys("Test");

		lwait.until(ExpectedConditions.visibilityOf(uploadButton)).click();
		lwait.until(ExpectedConditions.visibilityOf(familyNameClick)).click();

		isAttachedimage = imageName.getText().isEmpty();
		return isAttachedimage;
	}

	public boolean checkDashboardpage() {
		boolean isLoginSuccess = false;
		String Dashboard_message = "Logged in as Super User (admin) at Laboratory.";
		isLoginSuccess = dashboardPage.getText().equals(Dashboard_message);
		return isLoginSuccess;
	}

	public boolean verifyPatientdetailspage() {
		String Expectedmessage = "General Actions";
		boolean isPatientdirectpageSuccess = false;
		lwait.until(ExpectedConditions.visibilityOf(patientDetailscheck));
		isPatientdirectpageSuccess = patientDetailscheck.getText().equals(Expectedmessage);
		return isPatientdirectpageSuccess;
	}

}
