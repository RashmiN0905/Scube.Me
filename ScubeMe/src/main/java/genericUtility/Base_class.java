package genericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_repository.LogOutPage;
import pom_repository.Login_page;

public class Base_class {
	public ExtentReports report = null;
	public ExtentTest extentTest = null;
	public static WebDriver driver;
	public WebDriverWait  explicitWait;
	public ExcelUtility excelLib = new ExcelUtility();
	
	
	
	@BeforeSuite(alwaysRun = true)
	public void extentReports() {
		report = new ExtentReports("./Reports/ExtentReport.html");
		extentTest = report.startTest("TC_06Test");	
	}
	
	@Parameters("browser") 
	@BeforeClass(alwaysRun = true)
	public void openingApplication(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("fireFox")) {
			//System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		Reporter.log("Browser is succesfully launched", true);
		driver.manage().window().maximize();
		Reporter.log("Browser is succesfully Maximized", true);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 10);
		driver.get(excelLib.readStringDataFromExcel("V_Tiger", 0, 1));	
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void LoginPage(){
		Login_page logIn = new Login_page(driver);
		logIn.LoginToApplication(excelLib.readStringDataFromExcel("ScubeMe", 2, 1), excelLib.readStringDataFromExcel("ScubeMe", 3, 1));
		 explicitWait = new WebDriverWait(driver, 10);
		 explicitWait.until(ExpectedConditions.titleIs("Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM"));
		 
	}
	
	@AfterMethod(alwaysRun = true)
	public void Logout_page() {
		LogOutPage log = new LogOutPage(driver);
		log.Logout();
		
	}
	
	
	@AfterClass(alwaysRun = true)
	public void closeTheBrowser() {
		driver.quit();
		Reporter.log("Application closed", true);
	}
	
	@AfterSuite
	public void endReport() {
		report.endTest(extentTest);
		report.flush();
	}
}


