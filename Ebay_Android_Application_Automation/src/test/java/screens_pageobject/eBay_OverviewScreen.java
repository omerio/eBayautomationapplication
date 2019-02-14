package screens_pageobject;

import java.io.IOException;
import java.util.Properties;

import javax.print.attribute.standard.OrientationRequested;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.PageFactory;

import Component.Component_TextBox;
import Component.Component_button;
import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.Common_Utilities;


/***
 * Page object for Dashboard Screen for verifications.
 * @author kdas
 *
 */
public class eBay_OverviewScreen extends ScreenBase{
	
	/* Taking the xpath dynamically from Property file*/
	
	/*Common_Utilities common = new Common_Utilities();
	
	Properties prop = Common_Utilities.loadPgaeObjectsdata("pageobjects.properties");

	
	MobileElement hamburgermenu = (MobileElement) common.driver.findElement(By.xpath(prop.getProperty("hamburgermenu")));
	MobileElement search = (MobileElement) common.driver.findElement(By.xpath(prop.getProperty("search")));*/
	
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id='com.ebay.mobile:id/home']")
	private MobileElement hamburgermenu;
	
   @AndroidFindBy(xpath="//android.widget.TextView[@text='Search for anything']")
	private MobileElement search;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.ebay.mobile:id/logo']")
	public  MobileElement logoExistence;
 
 
	
	private Component_TextBox searchProduct;
	private Component_button hamburgerMenuicon;
	

	public eBay_OverviewScreen(AppiumDriver driver) throws InterruptedException {
		super(driver);
		
		Common_Utilities common = new Common_Utilities();
		
		Properties prop = Common_Utilities.loadPgaeObjectsdata("pageobjects.properties");

		
		
				
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		Thread.sleep(5000);
		driver.rotate(ScreenOrientation.LANDSCAPE);
		Thread.sleep(3000);
		driver.rotate(ScreenOrientation.PORTRAIT);
		Thread.sleep(3000);
		//hamburgermenu = (MobileElement) driver.findElementById("com.ebay.mobile:id/home");
		// hamburgermenu = (MobileElement) driver.findElement(By.xpath(prop.getProperty("hamburgermenu")));
		// search = (MobileElement) driver.findElement(By.xpath(prop.getProperty("search")));
		hamburgerMenuicon=new Component_button(hamburgermenu);
		searchProduct=new Component_TextBox(search);
		
		
		
	}
	
	public void hamburgerMenu_click(String testCaseName) throws IOException{
		
		String Name = this.getClass().getSimpleName();
		hamburgerMenuicon.verify_button_click(testCaseName,Name);
		
	}
	
	public void searchenter(){
		
		searchProduct.textBoxTextEnter("65Inch TV");
		
	}

	

}
