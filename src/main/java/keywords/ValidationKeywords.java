package keywords;

import org.testng.Assert;

public class ValidationKeywords extends GenericKeywords{
	
	public void verifytitle(String Exptitle) {
		Assert.assertEquals(driver.getTitle(), Exptitle);
		
	}
	
	public void errormessage(String error) {
	    Assert.assertEquals(text("Checkin_error"), error);	
	}

}
