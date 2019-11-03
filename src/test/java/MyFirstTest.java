import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import junit.framework.Assert;

public class MyFirstTest {
	private static String DEVICE_ID = "S8W8QCTCAA9SSCMV";

	public static void main(String[] args) throws MalformedURLException {
		File appDir = new File(System.getProperty("user.dir")+"/app/");
		File app = new File(appDir, "KRLAccess.apk");
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		//Device information
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "OPPO F11 PRO");
		dc.setCapability(MobileCapabilityType.UDID, DEVICE_ID);
		
		//App information
		dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		dc.setCapability("appPackage", "com.bhn.krl");
		dc.setCapability("appActivity", "com.bhn.krl.Splash");
		System.out.println(dc);
		
		AndroidDriver<MobileElement> driver =new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.quit();
		System.out.println("TEST IS SUCCESSFULL");
	}

}
