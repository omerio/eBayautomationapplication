package Component;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.appium.java_client.MobileElement;
import utilities.Common_Utilities;


/*This generic class we are using for the buttons lick and text verification all over the application*/
public class Component_button {
	
	private MobileElement element;
	
	public Component_button(MobileElement element) {
		
		//element = (MobileElement) Common_Utilities.driver.findElementByXPath("button");
		this.element=element;
		
	}
    
	public void verify_button_text(String expected_btn_text){
		
		//Add Code to wait unitl
		WebDriverWait wait = new WebDriverWait(Common_Utilities.driver,2000);
        wait.until(ExpectedConditions.visibilityOf(element));
		String Actual_btn_text= element.getText();
		System.out.println(element.getText());
		System.out.println(element.isDisplayed());
		Assert.assertEquals(expected_btn_text, Actual_btn_text);
		System.out.println("Text is verified and matching");
		
	}
	
	public void verify_button_click(String testCaseName, String screenNname) throws IOException{
		WebDriverWait wait = new WebDriverWait(Common_Utilities.driver,2000);
        wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println(element.isDisplayed());
		System.out.println("Element is visible");
		if(element.isDisplayed()){
			element.click();
		}
		else{
			AsserWrapper.fail(testCaseName, screenNname);
		}
		
		
		
	}
	

}
