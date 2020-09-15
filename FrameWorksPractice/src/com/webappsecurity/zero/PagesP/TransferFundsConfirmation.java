package com.webappsecurity.zero.PagesP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsConfirmation {
	@FindBy(css = "#transfer_funds_content > div > div > div.alert.alert-success")
	private WebElement sucMsg;
	@FindBy(css = "#settingsBox > ul > li:nth-child(3) > a")
	private WebElement userName;
	@FindBy(id = "logout_link")
	private WebElement logout;

	public TransferFundsConfirmation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public String getMsg() {
		String getMsg = sucMsg.getText();
		return getMsg;
	}

	public void logout() {
		userName.click();
		logout.click();
	}
}
