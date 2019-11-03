package featuresTest;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TrainPositionTest {
	
public static AndroidDriver<MobileElement> driver;

	public TrainPositionTest(AndroidDriver<MobileElement> driver) {
		Main main = new Main();
		this.driver = driver;
		goToTrainPOsitionPage();
		
		// If user in Train Position landing screen
		if (driver.findElement(By.id("com.bhn.krl:id/select_stasiun")).isDisplayed()) {
			// This action will open Station List
			openStationList();
			
			// When Station List is displayed
			selectStationByClick(Constant.BOJONGGEDE_STATION);
			main.goBack();
			selectStationByType(Constant.CITAYAM_STATION);
			main.goBack();
			main.goBack();
		}
		
		System.out.println("---------> TRAIN POSITION TEST IS SUCCESSED <-----------");
	}
	
	/**
	 * Method to navigate to Train Position screen
	 */
	private static void goToTrainPOsitionPage() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Train Position']")).click();
		System.out.println("GO TO TRAIN POSITION SCREEN...");
		
		if (driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'android:id/button1') and @text='Allow']")).isDisplayed()) {
			driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'android:id/button1') and @text='Allow']")).click();
		}
	}
	
	/**
	 * Method to open station list
	 */
	private static void openStationList() {
		driver.findElement(By.id("com.bhn.krl:id/select_stasiun")).click();
	}
	
	/**
	 * Method for action click on one of station list item
	 */
	private static void selectStationByClick(String stationName) {
		String xPathName = "//android.widget.TextView[contains(@resource-id,'com.bhn.krl:id/fill_stasiun') and @text='%s']";
		String xPath = xPathName.replace("%s", stationName);
		driver.findElement(By.xpath(xPath)).click();
		System.out.println("USER CLICK ON " + stationName + " ITEM");
	}
	
	/**
	 * Method to perform action type a station name in textfield
	 * Then click on one of station list
	 * @param stationName
	 */
	private static void selectStationByType(String stationName) {
		driver.findElement(By.id("com.bhn.krl:id/img_auto_stasiun")).click();
		driver.findElement(By.id("com.bhn.krl:id/img_auto_stasiun")).sendKeys(stationName);
		System.out.println("USER TYPE " + stationName + " STATION IN THE TEXTFIELD");
		selectStationByClick(stationName);
	}
}
