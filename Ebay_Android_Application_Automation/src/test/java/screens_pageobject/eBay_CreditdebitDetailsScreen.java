package screens_pageobject;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import Component.Component_Link;
import Component.Component_TextBox;
import Component.Component_Textverification;
import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.Common_Utilities;

/***
 * Page object for Credit/debit crad details Screen for verifications.
 * @author kdas
 *
 */
public class eBay_CreditdebitDetailsScreen extends ScreenBase{
	
	@AndroidFindBy(xpath="//TextInputLayout[@text='Card number']")
	private MobileElement card;
	
	@AndroidFindBy(xpath="//TextInputLayout[@text='Expiry date']")
	private MobileElement expiry;
	
	@AndroidFindBy(xpath="//TextInputLayout[@text='Security code']")
	private MobileElement security;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='DONE']")
	private MobileElement done;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Oops, looks like you missed something. Please fix the problem below.']")
	private MobileElement oops;
	
	
	private Properties paymentDataprop;
	private Component_TextBox cardNumber;
	private Component_TextBox expiryDate;
	private Component_TextBox securityCode;
	private Component_Link submitPaymentdetails;
	private Component_Textverification wrongPaymentdetails;
	
	

	public eBay_CreditdebitDetailsScreen(AppiumDriver driver) {
		super(driver);
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		cardNumber= new Component_TextBox(card);
		expiryDate= new Component_TextBox(expiry);
		securityCode= new Component_TextBox(security);
		submitPaymentdetails = new Component_Link(done);
		wrongPaymentdetails= new Component_Textverification(oops);
		
		
		try {
			paymentDataprop=Common_Utilities.loadTestData("Testdata.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void  payemntdataentry(){
		
		cardNumber.textBoxTextEnter(paymentDataprop.getProperty("cardnumber"));
		expiryDate.textBoxTextEnter(paymentDataprop.getProperty("expirydate"));
		securityCode.textBoxTextEnter(paymentDataprop.getProperty("securitycode"));

		
	}
	
	public void submitepaymentdetails(){
		
		submitPaymentdetails.verifyLinkandClick("DONE");
	}
	
	public void wrongpaymentdetailsverification(){
		
		wrongPaymentdetails.verifyText("Oops, looks like you missed something. Please fix the problem below.");
		
	}

}
