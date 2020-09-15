package kdf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Methods {
	WebDriver driver;

	public void openBrowser() {
		driver = new ChromeDriver();
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void implementImpWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void navigateToApp(String url) {
		driver.get(url);
	}

	public void enterUserId(String locValue, String userId) {
		driver.findElement(By.id(locValue)).sendKeys(userId);
	}

	public void enterPassword(String locValue, String Password) {
		driver.findElement(By.id(locValue)).sendKeys(Password);
	}

	public void clickLogin(String loc, String locValue) {
		if (loc.equals("name")) {
			driver.findElement(By.name(locValue)).click();
		} else if (loc.equals("cssSelector")) {
			driver.findElement(By.cssSelector(locValue)).click();
		}
	}

	public String verifyErrMsg(String loc, String locValue) {
		String msg = null;
		if (loc.equals("cssSelector")) {
			msg = driver.findElement(By.cssSelector(locValue)).getText();
		} else if (loc.equals("id")) {
			msg = driver.findElement(By.id(locValue)).getText();
		}
		return msg;
	}

	public void closeApp() {
		driver.close();

	}

}
