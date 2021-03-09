package testSanityTests;

import java.io.IOException;
import java.net.URL;
import java.text.Collator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import sitePagesTest.HttpResponseCode;

public class testFooterSanity {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron.agam\\Desktop\\Automation-Selenium\\chromedriver.exe");
		System.setProperty("webdriver.chrome.logfile", "C:\\Users\\liron.agam\\Desktop\\MashcalTestsLogs\\ChromeLog.log");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


		//**** checking http request status
		URL url = new URL("https://webapp-front-test-mashcal.azurewebsites.net/");
		@SuppressWarnings("unused")
		HttpResponseCode urlPage = new HttpResponseCode(url);
		Thread.sleep(2000);


		System.out.println("##  Starting test  ##");

		//opening Chrome web browser
		driver.navigate().to(url);
		driver.manage().window().maximize();
		Thread.sleep(8000);
		System.out.println("main page has been loaded");

		//*****closing home page popup*****	
		try {
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main Info popup has been closed");
		}
		catch (Exception e) {
			System.out.println("no Info Popup");
		}
		Thread.sleep(2000);


		//***** Contact US *****//
		//*****clicking on contact us button with java script*****
		WebElement contactUS = driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[1]/div/ul/li[3]/a"));
		JavascriptExecutor cuJS = (JavascriptExecutor) driver;
		cuJS.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", contactUS);
		Thread.sleep(1000);	
		System.out.println("redirecting to the Contact US page");
		Thread.sleep(1000);	

		WebElement contactUSTitlElement = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/h1"));
		String titleCUString = contactUSTitlElement.getText();
		System.out.println(titleCUString);
		Thread.sleep(1000);	
		
		//*** text wanted to be compare to
		String expectedText = "צרו קשר";
		System.out.println(expectedText);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator collator1 = Collator.getInstance(Locale.ENGLISH);
		collator1.setStrength(Collator.PRIMARY);

		//***** Comparing between the two Strings
		if (collator1.compare(titleCUString, expectedText) == 0) {
			System.out.println("##  PASS - page Title is Equal  ##");
		} else {
			System.out.println("##  FAIL - page Title is NOT Equal  ##");
		}
		Thread.sleep(1000);

		//***** filling user details *****
		System.out.println("filling user details");
		//**fill user company name
		driver.findElement(By.id("contactUsModel_ReshutName")).sendKeys("TestCompanyName");
		Thread.sleep(1000);	
		//**fill user job title
		driver.findElement(By.id("contactUsModel_Reshutjob")).sendKeys("TestUserJob");
		Thread.sleep(1000);	
		//**fill user first name
		driver.findElement(By.id("contactUsModel_FirstName")).sendKeys("TestUserFirstName");
		Thread.sleep(1000);	
		//**fill user last name
		driver.findElement(By.id("contactUsModel_LastName")).sendKeys("TestUserLastName");
		Thread.sleep(1000);	

		//**fill user email
		driver.findElement(By.id("contactUsModel_Email")).sendKeys("TestUser@TestUser.com");
		//**fill user phone number
		driver.findElement(By.id("contactUsModel_Phone")).sendKeys("0509999999");
		//**fill user message
		driver.findElement(By.id("contactUsModel_Message")).sendKeys("Test Test Test");
		Thread.sleep(2000);	

		//**picking a subject from drop down with JS
		driver.findElement(By.xpath("//*[@id=\"formContactUs\"]/div/div[1]/div[5]")).click();
		Thread.sleep(1000);	
		driver.findElement(By.xpath("//*[@id=\"contactUsModel_Subject\"]/option[2]")).click();	
		Thread.sleep(1000);	

		//pressing the CTA send form with JS
		WebElement ctaSend = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div/form/div/div[2]/button"));
		String ctaSendName = ctaSend.getText();
		System.out.println("name of the CTA " + ctaSendName);
		Thread.sleep(2000);	

		JavascriptExecutor sendJS = (JavascriptExecutor) driver;
		sendJS.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", ctaSend);
		Thread.sleep(1000);	
		System.out.println("send button has been pressed");
		Thread.sleep(1000);	

		//**clicking form CTA success with java script
		System.out.println("pressing on send form Successfuly button");
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div[2]/div[1]/div[3]")).click();
		Thread.sleep(2000);


		//***** Accessibility *****//
		//*****clicking on contact us button with java script*****
		WebElement accessibility = driver.findElement(By.xpath("/html/body/div[8]/div/div/div/div[1]/div/ul/li[1]/a"));
		JavascriptExecutor accJS = (JavascriptExecutor) driver;
		accJS.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", accessibility);
		Thread.sleep(1000);	
		System.out.println("redirecting to the Accessibility page");
		Thread.sleep(1000);	

