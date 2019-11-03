package featuresTest;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import common.DriverBuilder;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Main {
	public static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException {
		DriverBuilder driverBuilder = new DriverBuilder();
		driver = driverBuilder.getDriver();
		
		// Perform Register Scenario
		// User insert name and email, then click REGISTER button
		RegisterTest registerTest = new RegisterTest(driver);
		registerTest.enterFormAndClickRegister();
		
		// This action is needed to hide drawer menu and perform next action because appium can not detect drawer menu
		pressHamburgerMenu();
		// User will navigate to Route Map screen
		driver.findElement(By.id("com.bhn.krl:id/imageView2")).click();
		
		// Perform Train Position Scenario
		pressHamburgerMenu();
		if (driver.findElement(By.xpath("//android.widget.TextView[@text='Train Position']")).isDisplayed()) {
			TrainPositionTest trainPositionTest = new TrainPositionTest(driver);
		}
		
		driverBuilder.quitApp();
	}
	
	public static void pressHamburgerMenu() {
		if (driver.findElement(By.id("android:id/home")).isDisplayed()) {
			driver.findElement(By.id("android:id/home")).click();
		} else {
			driver.findElement(By.id("android:id/up")).click();
		}
	}
	
	public static void goBack() {
		driver.findElement(By.xpath("//android.widget.ImageView[contains(@resource-id,'com.bhn.krl:id/back')]")).click();
	}

}
