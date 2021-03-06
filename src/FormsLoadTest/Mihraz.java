package FormsLoadTest;

import java.io.IOException;

import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import sitePagesTest.HttpResponseCode;

public class Mihraz {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		// asking for number of time to run and open the form
		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in);
		System.out.println("***** Please enter the number of round for the text to run: ");
		int round = myObj.nextInt();
		System.out.println("the Test will run: " + round + " times in a row");
		Thread.sleep(1000);


		//writing Chrome logs
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron.agam\\Desktop\\Java\\chromedriver.exe");
		System.setProperty("webdriver.chrome.logfile", "C:\\Users\\liron.agam\\Desktop\\MashcalTestsLogs\\ChromeLog.log");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



		//**** checking Http request status
		URL url = new URL("https://webapp-front-test-mashcal.azurewebsites.net/our-tenders/designing-and-maintaining-infrastructure-and-maintenance/tender-to-hedge-gates-and-security-components/");  //XXX  URL  XXX
		@SuppressWarnings("unused")
		HttpResponseCode urlPage = new HttpResponseCode(url);
		Thread.sleep(2000);

		System.out.println("##  Starting test  ##");


		//opening the Mutzar form with java script executor with FOR loop

		//opening Chrome web browser
		driver.navigate().to(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println("main page has been loaded");


		for (int i = 1; i <= round; i++) {

			System.out.println("##  Starting test - number: "+i+"  ##");

			//opening the form
			WebElement form = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div/div[1]/div[1]/div[6]/a/span[2]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", form);
			System.out.println("form number "+i+" has been opened");
			Thread.sleep(2000);

			//***** filling user details
			System.out.println("filling user number: "+i+ " details");
			Thread.sleep(1000);
			//**fill user first name
			driver.findElement(By.id("formModel_FirstName")).sendKeys("MihrazFirstName"+i);
			Thread.sleep(1000);
			//**fill user last name
			driver.findElement(By.id("formModel_LastName")).sendKeys("MihrazLastName"+i);
			Thread.sleep(1000);
			//**fill user email
			driver.findElement(By.id("formModel_Email")).sendKeys("Mihraz"+i+"@Mihraz"+i+".com");
			Thread.sleep(1000);
			//**fill user phone number
			driver.findElement(By.id("formModel_Phone")).sendKeys("0549142826");  //Uri's Phone number
			Thread.sleep(1000);
			//**fill user company name
			driver.findElement(By.id("formModel_AuctionCategory")).sendKeys("MihrazCompanyName"+i);
			Thread.sleep(1000);
			//**fill user job
			driver.findElement(By.id("formModel_AuthorityJob")).sendKeys("MihrazJob"+i);
			Thread.sleep(1000);

			//Check boxes marks
			driver.findElement(By.cssSelector("#frmRegisterNotification > div > div.row > div:nth-child(7) > div > label")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("#frmRegisterNotification > div > div.row > div:nth-child(8) > div > label")).click();
			Thread.sleep(1000);

			//**clicking form CTA to send with java script
			System.out.println("pressing on send form button");
			driver.findElement(By.cssSelector("#btnRegisterNotification > span.button_label")).click();
			Thread.sleep(1000);

			//** clicking form CTA success with java script **
			WebElement cta = driver.findElement(By.xpath("//*[@id=\"registerNotificationSuccessMessage\"]/div/a"));
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", cta);
			System.out.println("success CTA pressed");
			Thread.sleep(2000);

			System.out.println("##  ending test - number: "+i);
			driver.navigate().refresh();
			Thread.sleep(2000);

		}
		//***** closing browser *****
		driver.close();

	}
}
