package Component;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import utilities.Common_Utilities;


/*This generic class we are using for the Link lick and text verification all over the application*/
public class Component_Link {
	
	private MobileElement element;
	
	public Component_Link(MobileElement element){
		this.element=element;
		
	}
	
	public void verifyLinkandClick(String expected_Link_Text){
		WebDriverWait wait = new WebDriverWait(Common_Utilities.driver,2000);
        wait.until(ExpectedConditions.visibilityOf(element));
		String Actual_Link_text= element.getText();
		System.out.println(Actual_Link_text);
		System.out.println(element.isDisplayed());
		Assert.assertEquals(expected_Link_Text, Actual_Link_text);
		Common_Utilities.log("/-----Log for verification-----/");
		System.out.println("LinkText is checked and verified successfully");
		element.click();
		System.out.println("click action is successful");
		
	}
	}
	


