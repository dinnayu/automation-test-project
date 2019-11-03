package common;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class DriverBuilder {
	private static String DEVICE_ID = "S8W8QCTCAA9SSCMV";
	private static String APK_NAME = "KRLAccess.apk";
	private static String APP_PACKAGE = "com.bhn.krl";
	private static String HOME_ACTIVITY = "com.bhn.krl.Splash";
	
	public static AndroidDriver<MobileElement> driver;
	
	public DriverBuilder() throws MalformedURLException {
		System.out.println("DRIVER BUILDER");
		setUp();
	}
	
	public void setUp() throws MalformedURLException {
		System.out.println("SET UP");
		File appDir = new File(System.getProperty("user.dir")+"/app/");
		File app = new File(appDir, APK_NAME);
		
		DesiredCapabilities dc = new DesiredCapabilities();
		//Device information
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "OPPO F11 PRO");
		dc.setCapability(MobileCapabilityType.UDID, DEVICE_ID);
		
		//App information
		dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		dc.setCapability("appPackage", APP_PACKAGE);
		dc.setCapability("appActivity", HOME_ACTIVITY);
		System.out.println(dc);
		
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static AndroidDriver<MobileElement> getDriver(){
		System.out.println(driver);
		return driver;
	}
	
	public static void quitApp() {
		driver.quit();
		System.out.println("ALL TEST IS COMPLETED");
	}
}
