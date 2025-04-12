package keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import exceptions.InValidBrowserException;

public class GenericKeywords extends BaseTest {
	public void startBrowser() {
		String browsername = configprop.getProperty("browser");
		switch (browsername) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();

		default:
			try {
				throw new InValidBrowserException();

			} catch (InValidBrowserException e) {
				System.out.println(e.getMessage());
				// TODO: handle exception
			}

			break;
		}
	}

	public void lunchapp() {
		driver.get(configprop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Long.parseLong(configprop.getProperty("implictwait"))));

	}

	private WebElement getelement(String locatorkey) {
		WebElement element = null;
		WebDriverWait mywait = new WebDriverWait(driver,
				Duration.ofSeconds(Long.parseLong(configprop.getProperty("explicitwait"))));
		mywait.until(ExpectedConditions.presenceOfElementLocated(getlocator(locatorkey)));
		element = driver.findElement(getlocator(locatorkey));
		return element;
	}

	public void type(String locatorkey, String text) {
		getelement(locatorkey).sendKeys(text);

	}
	public void click(String locatorkey) {
		getelement(locatorkey).click();
	}
	
	public void cleartext(String locatorkey) {
		getelement(locatorkey).clear();
	}
	
	public void selcttext(String locatorkey , String text) {
		new Select(getelement(locatorkey)).selectByVisibleText(text);
	}
	
	public String text(String locatorkey) {
		String text = getelement(locatorkey).getText();
		return text;
		
	}

	private By getlocator(String locatorKey) {
		By by=null;
		if(locatorKey.endsWith("_id")) {
			by = By.id(locatorprop.getProperty(locatorKey));
		}
			else if(locatorKey.endsWith("_xpath")) {
				by=By.xpath(locatorprop.getProperty(locatorKey));
			}
			else if(locatorKey.endsWith("_name")) {
				by=By.name(locatorprop.getProperty(locatorKey));
				}
		else if(locatorKey.endsWith("_linktext")) {
			by= By.linkText(locatorprop.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_textbox"))
			by= By.xpath(locatorprop.getProperty(locatorKey));
		else 
			by= By.xpath(locatorprop.getProperty(locatorKey));
		
		return by;
	}

}
