package Component;



import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import utilities.Common_Utilities;

public class Component_scroll {

   private MobileElement element;
	
	public Component_scroll(MobileElement element){
		this.element=element;
	}
	
	
	/* Scroll to from bottom to top of the screen*/
	
	public static void scroll(){
		
		
		Dimension size = Common_Utilities.driver.manage().window().getSize();
//		Double scrollheightstrt  = size.getHeight() * 0.5;
//		int scrollstrt = scrollheightstrt.intValue();
//		
//		Double scrollheightend  = size.getHeight() * 1.0;
//		int scrollend = scrollheightend.intValue();
		
//		TouchAction t = new TouchAction(Common_Utilities.driver);
//		t.press(PointOption.point(0, scrollstrt)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
//		.moveTo(PointOption.point(0, scrollend)).release().perform();
//	
		
		TouchAction action = new TouchAction(Common_Utilities.driver);
	    action.press(PointOption.point(18, 1013)).moveTo(PointOption.point(18, 1440)).release().perform();
	}
}
