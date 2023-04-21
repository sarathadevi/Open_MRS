package com.selenium.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.selenium.pages.BasePage;
import com.selenium.pages.MRSPage;

public class TC_001_SystemTest extends BaseClass {

	BasePage basepage;
	MRSPage mrspage;
	SoftAssert softassert;

	@Test(priority = 0)
	public void m_login() {

		basepage = new BasePage(driver, wait);
		mrspage = new MRSPage(driver, wait);
		basepage.launchApplication();
		mrspage.setUsername(username);
		mrspage.setPassword(password);
		mrspage.ClickLocation();
		mrspage.clickLoginButton();
		Assert.assertEquals(mrspage.checkDashboardpage(), true);

	}

	@Test(priority = 1)
	public void m_RegisterPatient() {

		softassert=new SoftAssert();
		 
		mrspage.clickRegisterPatButton();
		mrspage.setGivenName();
		// mrspage.setMiddleName();
		mrspage.setFamilyName();
		mrspage.selectGender();
		mrspage.setBirthDateDay();
		mrspage.setBirthDateMonth();
		mrspage.setBirthDateYear();
		mrspage.setpatAddress1();
		mrspage.setpatAddress2();
		mrspage.setpatCity();
		mrspage.setpatState();
		mrspage.setpatCountry();
		mrspage.setpatPostalCode();
		mrspage.setpatPhonenumber();
		mrspage.clickNextbutton();
		String givenname = "Test"; String familyname = "Calab"; 
		String address1 = "Test";  String address2 = "Main Street"; String city = "Newyork";  String state = "NY";  String
		  country = "USA";  int postalcode = 10022;
		 int day = 10;  String month = "February";  int year = 2000;
		  
		
		String[] actualname=driver.findElement(By.xpath("//*[@ID='dataCanvas']/div/p[1]")).getText().split("Name: ");
		String[] actualgender = driver.findElement(By.xpath("//*[@ID='dataCanvas']/div/p[2]")).getText().split("Gender: ");
		String[] actualaddress  =driver.findElement(By.xpath("//*[@ID='dataCanvas']/div/p[4]")).getText().split("Address: ");
		String[] actualnamebirthdate = driver.findElement(By.xpath("//*[@ID='dataCanvas']/div/p[3]")).getText().split("Birthdate: ");
		String[] actualphone  = driver.findElement(By.xpath("//*[@ID='dataCanvas']/div/p[5]")).getText().split("Phone Number: ");
		
		String expectednamegender = "Male";
		String expectedname=givenname+","+familyname;  
		String expectednameaddress = address1+","+address2+","+city+","+state+","+country+","+postalcode; 
		String expectednamebirthdate = day+","+month+","+year; 
		int expectednamephonenumber = 12345678;
		
		softassert.assertEquals(actualgender, expectednamegender);
		softassert.assertEquals(actualname, expectedname);
		softassert.assertEquals(actualaddress, expectednameaddress);
		softassert.assertEquals(actualnamebirthdate, expectednamebirthdate);
		softassert.assertEquals(actualphone, expectednamephonenumber);
		softassert.assertAll();
		
	}

	@Test(priority = 2)
	public void m_CheckPatientDetailpage() {

		mrspage.clickConformbutton();
		Assert.assertEquals(mrspage.verifyPatientdetailspage(), true);

	}

	@Test(priority = 3)
	public void m_Visit() {

		mrspage.clickStartvisit();

	}

	@Test(priority = 4)
	public void m_VerifyAttachment() {

		Assert.assertEquals(mrspage.clickAttachment(), true);

	}

	@Test(priority = 5)
	public void m_EndVisit() {

		mrspage.clickEndvisit();
	}

}
