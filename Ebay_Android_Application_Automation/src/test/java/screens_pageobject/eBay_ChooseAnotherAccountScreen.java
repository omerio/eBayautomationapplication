package screens_pageobject;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.PageFactory;

import Component.Component_Link;
import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/***
 * Page object for AChoose Another Account Screen for verifications.
 * @author kdas
 *
 */
public class eBay_ChooseAnotherAccountScreen extends ScreenBase{
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.ebay.mobile:id/button_switch_accounts']")
	//@AndroidFindBy(xpath="//*[@text='CHOOSE ANOTHER EBAY ACCOUNT']")
	private MobileElement otherAccountchoose;
	
	private Component_Link chooseAccountlink;

	public eBay_ChooseAnotherAccountScreen(AppiumDriver driver) {
		super(driver);
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	
		chooseAccountlink= new Component_Link(otherAccountchoose);
		
//		driver.rotate(ScreenOrientation.LANDSCAPE);
//		Thread.sleep(3000);
//		driver.rotate(ScreenOrientation.PORTRAIT);
//		Thread.sleep(3000);
		
	}
	
	public void chooseOtheraccount(){
		
		chooseAccountlink.verifyLinkandClick("CHOOSE ANOTHER EBAY ACCOUNT");
		
	}
	
	
	

}
