package regression;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import utils.UtilKit;

public class Tc001 extends BaseTest {

	@Test(dataProvider = "gettestdata")
	public void tc001(HashMap<String, String> datamapping) {
		ApplicationKeywords app = new ApplicationKeywords();
		app.startBrowser();
		app.lunchapp();
		app.type("username_textbox", datamapping.get("username"));
		app.type("password_textbox", datamapping.get("password"));
		app.click("login_button");
		app.verifytitle(datamapping.get("exptitle"));
		
	}

	@DataProvider
	public Object[][]gettestdata(){
		
			 Object[][] data1 = new Object[1][1];
			   data1[0][0] = UtilKit.testdata("Tc001");
			   System.out.println(data1[0][0]);
			 return data1;
		
	}
	}
