package pageobject.loansubmission;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobject.portal.LoginPageObject;

public class OfferPageObject extends BasePageObject{

	public OfferPageObject(WebDriver driver) {	
		super(driver);
	}

	//Send driver to new site
	public LoginPageObject openLoginWebsite(){
		driver.get("https://www.credify.tech/portal/login");
		return new LoginPageObject(this.driver);
	}
}