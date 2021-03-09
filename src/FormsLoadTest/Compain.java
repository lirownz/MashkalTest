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

public class Compain {

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
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron.agam\\Desktop\\Automation-Selenium\\chromedriver.exe");
		System.setProperty("webdriver.chrome.logfile", "C:\\Users\\liron.agam\\Desktop\\MashcalTestsLogs\\ChromeLog.log");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



		//**** checking Http request status
		URL url = new URL("https://webapp-front-test-mashcal.azurewebsites.net/");  //XXX  URL  XXX
		@SuppressWarnings("unused")
		HttpResponseCode urlPage = new HttpResponseCode(url);
		Thread.sleep(2000);

		System.out.println("##  Starting test  ##");


		//opening the Campaign form with java script executor with FOR loop
		for (int i = 1; i <= round; i++) {

			//opening Chrome web browser
			driver.navigate().to(url);
			//driver.manage().window().maximize();
			Thread.sleep(5000);
			System.out.println("Loading the Campaign Sheet form");	

			//***** filling user details
			System.out.println("filling Test Campaign number: "+i+ " details");
			Thread.sleep(1000);
			//**fill user first name
			driver.findElement(By.id("stayUpdateModel_FirstName")).sendKeys("TestCampaignFirstName"+i);
			Thread.sleep(1000);
			//**fill user last name
			driver.findElement(By.id("stayUpdateModel_LastName")).sendKeys("TestCampaignLastName"+i);
			Thread.sleep(1000);
			//**fill user reshut name
			driver.findElement(By.id("stayUpdateModel_ReshutName")).sendKeys("TestCampaignReshutName"+i);
			Thread.sleep(1000);
			//**fill user job
			driver.findElement(By.id("stayUpdateModel_Reshutjob")).sendKeys("TestCampaignJobr"+i);
			Thread.sleep(1000);
			//**fill user email
			driver.findElement(By.id("stayUpdateModel_Email")).sendKeys("TestCampaign"+i+"@TestCampaign"+i+".com");
			Thread.sleep(1000);
			//**fill user phone
			driver.findElement(By.id("stayUpdateModel_Phone")).sendKeys("0549142826");
			Thread.sleep(1000);
			//**clicking form send CTA
			System.out.println("pressing on send form button");
			driver.findElement(By.xpath("//*[@id=\"formStayUpdate\"]/div[3]/input")).click();
			Thread.sleep(2000);

			//***** clicking form CTA success with java script *****
			WebElement cta = driver.findElement(By.xpath("//*[@id=\"popup-thanks\"]/div[3]/a"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", cta);
			System.out.println("pressing on send form successfuly button");
			Thread.sleep(2000);



			System.out.println("##  ending test - number: "+i);
			driver.navigate().refresh();
			Thread.sleep(2000);


		}

		//***** closing browser *****
		driver.close();

	}

}






