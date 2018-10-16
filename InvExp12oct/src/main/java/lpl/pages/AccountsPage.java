package lpl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lpl.base.TestBase;

public class AccountsPage extends TestBase {

	public AccountsPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h1[contains(text(),'My Accounts')]")
	private WebElement myAccountsLable;
	
	@FindBy(id="data-table")
	private WebElement dataTable;
	
	String MyAcno = "7603";
	//@FindBy(xpath="//a[contains(text(),'xxxx-"+MyAcno+"7603')]")
		
	
	@FindBy(xpath="//a[contains(text(),'xxxx-7603')]")
	private WebElement accountLink;
	
	//@FindBy(xpath=".//*[@id='data-table']/tbody/tr[3]/td[4]/div/span/a")
	//private WebElement accountLink;
	
	
	
	
	
	
	public void clickOnTheAccount () {

		if(accountLink.isDisplayed()) {
			accountLink.click();
		} else {
			System.out.println("Account not found");
		}
	}
	public String verifyAccountsPageTitle(){
		return driver.getTitle();
	}


	public boolean verifymyAccountsLable() {
				return  myAccountsLable.isDisplayed();
	}
	
}
