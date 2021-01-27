package pageobject.loansubmission;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPageObject extends BasePageObject{

	public LandingPageObject(WebDriver driver) {	
		super(driver);
	}

	//Define the element of the amount box
	public WebElement loanAmountElement() {		
		return waitUtilElementPresent(By.cssSelector("input[name=\"desiredAmount\"]"));
	}

	//Define the element of the amount box
	public WebElement dropLoanPurposeElement() {
		return waitUtilElementClickable(By.cssSelector("select[data-auto=\"dropLoanPurpose\"]"));
	}	

	//Define the element inside the drop list of loan purpose
	public WebElement loanPurposeCreditCardElement() {
		return waitUtilElementClickable(By.cssSelector("option[value=\"CREDIT_CARD\"]"));
	}	

	//Define the element of Check your Rate button
	public WebElement checkYourRateButtonElement() {
		return waitUtilElementClickable(By.cssSelector("button[data-auto=\"CheckYourRate\"]"));
	}	

	//Enter an amount in the amount box
	public void enterLoanAmount(String amount){
		loanAmountElement().sendKeys(amount);
	}

	//Clicks on the loan purpose list 
	public void clickOnLoanPurpose(){
		dropLoanPurposeElement().click();
	}

	//Choose Credit card as Loan purpose
	public void chooseCreditCardAsLoanPurpose(){
		loanPurposeCreditCardElement().click();
	}

	//Choose Credit card as Loan purpose
	public IndividualInfoPageObject clickOnCheckYourRateButton(){
		checkYourRateButtonElement().click();
		return new IndividualInfoPageObject(driver);
	}

}
