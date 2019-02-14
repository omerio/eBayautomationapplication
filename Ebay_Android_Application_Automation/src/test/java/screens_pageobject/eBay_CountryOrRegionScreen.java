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
 * Page object for Country/Region Screen for verifications.
 * @author kdas
 *
 */
public class eBay_CountryOrRegionScreen extends ScreenBase {
	
/*Common_Utilities common = new Common_Utilities();
	
	Properties prop = Common_Utilities.loadPgaeObjectsdata("pageobjects.properties");

	
	MobileElement CountryRegiontitle = (MobileElement) common.driver.findElement(By.xpath(prop.getProperty("CountryRegiontitle")));
	MobileElement CountryRegionoptions = (MobileElement) common.driver.findElement(By.xpath(prop.getProperty("CountryRegionoptions")));
	//MobileElement countryRegionlink = (MobileElement) common.driver.findElement(By.xpath(prop.getProperty("countryRegionlink")));
	 **/
	 
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Country / region']")
	private MobileElement CountryRegiontitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/title']")
	private MobileElement CountryRegionoptions;
	
	private Component_Textverification countryRegionheader;
	private Component_Link countryRegionlink;

	
	public eBay_CountryOrRegionScreen(AppiumDriver driver) {
		super(driver);
	
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		countryRegionheader= new Component_Textverification(CountryRegiontitle);
		countryRegionlink= new Component_Link(CountryRegionoptions);
		
	}
	
	public void countryregionheaderverify(){
		
		countryRegionheader.verifyText("Country / region");
	}
	
	public void countryRegionlinkverfiy(){
		
		countryRegionlink.verifyLinkandClick("Auto-Detect");
		
	}

}
