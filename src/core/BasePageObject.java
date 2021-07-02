package core;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

	private static final int TIMEOUT = 5;
    
	protected WebDriver driver;
    private WebDriverWait wait;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        isLoaded();
        wait = new WebDriverWait(driver, TIMEOUT, 100);
     }
    protected void isLoaded() {
		this.wait = new WebDriverWait(driver, TIMEOUT, 100);
	}
    protected void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void waitForElement(final By by) {
		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				d.findElement(by);
				return Boolean.valueOf(true);
			}
		};

		Wait w = new WebDriverWait(driver, 100);
		w.until(e);
	}

    public void click(By by) {
		waitForElement(by);
		driver.findElement(by).click();
	}
    
    public int numberofTabs(){
    	return driver.getWindowHandles().size();
    }
    
    public void switchTabs(int tabNumber){
    	Set<String> handles = driver.getWindowHandles();
    	driver.switchTo().window(handles.toArray()[tabNumber].toString());
    }
    
    public void clickAndOpenNewTab(By linktoOpen){
    	driver.findElement(linktoOpen).sendKeys(Keys.CONTROL +"t");
    }
    
    public void enterValueInTextFieldWithSendKey(By by, String valueToBeEntered) throws Exception {
		waitForElement(by);
		WebElement identifier = driver.findElement(by);
		identifier.clear();
		identifier.sendKeys(valueToBeEntered);
	}
}
