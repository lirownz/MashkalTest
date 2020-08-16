package mashkal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class footerContactUs {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron.agam\\Desktop\\Java\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

		//*****clicking on contact us button with java script*****
		WebElement ctaForm = driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[1]/div/ul/li[3]/a"));
		String ctaName = ctaForm.getText();
		System.out.println("name of the CTA " + ctaName);
		Thread.sleep(2000);	

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", ctaForm);
		Thread.sleep(1000);	
		System.out.println("redirecting to the contact us page");
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

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", ctaSend);
		Thread.sleep(1000);	
		System.out.println("send button has been pressed");
		Thread.sleep(1000);	
		
		
		//**clicking form CTA success with java script
		System.out.println("pressing on send form Successfuly button");
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div[2]/div[1]/div[3]")).click();
		Thread.sleep(2000);

		//***** closing browser *****
		driver.close();
		System.out.println("##  ending test and closing the browser  ###");


	}
}
