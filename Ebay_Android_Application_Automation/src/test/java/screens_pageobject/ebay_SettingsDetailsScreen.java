package screens_pageobject;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import Component.Component_Link;
import Component.Component_Textverification;
import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.Common_Utilities;


/***
 * Page object for Setting Screen for verifications.
 * @author kdas
 *
 */
public class ebay_SettingsDetailsScreen extends ScreenBase{
	
	/* Taking the xpath dynamically from Property file*/
	/*
	Common_Utilities common = new Common_Utilities();
	Properties prop = Common_Utilities.loadPgaeObjectsdata("pageobjects.properties");

		
		MobileElement settingTitle = (MobileElement) common.driver.findElement(By.xpath(prop.getProperty("settingTitle")));
		MobileElement countryRegion = (MobileElement) common.driver.findElement(By.xpath(prop.getProperty("countryRegion")));
		*/
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Settings']")
	private MobileElement settingTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Country / region']")
	private MobileElement countryRegion;
		
	
	private Component_Textverification settingsHeader;
	private Component_Link countryRegionOption;
	

	public ebay_SettingsDetailsScreen(AppiumDriver driver) {
		super(driver);
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		settingsHeader= new Component_Textverification(settingTitle);
		countryRegionOption= new Component_Link(countryRegion);
		
	}
	
	public void settingsHeaderText(){
		
		settingsHeader.verifyText("Settings");
	}
	
	public void countryregionOptionclick(){
		
		countryRegionOption.verifyLinkandClick("Country / region");
		
	}
	

}
