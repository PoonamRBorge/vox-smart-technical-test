package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CryptoHomePage;
import pages.WatchListPage;
import core.BaseTest;

public class CryptoTest extends BaseTest{

	CryptoHomePage homePage;
	WatchListPage watchListPage;

	
	@BeforeMethod
	void setup(){
		homePage = new CryptoHomePage(super.getDriver());
	}
	
	@Test
	public void verifyNumberOfResultOnPage(){
		Assert.assertTrue(homePage.getNumberOfRows() == 100);
	}
	
	@Test
	public void addToWatchListAndVerify() throws Exception{
		homePage.logIn();
		ArrayList<String> cryptoRowNumbers = new ArrayList<>(Arrays.asList("1", "3", "4", "5", "7"));
		ArrayList<String> cryptoNames = new ArrayList<>(Arrays.asList("Bitcoin", "Tether", "Binance Coin", "Cardano", "XRP"));
		for (String row : cryptoRowNumbers) {
			homePage.addToWatchlist(Integer.parseInt(row));
		}
		watchListPage = homePage.openWatchlist();
		Assert.assertTrue(watchListPage.getNumberOfRows() == 5);
		Assert.assertTrue(cryptoNames.containsAll(watchListPage.getCryptoFromWatchlist()));
	}
	
}
