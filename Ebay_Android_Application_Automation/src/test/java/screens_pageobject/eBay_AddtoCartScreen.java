package screens_pageobject;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Component.AsserWrapper;
import Component.Component_button;
import Component.Component_textVerifyWithoutLinkClick;
import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
/***
 * Page object for Add To Cart Screen for verifications.
 * @author kdas
 *
 */
public class eBay_AddtoCartScreen extends ScreenBase{
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='NEW DEVANTI 65\" Inch Smart TV 4K UHD HDR LED LCD Slim Thin LG Screen Netflix']")
	private MobileElement productname_AddtoCartscreen;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='CHECKOUT']")
	private MobileElement checkOutButton;
	
	
	
	private Component_button checkout;
	private Component_textVerifyWithoutLinkClick addToCartProductText;

	public eBay_AddtoCartScreen(AppiumDriver driver) throws IOException {
		super(driver);
		
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	
	
	checkout= new Component_button(checkOutButton);
	addToCartProductText= new Component_textVerifyWithoutLinkClick(productname_AddtoCartscreen,"eBay_AddtoCartScreen");
	
	
		
	}
	/***
	 * Verify the text on product selected and the produt shown on Add to Card screen.
	 * @param verifyString
	 * @throws IOException 
	 */
	public  void productTextVerifyOnAddtocartScreen(String verifyString) throws IOException{
		String text = "NEW DEVANTI 65\" Inch Smart TV 4K UHD HDR LED LCD Slim Thin LG Screen Netflix";
		
		if(addToCartProductText.verifyTextWithoutLinkClick(text)){
			assertEquals(verifyString, text);
			AsserWrapper.assertTrue(verifyString, text, "ProductTextVerifyOnAddtocartScreen", "test004productDetails");
		}
		else{
			Assert.fail("Product name Text is not verified");
		}
	}
	
	public void checkoutButtonclick(String testCase) throws IOException{
		String screen = this.getClass().getSimpleName();
		
		// Add to cart screen Product name text is verfiying with Product details screen product name text
		
		checkout.verify_button_click(testCase,screen);
	}
	
	

}
