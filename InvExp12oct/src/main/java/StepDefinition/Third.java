package StepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lpl.base.TestBase;
import lpl.pages.AccountsPage;
import lpl.pages.DashboardPage;
import lpl.pages.LoginPage;
import lpl.util.TestUtil;

public class Third extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	AccountsPage accountsPage;
	WebDriver driver = null;

	public Third() {
		super();
	}

	@Before
	public void StartUp() {
		System.out.println("----This will run before Third scenario--");
	}

	@After
	public void tearMeDown() {
		System.out.println("----This will run after Third scenario--");
		QuitBrowser();
	}

	@Given("^dashboardPage is loaded and verified$")
	public void home_Page_is_loaded_and_verified() throws Throwable {
		initialization();
		loginPage = new LoginPage();

		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

		String actualTitle = dashboardPage.verifyDashboardPageTitle();
		System.out.println(actualTitle);
		Assert.assertEquals("Investor Experience", actualTitle);
		System.out.println("dashboardPage is loaded and verified");
	}

	@When("^I click on accounsLinkInSideBar$")
	public void i_click_on_activty_link() throws Throwable {
		
		accountsPage = dashboardPage.clickOnaccounsLinkInSideBar();
		System.out.println("Accounts link verified and clicked");
	
		System.out.println("Accounts Page Title is "+accountsPage.verifyAccountsPageTitle());
		
		
	}

	@Then("^accounts Page is displayed and verified$")
	public void accounts_Page_is_displayed_and_verified() throws Throwable {
		waitt(13);
		 
	
		Assert.assertTrue("accounts Lable is not displayed", accountsPage.verifymyAccountsLable());
		System.out.println("accountsPage is loaded and verified");
	

	}

	public void takefoto() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(scrFile, new File("pathTOSaveFile")); 001

		// String currentDir = System.getProperty("user.dir"); // 002

		// FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" +
		// System.currentTimeMillis() + ".jpg")); //002

		String ResultsFolderPath = TestUtil.createresultsfolder(); // 003

		System.out.println(ResultsFolderPath);
		FileUtils.copyFile(scrFile,
				new File(ResultsFolderPath + "\\screenshots\\" + TestUtil.CurrentDateAndTime + ".jpg")); // 003

	}
}
