package Component;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import utilities.Common_Utilities;


/*This generic class we are using for the text verification all over the application*/
public class Component_Textverification {
	
	private MobileElement element;
	
	public Component_Textverification(MobileElement element) {
		
		//element = (MobileElement) Common_Utilities.driver.findElementByXPath("button");
		this.element=element;
		
	}
    
	

	
	public void verifyText(String expected_text){
		
		//Add Code to wait unitl
		WebDriverWait wait = new WebDriverWait(Common_Utilities.driver,2000);
        wait.until(ExpectedConditions.visibilityOf(element));
		String Actual_text= element.getText();
		System.out.println(Actual_text);
		System.out.println(element.isDisplayed());
		Assert.assertEquals(expected_text, Actual_text);
		Common_Utilities.log("/-----Log for verification-----/");
		System.out.println("Text is checked and verified");
		element.click();
		Common_Utilities.log("/-----Log for verification-----/");
		System.out.println("click action is successful");
		
	}
	
	/*public void verify_button_click(){
		WebDriverWait wait = new WebDriverWait(Common_Utilities.driver,2000);
        wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println(element.isDisplayed());
		element.click();
		
	}*/
	

}
