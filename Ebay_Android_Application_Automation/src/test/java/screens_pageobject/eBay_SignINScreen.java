package screens_pageobject;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Component.Component_TextBox;
import Component.Component_button;
import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.Common_Utilities;

/***
 * Page object for Sign In Screen for verifications.
 * @author kdas
 *
 */
public class eBay_SignINScreen extends ScreenBase {
	
	/* Taking the xpath dynamically from Property file*/
	/*
	Common_Utilities common = new Common_Utilities();
	Properties prop = Common_Utilities.loadPgaeObjectsdata("pageobjects.properties");

		
		MobileElement username = (MobileElement) common.driver.findElement(By.xpath(prop.getProperty("username")));
		MobileElement password = (MobileElement) common.driver.findElement(By.xpath(prop.getProperty("password")));
		MobileElement signintext = (MobileElement) common.driver.findElement(By.xpath(prop.getProperty("signintext")));
		MobileElement signInButton = (MobileElement) common.driver.findElement(By.xpath(prop.getProperty("signInButton")));
		*/
		
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.ebay.mobile:id/edit_text_username']")
	public MobileElement username;
	
	@AndroidFindBy(xpath="//android.widget.EditText[resource-id='com.ebay.mobile:id/edit_text_username']")
	public MobileElement password;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@content-desc='Sign in']")
	public MobileElement signintext;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@content-desc='Sign in']/android.widget.LinearLayout/android.widget.Button[2]")
	private MobileElement signInButton;
		
	
	public Component_TextBox usernameTextbox;
	public Component_TextBox passwordTextbox;
	private Component_button signInClick;
	private Properties testDataProp;
	public eBay_SignINScreen(AppiumDriver driver) {
		super(driver);
		
		/*Common_Utilities common = new Common_Utilities();
		Properties prop = Common_Utilities.loadPgaeObjectsdata("pageobjects.properties");
		 username = (MobileElement) driver.findElement(By.xpath(prop.getProperty("username")));
		 password = (MobileElement) driver.findElement(By.xpath(prop.getProperty("password")));
		 signintext = (MobileElement) driver.findElement(By.xpath(prop.getProperty("signintext")));
		 signInButton = (MobileElement) driver.findElement(By.xpath(prop.getProperty("signInButton")));
		 */
		
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		usernameTextbox= new Component_TextBox(username);
		//passwordTextbox=new Component_TextBox(password);
		signInClick= new Component_button(signInButton);	
		try {
			testDataProp=Common_Utilities.loadTestData("Testdata.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void signindataentry(String testCaseName) throws Exception{
		
		String screenName = this.getClass().getSimpleName();
		String sUserName = testDataProp.getProperty("username");
		String sPassword = testDataProp.getProperty("password");
		System.out.println(sUserName);
		System.out.println(sPassword);
		Thread.sleep(3000);
		
			
		
		//usernameTextbox.textBoxTextEnter(testDataProp.getProperty("username"));
		usernameTextbox.textBoxTextEnter(sUserName);
		Thread.sleep(3000);
		password=(MobileElement) driver.findElementById("com.ebay.mobile:id/edit_text_password");
		password.click();
		driver.rotate(ScreenOrientation.LANDSCAPE);
		Thread.sleep(3000);
		driver.rotate(ScreenOrientation.PORTRAIT);
		Thread.sleep(3000);
		System.out.println("Click Perform");
		password.sendKeys("kalloldas@123");
		
		
		//passwordTextbox.textBoxTextEnterpass(testDataProp.getProperty("password"));
		
		
		
	
		
		signInClick.verify_button_click(testCaseName,screenName);
		
		
		
	}
	


}
