package sitePagesTest;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.net.URL;

public class ourTendersForm {


	public static void main(String[] args) throws AWTException, InterruptedException, IOException {

		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in);
		System.out.println("***** Please enter the number of round for the text to run: ");
		int round = myObj.nextInt();
		System.out.println("the Test will run: " + round + " times in a row");
		Thread.sleep(1000);


		for (int i = 1; i <= round; i++) {

			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron.agam\\Desktop\\Java\\chromedriver.exe");
			System.setProperty("webdriver.chrome.logfile", "C:\\Users\\liron.agam\\Desktop\\MashcalTestsLogs\\ChromeLog.log");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



			//**** checking http request status
			URL url = new URL("https://webapp-front-test-mashcal.azurewebsites.net/");
			@SuppressWarnings("unused")
			HttpResponseCode urlPage = new HttpResponseCode(url);
			Thread.sleep(2000);


			System.out.println("##  Starting test - number: "+i+"  ##");

			//opening Chrome web browser
			driver.navigate().to(url);
			driver.manage().window().maximize();
			Thread.sleep(5000);
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

			//**** Hover through the header menu 
			driver.findElement(By.xpath("/html/body/header/nav/ul/li[4]/a")).click();
			System.out.println("dropdown opened");
			Thread.sleep(2000);

			//****redirected to the our-tenders page
			driver.findElement(By.xpath("/html/body/header/nav/ul/li[4]/ul/li[1]/a")).click();
			Thread.sleep(1000);
			System.out.println("redirected to the our-tenders page");

			//**** entering the wanted page 
			driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/a[1]/div")).click();
			Thread.sleep(1000);
			System.out.println("first page");
			driver.findElement(By.cssSelector("body > div.body > app-root > app-category-auctions > div.section.category-auctions-results-container > div > div > a:nth-child(1)")).click();
			Thread.sleep(1000);
			System.out.println("second page");

			WebElement page = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[5]/div/div/div/div[4]/a"));
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", page);
			System.out.println("third and last page");
			Thread.sleep(2000);

			//*****getting CTA text title*****		
			WebElement ctaForm = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[1]/div[1]/div[6]/a"));
			String ctaName = ctaForm.getText();
			System.out.println("name of the CTA " + ctaName);
			Thread.sleep(2000);	

			//***** opening form with java script
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", ctaForm);
			System.out.println("form number "+i+" has been opened");
			Thread.sleep(2000);	

			//***** filling user details
			System.out.println("filling user number: "+i+ " details");
			Thread.sleep(1000);
			//**fill user first name
			driver.findElement(By.id("formModel_FirstName")).sendKeys("TestUserFirstName"+i);
			Thread.sleep(1000);
			//**fill user last name
			driver.findElement(By.id("formModel_LastName")).sendKeys("TestUserLastName"+i);
			Thread.sleep(1000);
			//**fill user email
			driver.findElement(By.id("formModel_Email")).sendKeys("TestUser"+i+"@TestUser"+i+".com");
			Thread.sleep(1000);
			//**fill user phone number
			driver.findElement(By.id("formModel_Phone")).sendKeys("0501111111");
			Thread.sleep(1000);
			//**fill user company name
			driver.findElement(By.id("formModel_AuctionCategory")).sendKeys("TestUserCompany"+i);
			Thread.sleep(1000);
			//**fill user job
			driver.findElement(By.id("formModel_AuthorityJob")).sendKeys("TestUserJob"+i);
			Thread.sleep(1000);

			//**marking the Check boxes
			System.out.println("checking the checkboxes");
			driver.findElement(By.xpath("//*[@id=\"frmRegisterNotification\"]/div/div[2]/div[7]/div/label")).click();
			driver.findElement(By.xpath("//*[@id=\"frmRegisterNotification\"]/div/div[2]/div[8]/div/label")).click();
			Thread.sleep(2000);	

			//**clicking form CTA to send with java script
			System.out.println("pressing on send form button");
			driver.findElement(By.id("btnRegisterNotification")).click();
			Thread.sleep(2000);

			//***** clicking form CTA success with java script *****
			System.out.println("pressing on send form successfuly button");
			driver.findElement(By.cssSelector("#registerNotificationSuccessMessage > div > a")).click();
			Thread.sleep(2000);

			//***** closing browser *****
			driver.close();
			System.out.println("##  ending test - number: "+i+ " and closing the browser  ##");




		}


		//		//*****opening form by cordinates and mouseHover*****
		//		org.openqa.selenium.Point classname = cta.getLocation();
		//		double xcordi = classname.getX();
		//		System.out.println("Element's Position from left side X "+(int)xcordi +" pixels");
		//		double ycordi = classname.getY();
		//		System.out.println("Element's Position from top Y "+(int)ycordi +" pixels");
		//		Thread.sleep(2000);
		//		
		//		Actions builder = new Actions(driver);   
		//		builder.moveToElement(cta, (int)xcordi, (int)ycordi).click().perform();


		////*****opening form by mouseHover and location*****
		//		Actions action = new Actions(driver);
		//		WebElement we = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[1]/div[1]/div[6]/a/span[2]"));
		//		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[1]/div[1]/div[6]/a/span[2]"))).click().build().perform();


		//		//*****opening form by mouseHover and text on button*****
		//		Actions actions = new Actions(driver);
		//		WebElement menuHoverLink = driver.findElement(By.linkText(ctaName));
		//		actions.moveToElement(menuHoverLink);
		//		System.out.println("MOVED to the right location");
		//		Thread.sleep(2000);
		//		//**with single click**		
		//		actions.moveToElement(cta).click().perform();
		//		//**with double click**
		//		actions.moveToElement(cta).doubleClick().perform();	
		//		//**with double context click**
		//		actions.moveToElement(cta).contextClick(cta).perform();	

	}

}
