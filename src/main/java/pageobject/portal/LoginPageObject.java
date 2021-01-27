package pageobject.portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobject.loansubmission.BasePageObject;

public class LoginPageObject extends BasePageObject{

	public LoginPageObject(WebDriver driver) {
		super(driver);
	}

	//Define the element of username
	public WebElement usernameElement() {		
		return waitUtilElementPresent(By.cssSelector("input[data-auto=\"username\"]"));
	}

	//Define the element of password
	public WebElement passwordElement() {		
		return waitUtilElementPresent(By.cssSelector("input[data-auto=\"password\"]"));
	}

	//Define the element of Sign in button
	public WebElement signInButtonElement() {		
		return waitUtilElementClickable(By.cssSelector("button[data-auto=\"login\"]"));
	}

	//Enter a username
	public void enterEmail(String email){
		usernameElement().sendKeys(email);
	}

	//Enter a password
	public void enterPassword(String password){
		passwordElement().sendKeys(password);
	}

	//Click on login
	public YourLoanPageObject login(){
		signInButtonElement().click();
		return new YourLoanPageObject(driver);	 
	}
	


}
