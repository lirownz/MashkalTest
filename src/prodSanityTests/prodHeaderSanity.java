package prodSanityTests;

import java.io.IOException;
import java.net.URL;
import java.sql.Driver;
import java.text.Collator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import sitePagesTest.HttpResponseCode;

public class prodHeaderSanity {

	public static void main(String[] args) throws InterruptedException, IOException {


		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron.agam\\Desktop\\Java\\chromedriver.exe");
		System.setProperty("webdriver.chrome.logfile", "C:\\Users\\liron.agam\\Desktop\\MashcalTestsLogs\\ChromeLog.log");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



		//**** checking http request status
		URL url = new URL("https://www.mashcal.co.il/");
		@SuppressWarnings("unused")
		HttpResponseCode urlPage = new HttpResponseCode(url);
		Thread.sleep(2000);


		System.out.println("##  Starting test  ##");

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

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//**** clicking on first Header title link page
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/a")).click();
		System.out.println("moving to Areas of activity page");
		Thread.sleep(2000);

		//****title comparing
		WebElement aoaPageTitle = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/h1"));
		String aoaTitleString = aoaPageTitle.getText();
		aoaPageTitle.click();
		Thread.sleep(1000);
		System.out.println(aoaTitleString);

		//*** text wanted to be compare to
		String expectedTitle = "תחומי הפעילות שלנו";
		System.out.println(expectedTitle);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator aoaCollator = Collator.getInstance(Locale.ENGLISH);
		aoaCollator.setStrength(Collator.PRIMARY);

		//***** Comparing between the two Strings
		if (aoaCollator.compare(aoaTitleString, expectedTitle) == 0) {
			System.out.println("##  PASS - page Title is Equal  ##");
		} else {
			System.out.println("##  FAIL - page Title is NOT Equal  ##");
		}
		Thread.sleep(1000);

		////////////Construction & Infrastructure page 1
		//***** moving back to home page (site symbol clicking)
		driver.findElement(By.xpath("/html/body/header/nav/div/a/img")).click();
		System.out.println("redirecting back to home page");
		Thread.sleep(3000);

		//*****closing home page popup*****	
		try {
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main Info popup has been closed");
		}
		catch (Exception e) {
			System.out.println("no Info Popup");
		}
		Thread.sleep(2000);

		//*** Hover through the 1st header menu 
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/a")).click();
		System.out.println("Areas of activity drop down opened");
		Thread.sleep(2000);		

		//*** Areas of activity dropdown -  clicking on "Construction & Infrastructure"  	
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/ul/li[1]/a")).click();
		System.out.println("clicking on Construction & Infrastructure in dropdown");
		Thread.sleep(2000);

		//**** Construction & Infrastructure URL comparing
		String pageUrlString2 = driver.getCurrentUrl();
		System.out.println(pageUrlString2);

		//*** text wanted to be compare to
		String expectedURL2 = "https://www.mashcal.co.il/areas-of-activity/?categoryId=2424";
		System.out.println(expectedURL2);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator insuranceCollator2 = Collator.getInstance(Locale.ENGLISH);
		insuranceCollator2.setStrength(Collator.PRIMARY);

		//***** Comparing between the two StringsexpectedURL
		if (insuranceCollator2.compare(pageUrlString2, expectedURL2) == 0) {
			System.out.println("##  PASS - page URL is Equal  ##");
			System.out.println("Construction & Infrastructure page is opened");
		} else {
			System.out.println("##  FAIL - page URL is NOT Equal  ##");
		}
		Thread.sleep(1000);

		///////////education page 2
		//***** moving back to home page (site symbol clicking)
		driver.findElement(By.xpath("/html/body/header/nav/div/a/img")).click();
		System.out.println("redirecting back to home page");
		Thread.sleep(3000);

		//*****closing home page popup*****	
		try {
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main Info popup has been closed");
		}
		catch (Exception e) {
			System.out.println("no Info Popup");
		}
		Thread.sleep(2000);

		//*** Hover through the 1st header menu 
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/a")).click();
		System.out.println("Areas of activity drop down opened");
		Thread.sleep(2000);		

		//*** Areas of activity dropdown -  clicking on "education"  	
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/ul/li[2]/a")).click();
		System.out.println("clicking on education in dropdown");
		Thread.sleep(2000);

		//**** Insurance URL comparing
		String pageUrlString6 = driver.getCurrentUrl();
		System.out.println(pageUrlString6);

		//*** text wanted to be compare to
		String expectedURL6 = "https://www.mashcal.co.il/areas-of-activity/?categoryId=2593";
		System.out.println(expectedURL6);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator insuranceCollator6 = Collator.getInstance(Locale.ENGLISH);
		insuranceCollator6.setStrength(Collator.PRIMARY);

		//***** Comparing between the two StringsexpectedURL
		if (insuranceCollator6.compare(pageUrlString6, expectedURL6) == 0) {
			System.out.println("##  PASS - page URL is Equal  ##");
			System.out.println("education page is opened");
		} else {
			System.out.println("##  FAIL - page URL is NOT Equal  ##");
		}
		Thread.sleep(1000);

		///////////technology page 3
		//***** moving back to home page (site symbol clicking)
		driver.findElement(By.xpath("/html/body/header/nav/div/a/img")).click();
		System.out.println("redirecting back to home page");
		Thread.sleep(3000);

		//*****closing home page popup*****	
		try {
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main Info popup has been closed");
		}
		catch (Exception e) {
			System.out.println("no Info Popup");
		}
		Thread.sleep(2000);

		//*** Hover through the 1st header menu 
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/a")).click();
		System.out.println("Areas of activity drop down opened");
		Thread.sleep(2000);		

		//*** Areas of activity dropdown -  clicking on "technology"  	
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/ul/li[3]/a")).click();
		System.out.println("clicking on technology in dropdown");
		Thread.sleep(2000);

		//**** technology URL comparing
		String pageUrlString4 = driver.getCurrentUrl();
		System.out.println(pageUrlString4);

		//*** text wanted to be compare to
		String expectedURL4 = "https://www.mashcal.co.il/areas-of-activity/?categoryId=2442";
		System.out.println(expectedURL4);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator insuranceCollator4 = Collator.getInstance(Locale.ENGLISH);
		insuranceCollator4.setStrength(Collator.PRIMARY);

		//***** Comparing between the two StringsexpectedURL
		if (insuranceCollator4.compare(pageUrlString4, expectedURL4) == 0) {
			System.out.println("##  PASS - page URL is Equal  ##");
			System.out.println("technology page is opened");
		} else {
			System.out.println("##  FAIL - page URL is NOT Equal  ##");
		}
		Thread.sleep(1000);

		////////environment quality page 4
		//***** moving back to home page (site symbol clicking)
		driver.findElement(By.xpath("/html/body/header/nav/div/a/img")).click();
		System.out.println("redirecting back to home page");
		Thread.sleep(3000);

		//*****closing home page popup*****	
		try {
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main Info popup has been closed");
		}
		catch (Exception e) {
			System.out.println("no Info Popup");
		}
		Thread.sleep(2000);

		//*** Hover through the 1st header menu 
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/a")).click();
		System.out.println("Areas of activity drop down opened");
		Thread.sleep(2000);		

		//*** Areas of activity dropdown -  clicking on "environment quality"  	
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/ul/li[4]/a")).click();
		System.out.println("clicking on environment quality in dropdown");
		Thread.sleep(2000);

		//**** Insurance URL comparing
		String pageUrlString3 = driver.getCurrentUrl();
		System.out.println(pageUrlString3);

		//*** text wanted to be compare to
		String expectedURL3 = "https://www.mashcal.co.il/areas-of-activity/?categoryId=2440";
		System.out.println(expectedURL3);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator insuranceCollator3 = Collator.getInstance(Locale.ENGLISH);
		insuranceCollator3.setStrength(Collator.PRIMARY);

		//***** Comparing between the two StringsexpectedURL
		if (insuranceCollator3.compare(pageUrlString3, expectedURL3) == 0) {
			System.out.println("##  PASS - page URL is Equal  ##");
			System.out.println("environment quality is opened");
		} else {
			System.out.println("##  FAIL - page URL is NOT Equal  ##");
		}
		Thread.sleep(1000);

		///////////city appearance page 5
		//***** moving back to home page (site symbol clicking)
		driver.findElement(By.xpath("/html/body/header/nav/div/a/img")).click();
		System.out.println("redirecting back to home page");
		Thread.sleep(3000);

		//*****closing home page popup*****	
		try {
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main Info popup has been closed");
		}
		catch (Exception e) {
			System.out.println("no Info Popup");
		}
		Thread.sleep(2000);

		//*** Hover through the 1st header menu 
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/a")).click();
		System.out.println("Areas of activity drop down opened");
		Thread.sleep(2000);		

		//*** Areas of activity dropdown -  clicking on "city appearance"  	
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/ul/li[5]/a")).click();
		System.out.println("clicking on city appearance in dropdown");
		Thread.sleep(2000);

		//**** Insurance URL comparing
		String pageUrlString5 = driver.getCurrentUrl();
		System.out.println(pageUrlString5);

		//*** text wanted to be compare to
		String expectedURL5 = "https://www.mashcal.co.il/areas-of-activity/?categoryId=3143";
		System.out.println(expectedURL5);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator insuranceCollator5 = Collator.getInstance(Locale.ENGLISH);
		insuranceCollator5.setStrength(Collator.PRIMARY);

		//***** Comparing between the two StringsexpectedURL
		if (insuranceCollator5.compare(pageUrlString5, expectedURL5) == 0) {
			System.out.println("##  PASS - page URL is Equal  ##");
			System.out.println("city appearance page is opened");
		} else {
			System.out.println("##  FAIL - page URL is NOT Equal  ##");
		}
		Thread.sleep(1000);

		/////////Insurance page 6
		//***** moving back to home page (site symbol clicking)
		driver.findElement(By.xpath("/html/body/header/nav/div/a/img")).click();
		System.out.println("redirecting back to home page");
		Thread.sleep(3000);

		//*****closing home page popup*****	
		try {
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main Info popup has been closed");
		}
		catch (Exception e) {
			System.out.println("no Info Popup");
		}
		Thread.sleep(2000);

		//*** Hover through the 1st header menu 
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/a")).click();
		System.out.println("Areas of activity drop down opened");
		Thread.sleep(2000);		

		//*** Areas of activity dropdown -  clicking on "insurance"  	
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/ul/li[6]/a")).click();
		System.out.println("clicking on Insurance in dropdown");
		Thread.sleep(2000);

		//**** Insurance URL comparing
		String pageUrlString1 = driver.getCurrentUrl();
		System.out.println(pageUrlString1);

		//*** text wanted to be compare to
		String expectedURL1 = "https://www.mashcal.co.il/areas-of-activity/?categoryId=4263";
		System.out.println(expectedURL1);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator insuranceCollator1 = Collator.getInstance(Locale.ENGLISH);
		insuranceCollator1.setStrength(Collator.PRIMARY);

		//***** Comparing between the two StringsexpectedURL
		if (insuranceCollator1.compare(pageUrlString1, expectedURL1) == 0) {
			System.out.println("##  PASS - page URL is Equal  ##");
			System.out.println("Insurance page is opened");
		} else {
			System.out.println("##  FAIL - page URL is NOT Equal  ##");
		}
		Thread.sleep(1000);


		/////////// Operation and procurement page 7
		//***** moving back to home page (site symbol clicking)
		driver.findElement(By.xpath("/html/body/header/nav/div/a/img")).click();
		System.out.println("redirecting back to home page");
		Thread.sleep(3000);

		//*****closing home page popup*****	
		try {
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main Info popup has been closed");
		}
		catch (Exception e) {
			System.out.println("no Info Popup");
		}
		Thread.sleep(2000);

		//*** Hover through the 1st header menu 
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/a")).click();
		System.out.println("Areas of activity drop down opened");
		Thread.sleep(2000);		

		//*** Areas of activity dropdown -  clicking on "Operation and procurement"  	
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/ul/li[7]/a")).click();
		System.out.println("clicking on Insurance in dropdown");
		Thread.sleep(2000);

		//**** Insurance URL comparing
		String pageUrlString7 = driver.getCurrentUrl();
		System.out.println(pageUrlString7);

		//*** text wanted to be compare to
		String expectedURL7 = "https://www.mashcal.co.il/areas-of-activity/?categoryId=4502";
		System.out.println(expectedURL7);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator opCollator = Collator.getInstance(Locale.ENGLISH);
		opCollator.setStrength(Collator.PRIMARY);

		//***** Comparing between the two StringsexpectedURL
		if (opCollator.compare(pageUrlString7, expectedURL7) == 0) {
			System.out.println("##  PASS - page URL is Equal  ##");
			System.out.println("Insurance page is opened");
		} else {
			System.out.println("##  FAIL - page URL is NOT Equal  ##");
		}
		Thread.sleep(1000);

		/////////// security page 8
		//***** moving back to home page (site symbol clicking)
		driver.findElement(By.xpath("/html/body/header/nav/div/a/img")).click();
		System.out.println("redirecting back to home page");
		Thread.sleep(3000);

		//*****closing home page popup*****	
		try {
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main Info popup has been closed");
		}
		catch (Exception e) {
			System.out.println("no Info Popup");
		}
		Thread.sleep(2000);

		//*** Hover through the 1st header menu 
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/a")).click();
		System.out.println("Areas of activity drop down opened");
		Thread.sleep(2000);		

		//*** Areas of activity dropdown -  clicking on "security"  	
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[1]/ul/li[8]/a")).click();
		System.out.println("clicking on Security in dropdown");
		Thread.sleep(2000);

		//**** Insurance URL comparing
		String pageUrlString8 = driver.getCurrentUrl();
		System.out.println(pageUrlString8);

		//*** text wanted to be compare to
		String expectedURL8 = "https://www.mashcal.co.il/areas-of-activity/?categoryId=4493";
		System.out.println(expectedURL8);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator secCollator = Collator.getInstance(Locale.ENGLISH);
		secCollator.setStrength(Collator.PRIMARY);

		//***** Comparing between the two StringsexpectedURL
		if (secCollator.compare(pageUrlString8, expectedURL8) == 0) {
			System.out.println("##  PASS - page URL is Equal  ##");
			System.out.println("Insurance page is opened");
		} else {
			System.out.println("##  FAIL - page URL is NOT Equal  ##");
		}
		Thread.sleep(1000);




		////////////////////////////////////////////////////////////////////////////////////////////////////////
		// 2nd header menu 

		//***** moving back to home page (site symbol clicking)
		driver.findElement(By.xpath("/html/body/header/nav/div/a/img")).click();
		System.out.println("redirecting back to home page");
		Thread.sleep(3000);

		//*****closing home page popup*****	
		try {
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main Info popup has been closed");
		}
		catch (Exception e) {
			System.out.println("no Info Popup");
		}
		Thread.sleep(2000);

		//////About Us page 1
		//**** Hover through the 2nd header menu 
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[2]/a")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("/html/body/header/nav/ul/li[2]/ul/li[1]/a")).click();
		System.out.println("moving to About Us page");
		Thread.sleep(2000);

		//****title comparing
		WebElement auPageTitle = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/h1"));
		String auTitleString = auPageTitle.getText();
		auPageTitle.click();
		Thread.sleep(1000);
		System.out.println(auTitleString);

		//*** text wanted to be compare to
		String expectedTitleAboutUs = "הסיפור שלנו";
		System.out.println(expectedTitleAboutUs);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator auCollator = Collator.getInstance(Locale.ENGLISH);
		auCollator.setStrength(Collator.PRIMARY);

		//***** Comparing between the two Strings
		if (auCollator.compare(auTitleString, expectedTitleAboutUs) == 0) {
			System.out.println("##  PASS - page Title is Equal  ##");
		} else {
			System.out.println("##  FAIL - page Title is NOT Equal  ##");
		}
		Thread.sleep(1000);

		//////Board members page 2
		//***** moving back to home page (site symbol clicking)
		driver.findElement(By.xpath("/html/body/header/nav/div/a/img")).click();
		System.out.println("redirecting back to home page");
		Thread.sleep(3000);

		//*****closing home page popup*****	
		try {
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main Info popup has been closed");
		}
		catch (Exception e) {
			System.out.println("no Info Popup");
		}
		Thread.sleep(2000);

		//*** Hover through the 2nd header menu 
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[2]/a")).click();
		System.out.println("About Us drop down opened");
		Thread.sleep(2000);		

		//*** about us dropdown -  clicking on "Board members"  	
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[2]/ul/li[2]/a")).click();
		System.out.println("clicking on Board Members in dropdown");
		Thread.sleep(2000);

		//****title comparing
		WebElement bmPageTitle = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/h1"));
		String bmTitleString = bmPageTitle.getText();
		bmPageTitle.click();
		Thread.sleep(1000);
		System.out.println(bmTitleString);

		//*** text wanted to be compare to
		String expectedTitleBM = "חברי דירקטוריון";
		System.out.println(expectedTitleBM);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator bmCollator = Collator.getInstance(Locale.ENGLISH);
		bmCollator.setStrength(Collator.PRIMARY);

		//***** Comparing between the two Strings
		if (bmCollator.compare(bmTitleString, expectedTitleBM) == 0) {
			System.out.println("##  PASS - page Title is Equal  ##");
		} else {
			System.out.println("##  FAIL - page Title is NOT Equal  ##");
		}
		Thread.sleep(1000);

		////// Company procedures page 2
		//***** moving back to home page (site symbol clicking)
		driver.findElement(By.xpath("/html/body/header/nav/div/a/img")).click();
		System.out.println("redirecting back to home page");
		Thread.sleep(3000);

		//*****closing home page popup*****	
		try {
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main Info popup has been closed");
		}
		catch (Exception e) {
			System.out.println("no Info Popup");
		}
		Thread.sleep(2000);

		//*** Hover through the 2nd header menu 
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[2]/a")).click();
		System.out.println("About Us drop down opened");
		Thread.sleep(2000);		

		//*** about us dropdown -  clicking on "Company procedures"  	
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[2]/ul/li[3]/a")).click();
		System.out.println("clicking on Bidding Procedures in dropdown");
		Thread.sleep(2000);

		//****title comparing
		WebElement cpPageTitle = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/h1"));
		String cpTitleString = cpPageTitle.getText();
		cpPageTitle.click();
		Thread.sleep(1000);
		System.out.println(cpTitleString);

		//*** text wanted to be compare to
		String expectedTitleCP = "נהלי החברה";
		System.out.println(expectedTitleCP);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator cpCollator = Collator.getInstance(Locale.ENGLISH);
		cpCollator.setStrength(Collator.PRIMARY);

		//***** Comparing between the two Strings
		if (cpCollator.compare(cpTitleString, expectedTitleCP) == 0) {
			System.out.println("##  PASS - page Title is Equal  ##");
		} else {
			System.out.println("##  FAIL - page Title is NOT Equal  ##");
		}
		Thread.sleep(1000);

		////// Ministry of the Interior page 4
		//***** moving back to home page (site symbol clicking)
		driver.findElement(By.xpath("/html/body/header/nav/div/a/img")).click();
		System.out.println("redirecting back to home page");
		Thread.sleep(3000);

		//*****closing home page popup*****	
		try {
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main Info popup has been closed");
		}
		catch (Exception e) {
			System.out.println("no Info Popup");
		}
		Thread.sleep(2000);

		//*** Hover through the 2nd header menu 
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[2]/a")).click();
		System.out.println("About Us drop down opened");
		Thread.sleep(2000);		

		//*** about us dropdown -  clicking on "Ministry of the Interior"  	
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[2]/ul/li[4]/a")).click();
		System.out.println("clicking on Ministry of the Interior in dropdown");
		Thread.sleep(2000);

		//****title comparing
		WebElement miPageTitle = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/h1"));
		String miTitleString = miPageTitle.getText();
		miPageTitle.click();
		Thread.sleep(1000);
		System.out.println(miTitleString);

		//*** text wanted to be compare to
		String expectedTitleMI = "פטור משרד הפנים";
		System.out.println(expectedTitleMI);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator miCollator = Collator.getInstance(Locale.ENGLISH);
		miCollator.setStrength(Collator.PRIMARY);

		//***** Comparing between the two Strings
		if (miCollator.compare(miTitleString, expectedTitleMI) == 0) {
			System.out.println("##  PASS - page Title is Equal  ##");
		} else {
			System.out.println("##  FAIL - page Title is NOT Equal  ##");
		}
		Thread.sleep(1000);

		/////////////////////////////////////////////////////////////////////////////////////
		///3th header menu 

		//***** moving back to home page (site symbol clicking)
		driver.findElement(By.xpath("/html/body/header/nav/div/a/img")).click();
		System.out.println("redirecting back to home page");
		Thread.sleep(3000);

		//*****closing home page popup*****	
		try {
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main Info popup has been closed");
		}
		catch (Exception e) {
			System.out.println("no Info Popup");
		}
		Thread.sleep(2000);

		//**** Hover through the 3th header menu 		
		////// Local authority publications page 1
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[3]/a")).click();
		System.out.println("News and Publications drop down opened");
		Thread.sleep(2000);		

		//*** News and Publications dropdown -  clicking on "Local authority publications"  	
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[3]/ul/li[1]/a")).click();
		System.out.println("clicking on Local authority publications in dropdown");
		Thread.sleep(2000);

		//****title comparing
		WebElement lapPageTitle = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/h1"));
		String lapTitleString = lapPageTitle.getText();
		lapPageTitle.click();
		Thread.sleep(1000);
		System.out.println(lapTitleString);

		//*** text wanted to be compare to
		String expectedTitleLAP = "מכרזי הרשויות המקומיות שפורסמו בעיתונות";
		System.out.println(expectedTitleLAP);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator lapCollator = Collator.getInstance(Locale.ENGLISH);
		lapCollator.setStrength(Collator.PRIMARY);

		//***** Comparing between the two Strings
		if (lapCollator.compare(lapTitleString, expectedTitleLAP) == 0) {
			System.out.println("##  PASS - page Title is Equal  ##");
		} else {
			System.out.println("##  FAIL - page Title is NOT Equal  ##");
		}
		Thread.sleep(1000);

		//***** moving back to home page (site symbol clicking)
		driver.findElement(By.xpath("/html/body/header/nav/div/a/img")).click();
		System.out.println("redirecting back to home page");
		Thread.sleep(3000);

		//*****closing home page popup*****	
		try {
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main Info popup has been closed");
		}
		catch (Exception e) {
			System.out.println("no Info Popup");
		}
		Thread.sleep(2000);

		//**** Hover through the 3th header menu again 		
		////// Our Blog page 2
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[3]/a")).click();
		System.out.println("News and Publications drop down opened");
		Thread.sleep(2000);		

		//*** News and Publications dropdown -  clicking on "Local authority publications"  	
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[3]/ul/li[2]/a")).click();
		System.out.println("clicking on Our Blog in dropdown");
		Thread.sleep(2000);

		//****title comparing
		WebElement obPageTitle = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/h1"));
		String obTitleString = obPageTitle.getText();
		obPageTitle.click();
		Thread.sleep(1000);
		System.out.println(obTitleString);

		//*** text wanted to be compare to
		String expectedTitleOB = "נהלי הצעות מחיר";
		System.out.println(expectedTitleOB);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator obCollator = Collator.getInstance(Locale.ENGLISH);
		obCollator.setStrength(Collator.PRIMARY);

		//***** Comparing between the two Strings
		if (obCollator.compare(obTitleString, expectedTitleOB) == 0) {
			System.out.println("##  PASS - page Title is Equal  ##");
		} else {
			System.out.println("##  FAIL - page Title is NOT Equal  ##");
		}
		Thread.sleep(1000);


		//////////////////////////////////////////////////////////////////////
		// 4th header menu 

		//***** moving back to home page (site symbol clicking)
		driver.findElement(By.xpath("/html/body/header/nav/div/a/img")).click();
		System.out.println("redirecting back to home page");
		Thread.sleep(3000);

		//*****closing home page popup*****	
		try {
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main Info popup has been closed");
		}
		catch (Exception e) {
			System.out.println("no Info Popup");
		}
		Thread.sleep(2000);


		//**** Hover through the 4th header menu 
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[4]/a")).click();
		System.out.println("dropdown opened");
		Thread.sleep(2000);

		//****redirected to the our-tenders page
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[4]/ul/li[1]/a")).click();
		Thread.sleep(1000);
		System.out.println("redirected to the our-tenders page");		

		//****title comparing
		WebElement pageTitleElement = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/h1"));
		String uiTitleString = pageTitleElement.getText();
		pageTitleElement.click();
		Thread.sleep(1000);
		System.out.println(uiTitleString);

		//*** text wanted to be compare to
		String expectedText = "המכרזים שלנו";
		System.out.println(expectedText);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator collator = Collator.getInstance(Locale.ENGLISH);
		collator.setStrength(Collator.PRIMARY);

		//***** Comparing between the two Strings
		if (collator.compare(uiTitleString, expectedText) == 0) {
			System.out.println("##  PASS - page Title is Equal  ##");
		} else {
			System.out.println("##  FAIL - page Title is NOT Equal  ##");
		}
		Thread.sleep(1000);

		//**** entering the wanted page 
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/a[1]/div")).click();
		Thread.sleep(1000);
		System.out.println("first page");
		driver.findElement(By.cssSelector("body > div.body > app-root > app-category-auctions > div.section.category-auctions-results-container > div > div > a:nth-child(1)")).click();
		Thread.sleep(1000);
		System.out.println("second page");

		//****title comparing
		WebElement PageTitle2 = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/h1"));
		String TitleString2 = PageTitle2.getText();
		PageTitle2.click();
		Thread.sleep(1000);
		System.out.println(TitleString2);

		//*** text wanted to be compare to
		String expectedTitle2 = "מכרז לתכנון ובניית קירויים למגרשי ספורט";
		System.out.println(expectedTitle2);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator Collator2 = Collator.getInstance(Locale.ENGLISH);
		Collator2.setStrength(Collator.PRIMARY);

		//***** Comparing between the two Strings
		if (Collator2.compare(TitleString2, expectedTitle2) == 0) {
			System.out.println("##  PASS - page Title is Equal  ##");
		} else {
			System.out.println("##  FAIL - page Title is NOT Equal  ##");
		}
		Thread.sleep(1000);

		//		/// not available in site yet !!!!! only comparing the title
		//		WebElement page = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[5]/div/div/div/div[4]/a"));
		//		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		//		js2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", page);
		//		System.out.println("third and last page");
		//		Thread.sleep(2000);
		//
		//		//*****getting CTA text title*****		
		//		WebElement ctaForm = driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[1]/div[1]/div[6]/a"));
		//		String ctaName = ctaForm.getText();
		//		System.out.println("name of the CTA " + ctaName);
		//		Thread.sleep(2000);	
		//
		//		//***** opening form with java script
		//		JavascriptExecutor js = (JavascriptExecutor) driver;
		//		js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", ctaForm);
		//		System.out.println("form number has been opened");
		//		Thread.sleep(2000);	
		//
		//		//***** filling user details
		//		System.out.println("filling user details");
		//		Thread.sleep(1000);
		//		//**fill user first name
		//		driver.findElement(By.id("formModel_FirstName")).sendKeys("TestUserFirstName");
		//		Thread.sleep(1000);
		//		//**fill user last name
		//		driver.findElement(By.id("formModel_LastName")).sendKeys("TestUserLastName");
		//		Thread.sleep(1000);
		//		//**fill user email
		//		driver.findElement(By.id("formModel_Email")).sendKeys("TestUser@TestUser.com");
		//		Thread.sleep(1000);
		//		//**fill user phone number
		//		driver.findElement(By.id("formModel_Phone")).sendKeys("0501111111");
		//		Thread.sleep(1000);
		//		//**fill user company name
		//		driver.findElement(By.id("formModel_AuctionCategory")).sendKeys("TestUserCompany");
		//		Thread.sleep(1000);
		//		//**fill user job
		//		driver.findElement(By.id("formModel_AuthorityJob")).sendKeys("TestUserJob");
		//		Thread.sleep(1000);
		//
		//		//**marking the Check boxes
		//		System.out.println("checking the checkboxes");
		//		driver.findElement(By.xpath("//*[@id=\"frmRegisterNotification\"]/div/div[2]/div[7]/div/label")).click();
		//		driver.findElement(By.xpath("//*[@id=\"frmRegisterNotification\"]/div/div[2]/div[8]/div/label")).click();
		//		Thread.sleep(2000);	
		//
		//		//**clicking form CTA to send with java script
		//		System.out.println("pressing on send form button");
		//		driver.findElement(By.id("btnRegisterNotification")).click();
		//		Thread.sleep(2000);
		//
		//		//***** clicking form CTA success with java script *****
		//		System.out.println("pressing on send form successfuly button");
		//		driver.findElement(By.cssSelector("#registerNotificationSuccessMessage > div > a")).click();
		//		Thread.sleep(2000);
		//
		//		//***** moving back to home page (site symbol clicking)
		//		driver.findElement(By.xpath("/html/body/header/nav/div/a/img")).click();
		//		System.out.println("redirecting back to home page");
		//		Thread.sleep(3000);

		////////////////////////////////////////////
		//****  5th header menu 

		//***** moving back to home page (site symbol clicking)
		driver.findElement(By.xpath("/html/body/header/nav/div/a/img")).click();
		System.out.println("redirecting back to home page");
		Thread.sleep(3000);

		//*****closing home page popup*****	
		try {
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main Info popup has been closed");
		}
		catch (Exception e) {
			System.out.println("no Info Popup");
		}
		Thread.sleep(2000);

		//**** Hover through the 5th header menu 
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[4]/a")).click();
		System.out.println("dropdown opened");
		Thread.sleep(1000);

		//****redirected to the committee page
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[4]/ul/li[3]/a")).click();
		Thread.sleep(1000);
		System.out.println("redirected to the committee page");

		//****title comparing
		WebElement pageTitleElement3 = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/h1"));
		String uiTitleString3 = pageTitleElement3.getText();
		pageTitleElement3.click();
		Thread.sleep(1000);
		System.out.println(uiTitleString3);

		//*** text wanted to be compare to
		String expectedText3 = "נהלי הצעות מחיר";
		System.out.println(expectedText3);
		Thread.sleep(2000);

		//***** Using Collector and Locale  for non English Text encode (change text to English encode)
		Collator collator3 = Collator.getInstance(Locale.ENGLISH);
		collator3.setStrength(Collator.PRIMARY);

		//***** Comparing between the two Strings
		if (collator3.compare(uiTitleString3, expectedText3) == 0) {
			System.out.println("##  PASS - page Title is Equal  ##");
		} else {
			System.out.println("##  FAIL - page Title is NOT Equal  ##");
		}
		Thread.sleep(1000);

		////////////////////////////////////////////
		//**** Hover through the second LEFT header menu 		
		//***** moving back to home page (site symbol clicking)
		driver.findElement(By.xpath("/html/body/header/nav/div/a/img")).click();
		System.out.println("redirecting back to home page");
		Thread.sleep(3000);

		//*****closing home page popup*****	
		try {
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main Info popup has been closed");
		}
		catch (Exception e) {
			System.out.println("no Info Popup");
		}
		Thread.sleep(2000);

		//**** Hover through the 5th header menu 
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[5]/a")).click();
		System.out.println("dropdown opened");
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/header/nav/ul/li[5]/ul/li[1]")).click();
		Thread.sleep(2000);
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		driver.navigate().back();
		Thread.sleep(3000);
		
		//*****closing home page popup*****	
		try {
			driver.findElement(By.cssSelector("#modal-info > div > div > div.popupBG > div > button")).click();
			System.out.println("main Info popup has been closed");
		}
		catch (Exception e) {
			System.out.println("no Info Popup");
		}
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[5]/a")).click();
		Thread.sleep(1000);
		System.out.println("dropdown opened");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[5]/ul/li[2]")).click();
		Thread.sleep(2000);
		String page2Title = driver.getTitle();
		System.out.println(page2Title);
		driver.navigate().back();
		Thread.sleep(2000);
		
//		driver.findElement(By.xpath("/html/body/header/nav/ul/li[5]/a")).click();
//        System.out.println("dropdown closed");
//		Thread.sleep(1000);
		
		///////////////////////////////////////////////////////
		//***** full screen video "feel at home" header and exit full screen
		WebElement fullScreenElement = driver.findElement(By.id("bgvid"));
		fullScreenElement.click();
		System.out.println("video in full screen mode");
		Thread.sleep(3000); 

		Actions exitfull = new Actions(driver);
		exitfull.sendKeys(Keys.ESCAPE).build().perform();
		System.out.println("video exiting full screen mode");
		Thread.sleep(3000); 

		//***** pausing and replaying the video
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/a[1]")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/a[2]")).click();
		Thread.sleep(2000); 

		////////////////////////////////////////////////////
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
		subjectList.selectByValue("ksafim@mashcal.co.il ");
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
		driver.close();
		System.out.println("##  ending test and closing the browser  ###");

	}

}

//  //********** moving between windows ************
//String parentWindow = driver.getWindowHandle();
//System.out.println("parent window" + parentWindow);
//driver.findElement(By.xpath("XXXXXXX")).click();
//Thread.sleep(2000);
//Set <String> allWindows = driver.getWindowHandles();
//int windowsCount = allWindows.size();
//System.out.println("total windows: " + windowsCount);
//for (String child:allWindows) {
//	if(!parentWindow.equalsIgnoreCase(child)) {
//		driver.switchTo().window(child);
//		
//		driver.findElement(By.xpath("XXXXXXX")).click();
//		
//		Thread.sleep(2000);
//	}
//}
//driver.switchTo().window(parentWindow);
