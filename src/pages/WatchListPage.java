package pages;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.BasePageObject;

public class WatchListPage extends BasePageObject{

	private static By watchListStar = By.cssSelector("span.icon-Star-Filled");
	private static By tableRow = By.cssSelector("table.cmc-table tbody tr");
	private static By tableColumns = By.cssSelector("table.cmc-table tbody tr td");
	
	public WatchListPage(WebDriver driver) {
		super(driver);
	}
	
	public int getNumberOfRows(){
		int totalRows = driver.findElements(tableRow).size();
		return totalRows;
	}
	
	public ArrayList getCryptoFromWatchlist(){
		//ArrayList <WebElement> ele = (ArrayList<WebElement>) driver.findElements(tableColumns));
		ArrayList<String> cryptoNames = new ArrayList<>();
		for(WebElement ele: driver.findElements(tableColumns)){
			cryptoNames.add(ele.getText());
		}
		return cryptoNames;
	}
}
