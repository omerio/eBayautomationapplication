package screens_pageobject;

import org.openqa.selenium.support.PageFactory;

import Component.Component_Link;
import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/***
 * Page object for payWith Screen for verifications.
 * @author kdas
 *
 */
public class eBay_PaywithScreen extends ScreenBase {
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Credit or debit card']")
	private MobileElement cereditDebit;
	
	private Component_Link creditDebitoption;

	public eBay_PaywithScreen(AppiumDriver driver) {
		super(driver);
		
		//PageFactory.initElements(driver, this);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		creditDebitoption=new Component_Link(cereditDebit);
		
		
	}
	
	public void creditdebitoptionverfiyandClick(){
		
		creditDebitoption.verifyLinkandClick("Credit or debit card");
		
	}

}
