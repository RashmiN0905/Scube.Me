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
public class Login_page {

	//Constructor
	public Login_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//dataMembers
	@FindBy(name="user_name")
	private WebElement usenameTextfield;
	
	@FindBy(name="user_password")
	private WebElement passwordTextfield;
	
	@FindBy(id = "submitButton")
	private WebElement submit;
	
	//GetterMethods
	public WebElement getusenameTextfield() {
		return usenameTextfield;
	}
	
	public WebElement getpasswordTextfield() {
		return passwordTextfield;
	}
	
	public WebElement getsubmit() {
		return submit;
	}
	
	//ActionMethods or Business Logic or Page Action
	
	public void LoginToApplication(String username, String password) {
		usenameTextfield.sendKeys(username);
		passwordTextfield.sendKeys(password);
		submit.click();
	}
	
	
}
