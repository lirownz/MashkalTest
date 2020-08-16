package mashkal;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.event.InputEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class questionForm {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub


			System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron.agam\\Desktop\\Java\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			System.out.println("##  Starting test  ##");
			
			//opening Chrome web browser
			driver.get("https://webapp-front-test-mashcal.azurewebsites.net/");
			driver.manage().window().maximize();
			Thread.sleep(8000);
			System.out.println("main page has been loaded");

			//*****closing home page popup*****		
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main popup has been closed");
			Thread.sleep(2000);

			//*****Opening question help form from the home page*****		
			driver.findElement(By.cssSelector("body > div.nthelp > a")).click();
			System.out.println("main popup has been closed");
			Thread.sleep(2000);
			
			System.out.println("filling user details");
			//**fill user first name
			driver.findElement(By.id("contactUsPopupModel_FirstName")).sendKeys("TestUserFirstName");
			//**fill user last name
			driver.findElement(By.id("contactUsPopupModel_LastName")).sendKeys("TestUserLastName");
			//**fill user phone number
			driver.findElement(By.id("contactUsPopupModel_Phone")).sendKeys("0509999999");
			//**fill user email
			driver.findElement(By.id("contactUsPopupModel_Email")).sendKeys("TestUser@TestUser.com");
			
			//**picking a subject from drop down
			driver.findElement(By.id("contactUsPopupModel_Subject")).click();
			Thread.sleep(1000);
			Select subjectList = new Select(driver.findElement(By.id("contactUsPopupModel_Subject")));
			subjectList.selectByValue("info@mic.org.il");
			
			//**fill user message
			driver.findElement(By.id("contactUsPopupModel_Message")).sendKeys("Test Test Test");
			
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
