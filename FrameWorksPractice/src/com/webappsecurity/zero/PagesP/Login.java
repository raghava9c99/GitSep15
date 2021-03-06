package com.webappsecurity.zero.PagesP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	@FindBy(id = "user_login")
	private WebElement uName;
	@FindBy(id = "user_password")
	private WebElement pass;
	@FindBy(name = "submit")
	private WebElement signIn;

	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void applicationLogin(String loginname, String loginpassword) {
		uName.sendKeys(loginname);
		pass.sendKeys(loginpassword);
		signIn.click();

	}

}
