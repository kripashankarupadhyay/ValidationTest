package PageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import base.Constant;
import base.TestBase;
import common.ReadExcel;

public class ValidateSubreddits {
	
	static By searchButton = By.xpath("//button[@class='h-jI8r2f9ozTNqu_2TBeY']");
	static By searchtext = By.xpath("//input[@class='_37tmRmxaFMjRRrvwcY2JmY']");
	static By searchsubreddit = By.xpath("//span[contains(text(),'r/MavericksDnD')]");
	static By inputcreatePost = By.xpath("//input[@class='zgT5MfUrDMC54cpiCpZFu']");
	static By enterTitle = By.xpath("//textarea[@class='PqYQ3WC15KaceZuKcFI02 _1ec_Oj5SWdypd8L-VELKg- ']");
	static By enterText = By.xpath("//div[@class='notranslate public-DraftEditor-content']");
	static By clickPost = By.xpath("(//button[contains(text(),'Post')])[2]");
	static By enterComment = By.xpath("//div[@class='_3LuG0YVLLHE2azRNVaKz7O']");
	static By validatecomment = By.xpath("(//p[@class='_1qeIAgB0cPwnLhDF9XSiJM'])[2]");
	static By validatesubreddits = By.xpath("(//p[@class='_1qeIAgB0cPwnLhDF9XSiJM']/../parent::div//parent::div//div[@class='_2mHuuvyV9doV3zwbZPtIPG'])[1]");
	static By upvoteButton = By.xpath("(//i[@class='icon icon-upvote _2Jxk822qXs4DaXwsN7yyHA'])[2]");
	static By downvoteButton = By.xpath("(//i[@class='icon icon-downvote ZyxIIl4FP5gHGrJDzNpUC'])[2]");
	static By logoutlink = By.xpath("//span[@id='email-collection-tooltip-id']");
	static By logoutButton = By.xpath("//div[contains(text(),'Log Out')]");
	
	
	static By buttonComment = By.xpath("//button[contains(text(),'Comment')]");
	
	
	public static void validationofSubreddits(WebDriver driver) 
	{
	try {

		// Click on search tab
		driver.findElement(searchButton).click();
		TestBase.waitFor(1);
		
		//Search the Sub_reddit value
		driver.findElement(searchtext).sendKeys(ReadExcel.getCellData(Constant.TestCase, Constant.Subreddits));
		TestBase.waitFor(1);
		
		// Search the mavericks subreddits
		driver.findElement(searchsubreddit).click();
		TestBase.waitFor(2);
		
		//input the create post
		driver.findElement(inputcreatePost).click();
		TestBase.waitFor(2);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH.mm aa");
		Date date = new Date();
		String currentdate = dateFormat.format(date);
		System.out.println(dateFormat.format(date));
		
		//enter the current date as title
		driver.findElement(enterTitle).sendKeys(currentdate);
		TestBase.waitFor(2);
		
		//enter the text as optional value 
		driver.findElement(enterText).sendKeys(currentdate);
		TestBase.waitFor(2);
		
		//Click on post button
		driver.findElement(clickPost).click();
		TestBase.waitFor(5);
		
		//enter the comment
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='_3LuG0YVLLHE2azRNVaKz7O']")));
		actions.click();
		actions.sendKeys(currentdate +  " kripa ");
		actions.build().perform();
		
		driver.findElement(buttonComment).click();
		TestBase.waitFor(1);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
				
		
		String commentupdated = driver.findElement(validatecomment).getText();
		//Assert.assertEquals(commentupdated, currentdate +  " kripa ");
		TestBase.waitFor(5);
		
		//js.executeScript("window.scrollBy(0,0)");
		//TestBase.waitFor(1);
			/*
			 * driver.findElement(validatesubreddits).click(); TestBase.waitFor(1);
			 */
		
		driver.findElement(upvoteButton).click();
		TestBase.waitFor(5);
		driver.findElement(downvoteButton).click();
		TestBase.waitFor(2);
		
		driver.findElement(logoutlink).click();
		TestBase.waitFor(2);
		
		driver.findElement(logoutButton).click();
		TestBase.waitFor(2);
		
		
		} catch (Exception e) 
		{
		e.printStackTrace();
		}
	
	}
}


