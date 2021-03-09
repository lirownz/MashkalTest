package sitePagesTest;


import java.io.IOException;
import java.net.URL;
import java.text.Collator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class textCompering {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron.agam\\Desktop\\Java\\chromedriver.exe");
		System.setProperty("webdriver.chrome.logfile", "C:\\Users\\liron.agam\\Desktop\\MashcalTestsLogs\\ChromeLog.log");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		
		//**** checking http request status
		URL url = new URL("https://webapp-front-test-mashcal.azurewebsites.net/areas-of-activity/environmental-and-automobile-quality/garbage-disposal/");
		@SuppressWarnings("unused")
		HttpResponseCode urlPage = new HttpResponseCode(url);
		Thread.sleep(2000);
		
		System.out.println("##  Starting test  ##");

		//opening Chrome web browser
		driver.navigate().to(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println("wanted page has been loaded");

		//*** getting the text needed to be compare from site element
		WebElement textPresentOnUI = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div/div/div/p[1]/span"));
		String elementString = textPresentOnUI.getText();
		System.out.println("Presented text:  >>  " + elementString);
		Thread.sleep(2000);
		
		//*** text wanted to be compare to
		String expectedText = "העלייה ברמת החיי�? והגידול המתמיד במספר התושבי�? ברשות המקומית, דורש מענה מיטבי וחכ�? לתהליך פינוי ה�?שפה. �?נו מעמידי�? לרשותכ�? מגוון פתרונות �?שר הופכי�? �?ת מערך פינוי ה�?שפה לחכ�? ויעיל עבורכ�?, כך שהתושבי�? שלכ�? יוכלו ליהנות מ�?יכות חיי�? טובה יותר והרשות המקומית תוכל להתייעל ולחסוך בכסף. הפתרונות שלנו מספקי�? מענה כולל עבור מערכי פינוי שוני�?, תוך שיתוף פעולה ע�? ת�?גיד המחזור תמי\"ר. �?נו מציעי�? מגוון רחב של פתרונות, ביניה�?: פינוי �?שפה ע\"י רכב דחס / פינוי מכולות בשינוע / פינוי ערמות גז�? וגרוט�?ות ע“י רכבי מנוף / פינוי טמוני קרקע מפלסטיק / מתכת / פינוי פגרי�? / �?ספקת מכולות וכלי �?צירה / מערכי פינוי מופרדי�? ועוד. ";
		System.out.println("expecting text:  >>  " + expectedText);
		Thread.sleep(2000);
		
		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
        Collator collator = Collator.getInstance(Locale.ENGLISH);
        collator.setStrength(Collator.PRIMARY);
		
        //***** Comparing between the two Strings
        if (collator.compare(elementString, expectedText) == 0) {
        	System.out.println("##  PASS - Text is Equal  ##");
        } else {
        	System.out.println("##  FAIL - Text is NOT Equal  ##");
        }
        Thread.sleep(1000);
        
		//***** closing browser *****
		driver.close();
		System.out.println("##  ending test and closing the browser  ##");
		
	}
}
