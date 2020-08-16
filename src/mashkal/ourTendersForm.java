package mashkal;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ourTendersForm {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub

		for (int i = 1; i < 11; i++) {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron.agam\\Desktop\\Java\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			System.out.println("##  Starting test - number: "+i+"  ##");

			//opening Chrome web browser
			driver.get("https://webapp-front-test-mashcal.azurewebsites.net/our-tenders/construction-and-infrastructure-tenders/tender-for-the-renewal-of-educational-and-public-buildings/");
			driver.manage().window().maximize();
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
			//**fill user first name
			driver.findElement(By.id("formModel_FirstName")).sendKeys("TestUserFirstName"+i);
			//**fill user last name
			driver.findElement(By.id("formModel_LastName")).sendKeys("TestUserLastName"+i);
			//**fill user email
			driver.findElement(By.id("formModel_Email")).sendKeys("TestUser"+i+"@TestUser"+i+".com");
			//**fill user phone number
			driver.findElement(By.id("formModel_Phone")).sendKeys("0501111111");
			//**fill user company name
			driver.findElement(By.id("formModel_AuctionCategory")).sendKeys("TestUserCompany"+i);
			//**fill user job
			driver.findElement(By.id("formModel_AuthorityJob")).sendKeys("TestUserJob"+i);

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
