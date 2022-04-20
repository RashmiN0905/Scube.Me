package pom_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.Base_class;

/***
 * 
 * @author Rashmi
 *
 */
public class LogOutPage {
	
	
	// Constructor
	public LogOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// WebElements
	@FindBy(xpath = "(//td[@class=\"small\" and @valign=\"bottom\"])[1]")
	private WebElement LogoutImage;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement SignOut;

	// GetterMethods
	public WebElement getLogoutImage() {
		return LogoutImage;
	}

	public WebElement getSignOut() {
		return SignOut;
	}

	// Business Icon or ActionMethods
	public void Logout() {
		LogoutImage.click();
		SignOut.click();
	}
}
