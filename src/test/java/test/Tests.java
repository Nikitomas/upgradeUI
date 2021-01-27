package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageobject.loansubmission.CreateAccountPageObject;
import pageobject.loansubmission.IndividualIncomePageObject;
import pageobject.loansubmission.IndividualInfoPageObject;
import pageobject.loansubmission.LandingPageObject;
import pageobject.loansubmission.OfferPageObject;
import pageobject.portal.LoginPageObject;
import pageobject.portal.YourLoanPageObject;


public class Tests extends BaseTest{

	IndividualInfoPageObject individualInfoPage; 
	IndividualIncomePageObject individualIncomePage;
	CreateAccountPageObject createAccountPage;
	OfferPageObject offerPage;
	LoginPageObject loginPage;
	YourLoanPageObject yourLoanPageObject;

	String expectedLoanAmount, expectedMonthlyPayment, expectedTerm, interest, expectedAPR;
	String actualLoanAmount, actualMonthlyPayment, actualTerm, interestPortal, actualAPR;


	@Test (groups = {"Regression"})
	public void openBrowser() {
		int randomNbr = (int)(Math.random()*9000)+1000;
		String email = "ntouma"+ randomNbr+"@upgrade-challenge.com";
		String password = "1Abcdefg";
		String expectedOfferPageURL = "https://www.credify.tech/funnel/offer-page";

		LandingPageObject landingPageObject = new LandingPageObject(this.driver);

		//Entering the amount
		landingPageObject.enterLoanAmount("2000");

		//Clicking on Loan Purpose
		landingPageObject.clickOnLoanPurpose();

		//Choosing Credit Card as Loan Purpose
		landingPageObject.chooseCreditCardAsLoanPurpose();

		//Clicking on Check your Rate button
		individualInfoPage = landingPageObject.clickOnCheckYourRateButton();

		/*
		 * 
		 * 
		 * */

		//Enter First Name
		individualInfoPage.enterFirstName("Nicolas");
		//Enter Last Name
		individualInfoPage.enterLastName("Touma");
		//Enter the Borrower street
		individualInfoPage.enterBorrowerStreet("275 Battery Street");//275 Battery Street, 23rd Floor	San Francisco, CA 94111, USA
		//Hit Enter then escape to use the auto-complete and fill out the rest of the address info
		individualInfoPage.hitEnter();
		individualInfoPage.hitEscape();
		//Enter the Borrower's date of birth
		individualInfoPage.enterBorrowerDOB("11/11/1985");
		//Hit Continue and move to the Individual Income page
		individualIncomePage = individualInfoPage.clickOnContinue();

		/*
		 * 
		 * 
		 * */

		//Enter annual income
		individualIncomePage.enterIndividualAnnualIncome("122000");
		//Enter additional income
		individualIncomePage.enterAdditionalAnnualIncome("6000");
		//Click on Continue
		createAccountPage = individualIncomePage.clickOnContinue();

		/*
		 * 
		 * 
		 * */

		//Entering email
		createAccountPage.enterEmail(email);
		//Entering password
		createAccountPage.enterPassword(password);
		createAccountPage.checkTheCheckbox();
		offerPage= createAccountPage.clickOnCheckYourRate();

		/*
		 * 
		 * 
		 * */

		expectedLoanAmount= offerPage.getLoanAmount();
		expectedMonthlyPayment = offerPage.getMonthlyPayment();
		expectedTerm = offerPage.getTerm();
		interest = offerPage.getInterest();
		expectedAPR = offerPage.getAPR();
		
		/*
		 * 
		 * 
		 * */

		loginPage = offerPage.openLoginWebsite();
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		yourLoanPageObject = loginPage.login();
		
		/*
		 * 
		 * 
		 * */
		actualLoanAmount = yourLoanPageObject.getLoanAmount();
		actualAPR = yourLoanPageObject.getAPR();
		actualTerm = yourLoanPageObject.getTerm();
		actualMonthlyPayment = yourLoanPageObject.getMonthlyPayment();
		
		Assert.assertEquals(yourLoanPageObject.getCurrentURL(),expectedOfferPageURL,"The URL is in fact offer-page");
		Assert.assertEquals(actualAPR,expectedAPR);
		Assert.assertEquals(actualLoanAmount,expectedLoanAmount);
		Assert.assertEquals(actualTerm,expectedTerm);
		Assert.assertEquals(actualMonthlyPayment,expectedMonthlyPayment);


		driver.close();
	}
}