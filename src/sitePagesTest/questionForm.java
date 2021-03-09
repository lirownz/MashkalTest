package sitePagesTest;

import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;


public class questionForm {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		// TODO Auto-generated method stub


			System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron.agam\\Desktop\\Java\\chromedriver.exe");
			System.setProperty("webdriver.chrome.logfile", "C:\\Users\\liron.agam\\Desktop\\MashcalTestsLogs\\ChromeLog.log");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			

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

			//*****Opening question help form from the home page*****		
			driver.findElement(By.cssSelector("body > div.nthelp > a")).click();
			System.out.println("main popup has been closed");
			Thread.sleep(1000);
			
			System.out.println("filling user details");
			//**fill user first name
			driver.findElement(By.id("contactUsPopupModel_FirstName")).sendKeys("TestUserFirstName");
			Thread.sleep(1000);
			//**fill user last name
			driver.findElement(By.id("contactUsPopupModel_LastName")).sendKeys("TestUserLastName");
			Thread.sleep(1000);
			//**fill user phone number
			driver.findElement(By.id("contactUsPopupModel_Phone")).sendKeys("0509999999");
			Thread.sleep(1000);
			//**fill user email
			driver.findElement(By.id("contactUsPopupModel_Email")).sendKeys("TestUser@TestUser.com");
			Thread.sleep(1000);
			
			//**picking a subject from drop down
			driver.findElement(By.id("contactUsPopupModel_Subject")).click();
			Thread.sleep(1000);
			Select subjectList = new Select(driver.findElement(By.id("contactUsPopupModel_Subject")));
			subjectList.selectByValue("info@mic.org.il");
			Thread.sleep(1000);
			
			//**fill user message
			driver.findElement(By.id("contactUsPopupModel_Message")).sendKeys("Test Test Test");
			Thread.sleep(1000);
			
			//pressing the CTA send form
			driver.findElement(By.cssSelector("#formContactUsPopUp > div > button")).click();
			//**clicking form CTA success with java script
			System.out.println("pressing on send form successfuly button");
			driver.findElement(By.cssSelector("#popup-thanks > div.popup-thanks-btn.button-wrap > a")).click();
			Thread.sleep(2000);

			//***** closing browser *****
			//driver.close();
			System.out.println("##  ending test and closing the browser  ###");
		}

}
