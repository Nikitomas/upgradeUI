package pageobject.portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobject.loansubmission.BasePageObject;

public class YourLoanPageObject  extends BasePageObject{

	public YourLoanPageObject(WebDriver driver) {
		super(driver);
	}

	//Get the current URL
	public String getCurrentURL() {
		waitUtilElementPresent(By.cssSelector("span[data-auto=\"userLoanAmount\"]"));
		return driver.getCurrentUrl();
	}	
	
//	//Define the element of password
//	public WebElement passwordElement() {		
//		return waitUtilElementPresent(By.cssSelector("input[data-auto=\"password\"]"));
//	}

}
