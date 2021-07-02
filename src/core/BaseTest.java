package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
       driver = new ChromeDriver();
       driver.get("https://coinmarketcap.com/");
       driver.manage().window().maximize();
      // driver.manage().window().setSize(new Dimension(1200,307));
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

    @AfterSuite
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }
    
    public WebDriver getDriver() {
        return this.driver;
    }
}
