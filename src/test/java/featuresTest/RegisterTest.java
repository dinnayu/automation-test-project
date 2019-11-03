package featuresTest;

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

public class RegisterTest {
	public static AndroidDriver<MobileElement> driver;
	
	public RegisterTest(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public static void enterFormAndClickRegister() {
		driver.findElement(By.id("com.bhn.krl:id/edit_name")).sendKeys("Automation Test");
		driver.findElement(By.id("com.bhn.krl:id/edit_email")).sendKeys("automationtest@gmail.com");
		driver.findElement(By.id("com.bhn.krl:id/button1")).click();
		System.out.println("---------> REGISTER TEST IS SUCCESSED <-----------");
	}
}
