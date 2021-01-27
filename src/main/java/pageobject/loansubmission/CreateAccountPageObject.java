package pageobject.loansubmission;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPageObject extends BasePageObject{

	public CreateAccountPageObject(WebDriver driver) {	
		super(driver);
	}

	//Define the element of email
	public WebElement emailElement() {		
		return waitUtilElementPresent(By.cssSelector("input[name=\"username\"]"));
	}	

	//Define the element of password
	public WebElement passwordElement() {		
		return waitUtilElementPresent(By.cssSelector("input[name=\"password\"]"));
	}
	
	//Define the element of checkBox
	public WebElement checkBoxElement() {		
		return waitUtilElementClickable(By.cssSelector("input[name=\"agreements\"]~div"));
	}

	//Define the element of the submit button
	public WebElement submitInfoElement() {		
		return waitUtilElementClickable(By.cssSelector("button[data-auto=\"submitPersonalInfo\"]"));
	}

	//Enter email
	public void enterEmail(String email){
		emailElement().sendKeys(email);
	}

	//Enter password
	public void enterPassword(String password){
		passwordElement().sendKeys(password);
	}
	
	//Check the checkbox
	public void checkTheCheckbox(){
		checkBoxElement().click();
	}
	
	//Click on check your rate
	public OfferPageObject clickOnCheckYourRate(){
		submitInfoElement().click();
		return new OfferPageObject(driver);
	}


}
