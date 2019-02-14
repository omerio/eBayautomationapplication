package Component;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;

import utilities.Common_Utilities;


/*---Generic class for Assertion, we will use this to assert link text, button text type of verification---*/

/*We can also use iTESTLISTENER interface*/
public class AsserWrapper {
	
	
	public static void assertTrue(String expected_text, String actual_text, String screenName, String testName) throws IOException {
		
		try{
		Assert.assertEquals(expected_text, actual_text);
		}
		catch (Exception e) {
			
			//  We can handle exception here
			fail(testName,screenName);
			// we can Take ScreenShot on test failure as well
		}
	}
/**
 * 
 * @param testCaseName
 * @param screenNname
 * @throws IOException 
 */
	public static void fail(String testCaseName, String screenNname) throws IOException {
		// TODO Auto-generated method stub
		Assert.fail(testCaseName+" ScreenName"+screenNname);
		takeScreenShot(screenNname);
	
	}
	
	/* Take screenshot for test case failure */
private static void takeScreenShot(String screenNname) throws IOException {
	
	String filepath="/Users/kdas/Documents";
	File file = Common_Utilities.driver.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File(filepath+screenNname+".png"));
	
	Common_Utilities.log("/-----Log for failed Testcases-----/");
	System.out.println("***Placed screen shot in "+filepath+" ***");
	
}

}
