package screens_pageobject;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import Component.Component_Textverification;
import Component.Component_button;
import Component.Component_textVerifyWithoutLinkClick;
import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/***
 * Page object for Product Details Screen for verifications.
 * @author kdas
 *
 */
public class eBay_ProductDetailsScreen extends ScreenBase{
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='NEW DEVANTI 65\" Inch Smart TV 4K UHD HDR LED LCD Slim Thin LG Screen Netflix']")
	private MobileElement productDetailstext;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.ebay.mobile:id/button_add_to_cart']")
	private MobileElement addTocart;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='VIEW IN CART']")
	private MobileElement viewIncart;
	
	private Component_textVerifyWithoutLinkClick productnameondetails;
	private Component_button productAddToCart;
	private Component_button viewCart;

	public eBay_ProductDetailsScreen(AppiumDriver driver) throws IOException {
		super(driver);
	
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		productnameondetails=new Component_textVerifyWithoutLinkClick(productDetailstext,"eBay_ProductDetailsScreen");
		productAddToCart=new Component_button(addTocart);
		viewCart=new Component_button(viewIncart);
		
		
	}
	
	public String detailsscreentextWithoutLinkclik(String testcasename) throws IOException{
		String textToVerify = "NEW DEVANTI 65\" Inch Smart TV 4K UHD HDR LED LCD Slim Thin LG Screen Netflix";
		if(productnameondetails.verifyTextWithoutLinkClick(textToVerify)){
			return textToVerify;
		}
		else{
			return "";
		}
		
		
	}
	
	
	
	public void addproductAddtocart(String testCase) throws IOException{
		String screen = this.getClass().getSimpleName();
		productAddToCart.verify_button_click(testCase,screen);
		
	}
	
	public void cartViewsbutton(String testCase) throws IOException{
		String screen = this.getClass().getSimpleName();
		viewCart.verify_button_text("VIEW IN CART");
		viewCart.verify_button_click(testCase,screen);
		
	}
	
	

}
