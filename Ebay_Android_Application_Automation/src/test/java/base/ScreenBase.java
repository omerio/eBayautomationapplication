package base;

import io.appium.java_client.AppiumDriver;



/*Here we are initiating the APpium Driver*/
public class ScreenBase {
	
	protected  AppiumDriver driver;
	
	public ScreenBase(AppiumDriver driver){ 
		this.driver=driver;
		

	}
}
