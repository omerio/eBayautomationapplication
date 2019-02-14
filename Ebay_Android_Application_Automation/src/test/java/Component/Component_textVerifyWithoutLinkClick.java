package Component;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.MobileElement;
import utilities.Common_Utilities;

public class Component_textVerifyWithoutLinkClick {
	
private MobileElement element;
private String screenName;
	
	public Component_textVerifyWithoutLinkClick(MobileElement element, String screenName) throws IOException {
		
		//element = (MobileElement) Common_Utilities.driver.findElementByXPath("button");
		this.screenName = screenName;
		if(element != null){
		this.element=element;
		}
		else{
			AsserWrapper.fail("", "");
		}
		
	}
	

	public boolean verifyTextWithoutLinkClick(String expected_text) throws IOException{
		
		//Add Code to wait unitl
		String Actual_text = "";
		if(element != null){
		WebDriverWait wait = new WebDriverWait(Common_Utilities.driver,2000);
        wait.until(ExpectedConditions.visibilityOf(element));
		Actual_text= element.getText();
		System.out.println(Actual_text);
		System.out.println(element.isDisplayed());
		AsserWrapper.assertTrue(expected_text, Actual_text, "", "");
		Common_Utilities.log("/-----Log for verification-----/");
		System.out.println("Text is checked and verified");
		}
		else{
			Common_Utilities.log("/-----Log for verification-----/");
			AsserWrapper.fail("todo write message", screenName);
			
		}
		return expected_text.equalsIgnoreCase(Actual_text);
	}

}


