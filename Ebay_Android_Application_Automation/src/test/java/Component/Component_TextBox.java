package Component;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import utilities.Common_Utilities;


/*This generic class we are using for the buttons lick and text verification all over the application*/
public class Component_TextBox {
	
	private MobileElement element;
	
	public Component_TextBox(MobileElement element){
		this.element=element;
	}
	
	
	

	public void Textboxavailabilityverification(String expected_textbox_text){
		
		WebDriverWait wait = new WebDriverWait(Common_Utilities.driver,2000);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		String Actual_textbox_text=element.getText();
		Assert.assertEquals(Actual_textbox_text, expected_textbox_text);
		
		
	}
	
	public void textBoxTextEnter(String TexttoEnter){
		
		try {
			WebDriverWait wait = new WebDriverWait(Common_Utilities.driver,2000);
			
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys("kolloldas645@gmail.com");
			Thread.sleep(1000);
			System.out.println("username entered");
			element.click();
			//element.submit();
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
public void textBoxTextEnterpass(String TexttoEnter){
		
		try {
			WebDriverWait wait = new WebDriverWait(Common_Utilities.driver,2000);
			
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys("kolloldas@123");
			Thread.sleep(1000);
			//Thread.sleep(1000);
			//element.submit();
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	

}
