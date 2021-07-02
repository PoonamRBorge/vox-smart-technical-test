package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import core.BasePageObject;

public class CryptoHomePage extends BasePageObject {

	private static By button_login = By.cssSelector("div.sc-111rrsy-0.qbrWo > button.x0o17e-0.qrNYy");
	private static By modal_login = By.cssSelector("div > div.sc-1htht4q-0.lhjLrT");
	private static By text_email = By.cssSelector("div.sc-1htht4q-0.lhjLrT > div:nth-child(3) > input");
	private static By text_pwd = By.cssSelector("div.sc-1htht4q-0.lhjLrT > div.sc-1htht4q-3.kHSKLo.last > div.sc-1srpo52-0.ciHfxX > input");
	private static By button_loginOnModal = By.cssSelector("div.sc-1htht4q-0.lhjLrT > div.sc-1htht4q-6.kUXNCx > button");
	private static By link_crypto = By.xpath("//div[@class = 'sc-111rrsy-0 qbrWo']//ul/li//span/span");
	private static By table_cryptoTable = By.cssSelector("table.cmc-table");
	private static By tableRow = By.cssSelector("table.cmc-table tbody tr");
	private static By link_WatchList = By.cssSelector("div.qfadqr-0.hVwYil li:nth-child(5) span");
	//This is not the ideal way to store ID and Pwd but for testing purpose I have put them here.
	private static final String USER_EMAIL = "tAbcest@gmail.com";
	private static final String USER_PWD = "Soil@2912";
	
	public CryptoHomePage(WebDriver driver){
		super(driver);
	}
	/*Cosidering the test accounts are already created and are used
	 * Here I am using the account I created for testing purpose
	 */
	public void logIn() throws Exception{
		click(button_login);
		waitForElement(modal_login);
		enterValueInTextFieldWithSendKey(text_email, USER_EMAIL);
		enterValueInTextFieldWithSendKey(text_pwd, USER_PWD);
		click(button_loginOnModal);
	}
	
	public CryptoHomePage loadCryptoCurrencies(){
		click(link_crypto);
		return new CryptoHomePage(driver);
	}
	
	public int getNumberOfRows(){
		int totalRows = driver.findElements(tableRow).size();
		return totalRows;
	}
	
	public void addToWatchlist(int row){
		click(By.cssSelector("tr:nth-child("+row+") span.icon-Star"));
	}
	
	public WatchListPage openWatchlist(){
		int intialNumberofTabs = numberofTabs();
		clickAndOpenNewTab(link_WatchList);
		switchTabs(numberofTabs());
	    return new WatchListPage(driver);
	}

}
