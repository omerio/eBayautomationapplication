package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;



/*  This class we are using to define the Android capabilities to invoke Android emulator, also we are Initiating the Appium driver to invoke the driver*/
public class Common_Utilities {
	
	public static Properties prop=new Properties();
	public static Properties testData=new Properties();
	public static Properties testDatapageobj=new Properties();
	public static DesiredCapabilities cap = new DesiredCapabilities();
	public static AppiumDriver driver;

	
	public static void loadconfigproperties(String propertyfilename) throws IOException{
		
		/*-------Loading the properties file--------*/
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/properties/"+propertyfilename);
		prop.load(fis);
		
		String platform_name = prop.getProperty("platform.name");
		
		if(platform_name.equals("android")){
			
			Androidcapabilities();
			
		}
	}
	
public static Properties loadTestData(String propertyfilename) throws IOException{
		
		/*-------Loading the properties file--------*/
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/properties/"+propertyfilename);
		testData.load(fis);
		return testData;
	}

public static Properties loadPgaeObjectsdata(String propertyfilename){
	
	/*-------Loading the properties file--------*/
	try {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/properties/"+propertyfilename);
		testDatapageobj.load(fis);
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return testDatapageobj;
}
	
	

public static void Androidcapabilities(){
	
	cap.setCapability("deviceName", prop.getProperty("device.name"));
	cap.setCapability("platformName", prop.getProperty("platform.name"));
	Common_Utilities.log("/-----Log for Android Capabilities-----/");
	System.out.println("*******************");
	System.out.println(prop.getProperty("platform.name"));
	Common_Utilities.log("/-----Log for Android Capabilities-----/");
	System.out.println("*******************");
	/*----Screen rotation handled---*/
	cap.setCapability("deviceOrientation", prop.getProperty("device.orientation"));
	cap.setCapability("platormVersion", prop.getProperty("platform.version"));
	cap.setCapability("noReset", true);
	cap.setCapability("fullreset", false);
	cap.setCapability("NewCommandTimeOut", 60);
	cap.setCapability("app", "Users/kdas/Documents/workspace/Ebay_Android_Application_Automation/src/test/java/eBay.apk");
	//cap.setCapability("app", "Users/kdas/Documents/workspace/Ebay_Android_Application_Automation/src/test/java/Flipkart.apk");
	
	
	
}

public static void log(String message){
	Logger log = Logger.getLogger(Common_Utilities.class);
	log.debug(message);
}

public static AppiumDriver getDriver() throws MalformedURLException{
	
	//driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	return driver;
	
	
}

}
