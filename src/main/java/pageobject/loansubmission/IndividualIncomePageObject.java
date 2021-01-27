package pageobject.loansubmission;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndividualIncomePageObject extends BasePageObject {

	public IndividualIncomePageObject(WebDriver driver) {	
		super(driver);
	}

	//Define the element of Individual annual income
	public WebElement individualAnnualIncomeElement() {		
		return waitUtilElementClickable(By.cssSelector("input[data-auto=\"borrowerIncome\"]"));
	}	

	//Define the element of Additional annual income
	public WebElement additionalAnnualIncomeElement() {		
		return waitUtilElementClickable(By.cssSelector("input[data-auto=\"borrowerAdditionalIncome\"]"));
	}	
	
	//Define the element of Borrower DOB
	public WebElement continueButtonElement() {		
		return waitUtilElementClickable(By.cssSelector("button[data-auto=\"continuePersonalInfo\"]"));
	}

	//Enter Individual annual income
	public void enterIndividualAnnualIncome(String individualAnnualIncome){
		individualAnnualIncomeElement().sendKeys(individualAnnualIncome);
	}

	//Enter Additional annual income
	public void enterAdditionalAnnualIncome(String additionalAnnualIncome){
		additionalAnnualIncomeElement().sendKeys(additionalAnnualIncome);
	}
	
	//Click on Continue
	public CreateAccountPageObject clickOnContinue(){
		continueButtonElement().click();
		continueButtonElement().click();
		return new CreateAccountPageObject(driver);
	}
}
