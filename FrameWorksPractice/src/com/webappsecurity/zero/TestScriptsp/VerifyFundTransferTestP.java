package com.webappsecurity.zero.TestScriptsp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webappsecurity.zero.PagesP.AccountSummary;
import com.webappsecurity.zero.PagesP.Login;
import com.webappsecurity.zero.PagesP.TransferFunds;
import com.webappsecurity.zero.PagesP.TransferFundsConfirmation;
import com.webappsecurity.zero.PagesP.TransferFundsVerify;

import utilis.GenericMethods;

public class VerifyFundTransferTestP {
	WebDriver driver;

	@BeforeTest
	public void openApplication() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void verifyFundTransfer() throws IOException {
		Login lp = new Login(driver);
		AccountSummary acc = new AccountSummary(driver);
		TransferFunds tf = new TransferFunds(driver);
		TransferFundsVerify tfv = new TransferFundsVerify(driver);
		TransferFundsConfirmation tfc = new TransferFundsConfirmation(driver);
		String[][] data = GenericMethods
				.getData("C:\\Users\\ragha\\OneDrive\\Desktop\\Work Permit Docs\\TestDataPractice.xlsx",
						"Sheet1");
		for (int i = 1; i < data.length; i++) {

			lp.applicationLogin(data[i][0], data[i][1]);
			acc.clickTransferFunds();
			tf.enterFundTransferFundDetails(data[i][2], data[i][3]);
			tfv.clickSubmit();
			String actualMsg = tfc.getMsg();
			Assert.assertEquals(actualMsg, data[i][4]);
			tfc.logout();
			driver.get("http://zero.webappsecurity.com/login.html");

		}
	}


}