		WebElement accessibilityTitle = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/h1"));
		String accessibilityTitleString = accessibilityTitle.getText();
		System.out.println(accessibilityTitleString);
		Thread.sleep(1000);	
		
		//*** text wanted to be compare to
		String expectedText2 = "נגישות";
		System.out.println(expectedText2);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator collator2 = Collator.getInstance(Locale.ENGLISH);
		collator2.setStrength(Collator.PRIMARY);

		//***** Comparing between the two Strings
		if (collator2.compare(accessibilityTitleString, expectedText2) == 0) {
			System.out.println("##  PASS - page Title is Equal  ##");
		} else {
			System.out.println("##  FAIL - page Title is NOT Equal  ##");
		}
		Thread.sleep(1000);

		//***** Terms Of Service *****//
		//*****clicking on contact us button with java script*****
		WebElement termsOfService = driver.findElement(By.xpath("/html/body/div[8]/div/div/div/div[1]/div/ul/li[2]/a"));
		JavascriptExecutor tosJS = (JavascriptExecutor) driver;
		tosJS.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", termsOfService);
		Thread.sleep(1000);	
		System.out.println("redirecting to the Terms Of Service page");
		Thread.sleep(1000);	

		WebElement termsOfServiceTitle = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/h1"));
		String termsOfServiceTitleString = termsOfServiceTitle.getText();
		System.out.println(termsOfServiceTitleString);
		Thread.sleep(1000);	
		
		//*** text wanted to be compare to
		String expectedText3 = "תנאי שימוש";
		System.out.println(expectedText3);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator collator3 = Collator.getInstance(Locale.ENGLISH);
		collator3.setStrength(Collator.PRIMARY);

		//***** Comparing between the two Strings
		if (collator3.compare(termsOfServiceTitleString, expectedText3) == 0) {
			System.out.println("##  PASS - page Title is Equal  ##");
		} else {
			System.out.println("##  FAIL - page Title is NOT Equal  ##");
		}
		Thread.sleep(1000);


		//***** Future Connections *****//
		//*****clicking on contact us button with java script*****
		WebElement futureConnections = driver.findElement(By.xpath("/html/body/div[8]/div/div/div/div[1]/div/ul/li[4]/a"));
		JavascriptExecutor fcJS = (JavascriptExecutor) driver;
		fcJS.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", futureConnections);
		Thread.sleep(1000);	
		System.out.println("redirecting to the Future Connections page");
		Thread.sleep(1000);	

		WebElement futureConnectionsTitle = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/h1"));
		String futureConnectionsTitleString = futureConnectionsTitle.getText();
		System.out.println(futureConnectionsTitleString);
		Thread.sleep(1000);	
		
		//*** text wanted to be compare to
		String expectedText4 = "התקשרויות עתידיות";
		System.out.println(expectedText4);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator collator4 = Collator.getInstance(Locale.ENGLISH);
		collator4.setStrength(Collator.PRIMARY);

		//***** Comparing between the two Strings
		if (collator4.compare(futureConnectionsTitleString, expectedText4) == 0) {
			System.out.println("##  PASS - page Title is Equal  ##");
		} else {
			System.out.println("##  FAIL - page Title is NOT Equal  ##");
		}
		Thread.sleep(1000);


		//***** Qualities *****//
		//*****clicking on contact us button with java script*****
		WebElement qualities = driver.findElement(By.xpath("/html/body/div[8]/div/div/div/div[2]/div/span/a"));
		JavascriptExecutor qualitiesJS = (JavascriptExecutor) driver;
		qualitiesJS.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", qualities);
		Thread.sleep(1000);	
		System.out.println("redirecting to the Qualities page");
		Thread.sleep(1000);	

		WebElement qualitiesTitle = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/h1"));
		String qualitiesTitleString = qualitiesTitle.getText();
		System.out.println(qualitiesTitleString);
		Thread.sleep(1000);	
		
		//*** text wanted to be compare to
		String expectedText5 = "תקני איכות";
		System.out.println(expectedText5);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator collator5 = Collator.getInstance(Locale.ENGLISH);
		collator5.setStrength(Collator.PRIMARY);

		//***** Comparing between the two Strings
		if (collator5.compare(qualitiesTitleString, expectedText5) == 0) {
			System.out.println("##  PASS - page Title is Equal  ##");
		} else {
			System.out.println("##  FAIL - page Title is NOT Equal  ##");
		}
		Thread.sleep(1000);


		//***** closing browser *****
		driver.close();
		System.out.println("##  ending test and closing the browser  ###");

	}

}
