package screens_pageobject;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.support.PageFactory;
import Component.Component_TextBox;
import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.Common_Utilities;


/***
 * Page object for Product Search Screen for verifications.
 * @author kdas
 *
 */
public class eBay_SearchScreen extends ScreenBase {
	
	@AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector()).scrollIntoView(text(\"NEW DEVANTI 65\" Inch Smart TV 4K UHD HDR LED LCD Slim Thin LG Screen Netflix\")))")
	public static MobileElement divantiTVselect;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Search for anything']")
	private MobileElement searchTextbox;
	
	private Component_TextBox searchText;
	private Properties testDataProp;
	
	
	

	public eBay_SearchScreen(AppiumDriver driver) {
		super(driver);
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		searchText=new Component_TextBox(searchTextbox);
		
		try {
			testDataProp=Common_Utilities.loadTestData("Testdata.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void entertextInsearchBox(){
		
		// searchText.textBoxTextEnter(testDataProp.getProperty("searchtext"));
	}

}
