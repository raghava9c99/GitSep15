package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utilis.GenericMethods;

public class Application {
//Making changes after R1.1
	@Test
	public void verifyInvalidLogin() throws IOException {
		String[][] data = GenericMethods.getData("C:\\Users\\ragha\\OneDrive\\Desktop\\Work Permit Docs\\kdfp.xlsx", "Sheet1");
		Methods mtd = new Methods();
		for(int i = 1;i<data.length;i++) {
			switch(data[i][3]) {
			case "openBrowser":
				mtd.openBrowser();
				break;
			case "maxBrowser":
				mtd.maximizeBrowser();
				break;
			case "impWait":
				mtd.implementImpWait();
				break;
			case "navigateToApplication":
				mtd.navigateToApp(data[i][6]);
				break;
			case "enterUserID":
				mtd.enterUserId(data[i][5], data[i][6]);
				break;
			case "enterpassword":
				mtd.enterPassword(data[i][5], data[i][6]);
				break;
			case "clickLogin":
				mtd.clickLogin(data[i][4], data[i][5]);
				break;
			case "verifyErrMsg":
				String actualMsg = mtd.verifyErrMsg(data[i][4], data[i][5]);
				Assert.assertEquals(actualMsg, data[i][6]);
				break;
			case "closeApp":
				mtd.closeApp();
				break;


			}
		}

	}
}
