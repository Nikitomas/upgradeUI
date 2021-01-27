package pageobject.loansubmission;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

	protected WebDriver driver;
	static final int TIME_OUT= 40;
	
	public BasePageObject(WebDriver driver) {	
		this.driver= driver;
	}
	
	//Define the element of loan amount on the offer page
	public WebElement loanAmountOfferPageElement() {		
		return waitUtilElementPresent(By.cssSelector("span[data-auto=\"userLoanAmount\"]"));
	}
	
	//Define the element of monthly payment on the offer page
	public WebElement monthlyPaymentElement() {		
		return waitUtilElementPresent(By.cssSelector("span[data-auto=\"defaultMonthlyPayment\"]"));
	}

	//Define the element of the term on the offer page
	public WebElement termElement() {		
		return waitUtilElementPresent(By.cssSelector("div[data-auto=\"defaultLoanTerm\"]"));
	}

	//Define the element of the interest on the offer page
	public WebElement interestElement() {		
		return waitUtilElementPresent(By.cssSelector("div[data-auto=\"defaultLoanInterestRate\"]"));
	}

	//Define the element of the APPR on the offer page
	public WebElement aprElement() {		
		return waitUtilElementPresent(By.cssSelector("div[data-auto=\"defaultMoreInfoAPR\"]"));
	}
	
	//Get the value of Loan amount from the offer page
	public String getLoanAmount() {
		return loanAmountOfferPageElement().getText();
	}

	//Get the value of Loan amount from the offer page
	public String getMonthlyPayment() {
		return monthlyPaymentElement().getText();
	}

	//Get the value of Loan amount from the offer page
	public String getTerm() {
		return termElement().getText();
	}

	//Get the value of Loan amount from the offer page
	public String getInterest() {
		return interestElement().getText();
	}

	//Get the value of Loan amount from the offer page
	public String getAPR() {
		return aprElement().getText();
	}
	
	
	protected WebElement waitUtilElementClickable(By by) {		
		return (new WebDriverWait(this.driver, TIME_OUT)).until(ExpectedConditions.elementToBeClickable(by));
	}

	protected WebElement waitUtilElementPresent(By by) {		
		return (new WebDriverWait(this.driver, TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(by));
	}

}
