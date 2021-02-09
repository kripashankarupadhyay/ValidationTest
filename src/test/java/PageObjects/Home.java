package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import base.Constant;
import base.TestBase;
import common.ReadExcel;

public class Home {

	static By loginButton = By.xpath("//a[contains(text(), 'Log In')]");
	static By userName = By.xpath("//input[@id='loginUsername']");
	static By password = By.xpath("//input[@id='loginPassword']");
	static By logInButton = By.xpath("//button[contains(text(), 'Log In')]");
	static By userLoggedin = By.xpath("//span[contains(text(),'mavdabbler')]");
	static By loggedinReddit = By.xpath("//span[@class='_1GieMuLljOrqnVpRAwz7VP']");
	static By logginMessage = By.xpath("//span[@class='_7JH6kQpO-bx66b9ajIZrz']");
	

	public static void loginReddit(WebDriver driver) {
		try {

			// Click on login button
			driver.findElement(loginButton).click();
			TestBase.waitFor(1);

			//Switch to login frame
			driver.switchTo().frame(0);
			
			// Enter UserName
			//System.out.println(ReadExcel.getCellData(Constant.TestCase, Constant.Username));
			driver.findElement(userName).click();
			driver.findElement(userName).sendKeys(ReadExcel.getCellData(Constant.TestCase, Constant.Username));
			TestBase.waitFor(1);
			
			// Enter password
			driver.findElement(password).click();
			driver.findElement(password).sendKeys(ReadExcel.getCellData(Constant.TestCase, Constant.Password));
			TestBase.waitFor(1);

			// Click on LogIn button
			driver.findElement(logInButton).click();
			TestBase.waitFor(10);
			
			Assert.assertEquals(driver.findElement(logginMessage).getText(), "Successfully logged in!");
			System.out.println("Successfully logged in!");
			Assert.assertEquals(driver.findElement(userLoggedin).getText(), "mavdabbler");
			System.out.println("User Verified");
			Assert.assertEquals(driver.getTitle(), "For the Mavericks Dudes and Dudettes");
			System.out.println("Login PageTitle Verified");


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
