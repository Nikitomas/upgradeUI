package pageobject.loansubmission;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndividualInfoPageObject extends BasePageObject{

	public IndividualInfoPageObject(WebDriver driver) {	
		super(driver);
	}

	//Define the element of First Name
	public WebElement firstNameElement() {		
		return waitUtilElementPresent(By.cssSelector("input[data-auto=\"borrowerFirstName\"]"));
	}

	//Define the element of Last Name
	public WebElement lastNameElement() {		
		return waitUtilElementPresent(By.cssSelector("input[data-auto=\"borrowerLastName\"]"));
	}

	//Define the element of Borrower Street
	public WebElement borrowerStreetElement() {		
		return waitUtilElementClickable(By.cssSelector("input[data-auto=\"borrowerStreet\"]"));
	}	

	//Define the element of Borrower DOB
	public WebElement borrowerDateOfBirthElement() {		
		return waitUtilElementClickable(By.cssSelector("input[data-auto=\"borrowerDateOfBirth\"]"));
	}

	//Define the element of Borrower DOB
	public WebElement continueButtonElement() {		
		return waitUtilElementPresent(By.cssSelector("button[data-auto=\"continuePersonalInfo\"]"));
	}

	//Enter a first name
	public void enterFirstName(String firstName){
		firstNameElement().sendKeys(firstName);
	}

	//Enter a last name
	public void enterLastName(String lastName){
		lastNameElement().sendKeys(lastName);
	}

	//Enter an street in the street box
	public void enterBorrowerStreet(String borrowerStreet){
		borrowerStreetElement().sendKeys(borrowerStreet);
	}

	//Type Enter to use auto-complete 
	public void hitEnter(){
		borrowerStreetElement().sendKeys(Keys.RETURN);
	}

	//Type Enter to use auto-complete 
	public void hitEscape(){
		borrowerStreetElement().sendKeys(Keys.ESCAPE);
	}

	//Enter the borrower's DOB
	public void enterBorrowerDOB(String BorrowerDOB){
		borrowerDateOfBirthElement().sendKeys(BorrowerDOB);
	}

	//Click on Continue
	public IndividualIncomePageObject clickOnContinue(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		continueButtonElement().click();
		return new IndividualIncomePageObject(driver);
	}
}