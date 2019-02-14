package screens_pageobject;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import Component.Component_Link;
import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.Common_Utilities;


/***
 * Page object for Menu Screen for verifications.
 * @author kdas
 *
 */
public class eBay_MenuScreen extends ScreenBase{
	
	/* Taking the xpath dynamically from Property file*/
	/*
	Common_Utilities common = new Common_Utilities();	
	Properties prop = Common_Utilities.loadPgaeObjectsdata("pageobjects.properties");

		
		 MobileElement signIn = (MobileElement) common.driver.findElement(By.xpath(prop.getProperty("signIn")));
		 MobileElement settings = (MobileElement) common.driver.findElement(By.xpath(prop.getProperty("settings")));
		 */
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='SIGN IN']")
	private MobileElement signIn;
	
	@AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector()).scrollIntoView(text(\"Settings\"))")
	private MobileElement settings;
 
 
	
	private Component_Link settingsOption;
	private Component_Link signInlink;

	
	public eBay_MenuScreen(AppiumDriver driver) {
		super(driver);
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		settingsOption=new Component_Link(settings);
		signInlink= new Component_Link(signIn);
		
	}
	
	public void settingsOption(){
		
		settingsOption.verifyLinkandClick("Settings");
	}
	
	public void signInclick(){
		
		signInlink.verifyLinkandClick("SIGN IN");
		
	}

}
