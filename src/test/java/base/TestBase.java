package base;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.ReadExcel;

public class TestBase

{
	static WebDriver driver = null;
	static WebDriverWait wait;
	static int i = 0;

	public static void loadlog4J() {
		String log4jConfPath = System.getProperty("user.dir") + "\\log4j.xml";
		PropertyConfigurator.configure(log4jConfPath);
	}

	public static WebDriver OpenBrowser(String browser, String sheet) {

		String url = base.Constant.URLUA;

		try {
			if (browser.equals("chrome")) {
				TestBase.loadlog4J();
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\drivers\\chromedriver1.exe");
				driver = new ChromeDriver(options);
				driver.get(url);
				TestBase.waitFor(2);
				driver.manage().window().maximize();
				Actions action = new Actions(driver);
				action.sendKeys(Keys.ESCAPE).build().perform();
				
				  
				 
				//options.addArguments("--disable-notifications");
				System.out.println("open browser Successfully !");
				// use excel file
				ReadExcel.setExcelFile(base.Constant.Path_TestData + base.Constant.File_TestData, sheet);

			}
			if (browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.get(url);
				driver.manage().window().maximize();
				TestBase.waitFor(2);
				System.out.println("open browser Successfully !");
				// use excel file
				ReadExcel.setExcelFile(base.Constant.Path_TestData + base.Constant.File_TestData, sheet);
			}
		}

		catch (Exception e) {
			System.out.println("Problem in open browser !");
			e.printStackTrace();

		}

		return driver;

	}

	public static WebDriverWait WaitTime(WebDriver driver) {
		try {
			wait = new WebDriverWait(driver, 20);
		} catch (Exception e) {
			System.out.println("Problem in WebDriverWait !");
			e.printStackTrace();
		}

		return wait;
	}

	public static void implicitTime(int t, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(t, TimeUnit.SECONDS);

	}

	public WebDriver getDriver() {
		return null;
	}

	public static boolean waitFor(int iSeconds) {
		try {
			Thread.sleep(iSeconds * 1000);
		} catch (Exception e) {
			System.out.println("Not able to Wait --- " + e.getMessage());
			return false;
		}
		return true;
	}

}