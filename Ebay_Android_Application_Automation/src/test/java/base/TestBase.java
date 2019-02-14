package base;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Component.TestReports;
import io.appium.java_client.AppiumDriver;
import screens_pageobject.eBay_AddtoCartScreen;
import screens_pageobject.eBay_CountryOrRegionScreen;
import screens_pageobject.eBay_CheckoutScreen;
import screens_pageobject.eBay_CountryRegionSelectionScreen;
import screens_pageobject.eBay_MenuScreen;
import screens_pageobject.eBay_OverviewScreen;
import screens_pageobject.eBay_PaywithScreen;
import screens_pageobject.eBay_ProductDetailsScreen;
import screens_pageobject.eBay_SearchScreen;
import screens_pageobject.eBay_SignINScreen;
import screens_pageobject.eBay_ChooseAnotherAccountScreen;
import screens_pageobject.eBay_CreditdebitDetailsScreen;
import screens_pageobject.ebay_SettingsDetailsScreen;
import utilities.Common_Utilities;

/* In this class we are setting up the driver , passing the propertiesFile, before test suit execution started
 * Also after the test suit execution we are closing the driver*/
public class TestBase extends TestReports{
	
	public  AppiumDriver driver;
	public static eBay_AddtoCartScreen addtCart;
	public static eBay_CheckoutScreen checkOut;
	public static eBay_ChooseAnotherAccountScreen chooseOtherAccount;
	public static eBay_CountryOrRegionScreen country;
	public static eBay_CountryRegionSelectionScreen countrySelection;
	public static eBay_CreditdebitDetailsScreen cardDetails;
	public static eBay_OverviewScreen overview;
	public static eBay_PaywithScreen payWith;
	public static eBay_ProductDetailsScreen productDetails;
	public static eBay_SearchScreen seachItems;
	public static ebay_SettingsDetailsScreen settingsDetails;
	public static eBay_SignINScreen signIn;
	public static eBay_MenuScreen Menu;
	
	
	
	
	public static String loadPropertyFile= "Test.properties";
    //public static Logger log= Logger.getLogger("devpinoyLogger");
	
	
	
	@BeforeSuite
	public void setup() throws IOException{
		//properties, desired capabilities
		
		if(driver==null){	
				Common_Utilities.loadconfigproperties(loadPropertyFile);
				Common_Utilities.log("/-----Log for driver-----/");
				driver=Common_Utilities.getDriver();	
		}
			}
	
	
	@AfterSuite
	public void teardown(){
		
		driver.quit();
		//log.debug("quiting the server");
		
	}
}
