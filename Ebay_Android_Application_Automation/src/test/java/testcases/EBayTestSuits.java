package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import Component.GenerateReport;
import base.TestBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
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



/* This class we are using for the writing the test script only through method invocations*/
@Listeners(GenerateReport.class)
public class EBayTestSuits extends TestBase {
	
	
	
	@BeforeTest
	public void init() throws InterruptedException, IOException{
		addtCart=new eBay_AddtoCartScreen(driver);
		checkOut=new eBay_CheckoutScreen(driver);
		chooseOtherAccount=new eBay_ChooseAnotherAccountScreen(driver);
		country=new eBay_CountryOrRegionScreen(driver);
		countrySelection=new eBay_CountryRegionSelectionScreen(driver);
		cardDetails=new eBay_CreditdebitDetailsScreen(driver);
		overview=new eBay_OverviewScreen(driver);
		payWith=new eBay_PaywithScreen(driver);
		productDetails=new eBay_ProductDetailsScreen(driver);
		seachItems=new eBay_SearchScreen(driver);
		settingsDetails=new ebay_SettingsDetailsScreen(driver);
		signIn=new eBay_SignINScreen(driver);
		Menu=new eBay_MenuScreen(driver);
		
		
	}
	
	@Test
	public void test001OverviewScreenUIVerification() throws InterruptedException, IOException{
		
		
		test = extent.createTest("test001OverviewScreenUIVerification");
		//overview.logoExistence.isDisplayed();
		Common_Utilities.log("/-----Log for Testscripts-----/");
		System.out.println("Logo is displayed--Confirmed overview screen is correct");
		overview.hamburgerMenu_click("test001OverviewScreenUIVerification");
		Menu.settingsOption();
		Thread.sleep(2000);
	    settingsDetails.settingsHeaderText();
	    settingsDetails.countryregionOptionclick();
		Thread.sleep(3000);	
		country.countryregionheaderverify();
	    country.countryRegionlinkverfiy();
	    Thread.sleep(2000);
	    countrySelection.autoselectionOff.click();
	    countrySelection.autoselectionOff.click();
	    Thread.sleep(2000);
	    countrySelection.countryselect.click();
	    Thread.sleep(2000);
	    TouchAction action = new TouchAction(Common_Utilities.driver);
	    action.press(PointOption.point(629, 944)).release().perform();
	    Thread.sleep(2000);
	    //action.press(PointOption.point(18, 1013)).moveTo(PointOption.point(18, 1440)).release().perform();
	    countrySelection.entersearchtext.sendKeys("Australia");
		countrySelection.countrySelectdropdown.click();
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		
	}
	
	@Test
	public void test002SignIn() throws Exception{
		
		test = extent.createTest("test002SignIn");
		overview.hamburgerMenu_click("test002SignIn");
		Thread.sleep(3000);
		Menu.signInclick();
		Thread.sleep(2000);
		System.out.println(Common_Utilities.driver.getContext());
		driver.navigate().back();
		Thread.sleep(3000);
		chooseOtherAccount.chooseOtheraccount();
		Thread.sleep(4000);
		Common_Utilities.driver.navigate().back();
		Thread.sleep(2000);
		signIn.signindataentry("test002SignIn");
		Common_Utilities.log("/-----Log for Testscripts-----/");
		System.out.println("SignIn is successful");
	}

	@Test
	public void test003searchproduct() throws InterruptedException{
		
		test = extent.createTest("test003searchproduct");
		seachItems.entertextInsearchBox();
		Thread.sleep(4000);
		seachItems.divantiTVselect.click();
	}
	
	@Test
	public void test004productDetails() throws InterruptedException, IOException{
		
		test = extent.createTest("test004productDetails");
		Thread.sleep(4000);
		String value = productDetails.detailsscreentextWithoutLinkclik("test004productDetails");
		Common_Utilities.log("/-----Log for Testscripts-----/");
		System.out.println("Details screen is verfied successfully");
		productDetails.addproductAddtocart("test004productDetails");
		System.out.println("Added product to ADDtoCart");
		Thread.sleep(5000);
		productDetails.cartViewsbutton("test004productDetails");
		Thread.sleep(3000);
		addtCart.productTextVerifyOnAddtocartScreen(value);
		addtCart.checkoutButtonclick("test004productDetails");
		Thread.sleep(4000);	
	}	
	@Test
	public void test005purchaseflow() throws InterruptedException{
		
		test = extent.createTest("test005purchaseflow");
		checkOut.CheckoutscreentitleVerification();
		checkOut.payemtoptionlinkclick();
		Thread.sleep(5000);
		payWith.creditdebitoptionverfiyandClick();
		Thread.sleep(5000);
		
	}
	
	@Test
	public void test006enteringpaymentdetails() throws InterruptedException{
		
		test = extent.createTest("test006enteringpaymentdetails");
		cardDetails.payemntdataentry();
		Thread.sleep(4000);
		cardDetails.submitepaymentdetails();
		cardDetails.wrongpaymentdetailsverification();
		Thread.sleep(4000);
		driver.navigate().back();
		
		
	}
	
	

	

	
	
}
