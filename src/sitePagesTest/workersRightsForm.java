package sitePagesTest;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class workersRightsForm {

	//private static HttpURLConnection connection;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron.agam\\Desktop\\Java\\chromedriver.exe");
		System.setProperty("webdriver.chrome.logfile", "C:\\Users\\liron.agam\\Desktop\\MashcalTestsLogs\\ChromeLog.log");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//**** checking http request status
		//URL url = new URL("https://webapp-front-test-mashcal.azurewebsites.net/");
		URL url = new URL("https://webapp-front-test-mashcal.azurewebsites.net/");
		@SuppressWarnings("unused")
		HttpResponseCode urlPage = new HttpResponseCode(url);
		Thread.sleep(2000);
	
		
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


		//***** opening Hamburger menu*****
		driver.findElement(By.xpath("/html/body/header/nav/label/span")).click();
		Thread.sleep(2000);
		
		//clicking on workers rights button
		driver.findElement(By.xpath("/html/body/header/nav/div[4]/ul/li[4]/ul/li[3]/a/span")).click();
		System.out.println("redirecting to workers right page");
		Thread.sleep(2000);

		//opening workers rights form
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div/div/div/div/a")).click();
		Thread.sleep(2000);


		System.out.println("filling user details");
		//**fill user first name
		driver.findElement(By.id("workersRightsModel_FirstName")).sendKeys("TestUserFirstName");
		Thread.sleep(1000);
		//**fill user last name
		driver.findElement(By.id("workersRightsModel_LastName")).sendKeys("TestUserLastName");
		Thread.sleep(1000);
		//**fill user last name
		driver.findElement(By.id("workersRightsModel_IdNumber")).sendKeys("1234567891012");
		Thread.sleep(1000);
		//**fill user email
		driver.findElement(By.id("workersRightsModel_Email")).sendKeys("TestUser@TestUser.com");
		Thread.sleep(1000);
		//**fill user phone number
		driver.findElement(By.id("workersRightsModel_Phone")).sendKeys("0509999999");
		Thread.sleep(1000);
		
		//**Pick user checkbox
		driver.findElement(By.cssSelector("#formActivity > div.form-inner > div.row > div:nth-child(6) > div > button > span")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#formActivity > div.form-inner > div.row > div:nth-child(6) > div > ul > li:nth-child(2) > a")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#formActivity > div.form-inner > div.row > div:nth-child(6) > div > ul > li:nth-child(3) > a")).click();
		driver.findElement(By.cssSelector("#formActivity > div.form-inner > div.row > div:nth-child(6) > div > button > span")).click();
		Thread.sleep(1000);
		
		//**fill user message
		driver.findElement(By.id("workersRightsModel_Message")).sendKeys("Test Test Test");
		Thread.sleep(1000);
		
		//**Choose file 
		//****** need to put new file director for each test
		WebElement file = driver.findElement(By.id("workersRightsModel_File1"));
		file.sendKeys("C:\\Users\\liron.agam\\Downloads\\dikor.png");
		Thread.sleep(1000);
		
		//pressing the CTA send form
		WebElement sendCTAElement = driver.findElement(By.cssSelector("#formActivity > div.form-inner > div.submit-with-margin.col-sm-12 > button > span"));
		sendCTAElement.click();
		//String sendCTA = sendCTAElement
		
		//**clicking form CTA success with java script
		System.out.println("pressing on send form Successfuly button");
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div/form/div[2]/div[3]/a")).click();
		Thread.sleep(2000);

		//***** closing browser *****
		driver.close();
		System.out.println("##  ending test and closing the browser  ###");
	}

}
