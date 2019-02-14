package screens_pageobject;

import org.openqa.selenium.support.PageFactory;

import Component.Component_Link;
import Component.Component_Textverification;
import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/***
 * Page object for CheckOut screen for verifications.
 * @author kdas
 *
 */

public class eBay_CheckoutScreen extends ScreenBase{
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Checkout']")
	private MobileElement checkoutTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='SELECT PAYMENT OPTION']")
	private MobileElement payment;
	
	private Component_Textverification cheoutTitletext;
	private Component_Link payemntOption;

	public eBay_CheckoutScreen(AppiumDriver driver) {
		super(driver);
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		cheoutTitletext= new Component_Textverification(checkoutTitle);
		payemntOption=new Component_Link(payment);
		
		
	}
	
	public void CheckoutscreentitleVerification(){
		
		cheoutTitletext.verifyText("Checkout");
	}
	
	public void payemtoptionlinkclick(){
		
		payemntOption.verifyLinkandClick("SELECT PAYMENT OPTION");
		
	}

}
