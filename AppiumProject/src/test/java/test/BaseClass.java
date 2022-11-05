package test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pages.LoginOtpPageElement;

public class BaseClass {
	
	
	  AppiumDriver<MobileElement> driver; 
	  LoginOtpPageElement lop;
	  
	  public String getOtpButton2="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView";
	  public String submitOtp="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup";
	  public String mobileNumbarManadatoryMessage="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView";
	  public String mobileNumberMaxDigitMessage="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView";
	  public String countryCode="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView";
	  public String flag = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView";
	  public String countryListFrame = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView";
	  
	  AppiumDriverLocalService service ;
	  //= new  AppiumServiceBuilder().withAppiumJS(new
			  //File("C:\\Program Files\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js" )).withIPAddress("127.0.0.1").usingPort(4723).build();
	  
	  @BeforeTest (alwaysRun=true)
	  public void setup() throws MalformedURLException, InterruptedException {
	  
		  
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability(MobileCapabilityType.APP,"C:\\Users\\LAPCARE-PC\\git\\YoCricket\\AppiumProject\\src\\test\\java\\resources\\yocricket-v03.11.01.apk"); 
	  caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
	  caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
	  caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Android SDK built for x86_64");
	  caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
	  caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
	  caps.setCapability("autoGrantPermissions", "true");
	  URL url = new	  URL("http://127.0.0.1:4723/wd/hub");
	  
	  driver = new AppiumDriver<MobileElement> (url,caps);
	  lop = new LoginOtpPageElement(driver);
	  service = lop.serviceStart(service);
	  service.start();
	  //Thread.sleep(7000);
	  lop.SkipFirstPage(); 
	  }
	  
	  //=============================================Login & OTP  Section============================================
	  
	@Test (groups= {"Smoke"})
	public void internetOffTest() throws InterruptedException 
	{
		try 
		{
			Thread.sleep(2000);
			lop.countryCodeDropdown();
			System.out.println("Test Aakash");
		}
		catch(Exception e)
		{
			System.out.println("Internet is Off so Login elementent not coming");			
		}
		
	}
	
	@Test
	public void VerifyMobileNumber() throws InterruptedException
	{
			
		  lop.getOTPButton();
		  Thread.sleep(3000);
		  String msg =driver.findElement(By.xpath(mobileNumbarManadatoryMessage)).getText();
		  Thread.sleep(2000); 
		  assertEquals(msg,"Mobile number is a mandatory field, it cannot be empty.", "Validation Message not match with expected");
		  driver.findElement(By.className("android.widget.EditText")).sendKeys( "98259644204567");
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(getOtpButton2)).click();
		  Thread.sleep(3000);		  
		  driver.findElement(By.xpath(mobileNumberMaxDigitMessage)).isDisplayed();
		  Thread.sleep(2000);
		   driver.findElement(By.className("android.widget.EditText")).sendKeys( "+916442045");
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(getOtpButton2)).click();
		  Thread.sleep(3000);		  
		  String msg3 =driver.findElement(By.xpath(mobileNumberMaxDigitMessage)).getText();
		  assertEquals(msg3,"Please enter a valid mobile number.", "Validation Message not match with expected");
		/*
		 * driver.findElement(By.xpath(
		 * "//android.widget.EditText[@content-desc=\"otpInput-0\"]")).sendKeys("1");
		 * Thread.sleep(2000); driver.findElement(By.xpath(
		 * "//android.widget.EditText[@content-desc=\"otpInput-1\"]")).sendKeys("2");
		 * Thread.sleep(2000); driver.findElement(By.xpath(
		 * "//android.widget.EditText[@content-desc=\"otpInput-2\"]")).sendKeys("3");
		 * Thread.sleep(2000); driver.findElement(By.xpath(
		 * "//android.widget.EditText[@content-desc=\"otpInput-3\"]")).sendKeys("4");
		 * Thread.sleep(2000); driver.findElement(By.xpath(submitOtp)).click();
		 */
		
		System.out.println("I am inside");
		  //service.stop();
		
	}
	
	@Test
	public void VerifyCountryDropdown() throws InterruptedException 
	{					
		lop.countryCodeDropdown();
		Thread.sleep(3000);
		String sc= driver.findElement(By.xpath(countryListFrame)).getAttribute("scrollable");
		assertEquals(sc,"true", "country is not scrollable");
		Thread.sleep(2000);
		driver.findElement(By.className("android.widget.EditText")).sendKeys("91");
		Thread.sleep(3000); 
		//India (+91)
		driver.findElement(By.className("android.widget.TextView")).click();
		Thread.sleep(3000); 
		String code = driver.findElement(By.xpath(countryCode)).getText();
		assertEquals(code,"+91", "Code is not match with expected");
		String ne= driver.findElement(By.xpath(countryCode)).getAttribute("clickable");
		assertEquals(ne,"false", "field is editable");
		String countryName = driver.findElement(By.xpath(flag)).getAttribute("text");
		assertEquals(countryName,"🇮🇳", "Country Name flag is not correct");
		
	}
	
	@Test
	public void ContinueAsGuest() throws InterruptedException 
	{	
		lop.continueAsGuestpathlinkPresent();
		String te = lop.continueAsGuestpathlinkText();
		assertEquals(te,"Continue as Guest", "Text is not correct");
	}
	
	@Test
	public void VerifyInvalidOTP() throws InterruptedException 
	{	
		
		lop.countryCodeDropdown();
		Thread.sleep(2000);
		lop.countryCodeSelection();
		Thread.sleep(2000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(2000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","7","4");
		String invalidAlertMsg = lop.VerifyInalidOtpMessage();
		assertEquals(invalidAlertMsg,"Please enter a valid OTP.", "Text is not correct");
		
		lop.validOtpAlertOKButtonclick();
		Thread.sleep(3000);
		}
	
	@Test
	public void FirstTimeLoginFieldsVerify() throws InterruptedException 
	{	
		
		lop.countryCodeDropdown();
		Thread.sleep(2000);
		lop.countryCodeSelection();
		Thread.sleep(2000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(2000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
	    Thread.sleep(3000);
		
		lop.firstNameTextbox();
		Thread.sleep(3000);
		lop.LastNameTextbox();
		Thread.sleep(3000);
		lop.updateButtonclick();
		Thread.sleep(3000);
	}
		
	//===================================Tournament Section==========================================//
	
	@Test
	public void CreateTournament() throws InterruptedException 
	{	
		
		LoginToMenu();
		
		//lop.firstNameTextbox();
		//Thread.sleep(2000); 
		//lop.LastNameTextbox();
		//Thread.sleep(2000); 
		//driver.hideKeyboard();
		//lop.updateButtonclick();
		//Thread.sleep(3000); 
		//lop.MenuPathclick();
		lop.CreateTournamentLinkclick();
		lop.UploadProfilePhoto();
		lop.ClickToUploadMainPhoto();
		Thread.sleep(4000); 
		lop.TournamentNameTextbox("IPL123#");
		lop.LocationNameTextbox();
		Thread.sleep(3000); 
		lop.ArenaNameTextbox();
		lop.scrollPage();
		lop.OrganiserNameTextbox("LionsClub123#");
		Thread.sleep(2000); 
		lop.OrganiserContactTextbox("9825964420");
		//Thread.sleep(3000);
		//lop.createtournamentStartDateIcon().click();
		//Thread.sleep(3000);
		//lop.createtournamentSelectStartDate("04 November 2022");
		//Thread.sleep(3000);
		//lop.createtournamentSelecrStartDateOKButton().click(); 
		lop.TournamentCategoryclick();
		lop.CreateTournamentButtonclick();
		Thread.sleep(5000);		 
	}
	
	@Test
	public void EditTournament() throws InterruptedException 
	{	
		
		lop.countryCodeDropdown();
		Thread.sleep(2000);
		lop.countryCodeSelection();
		Thread.sleep(2000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(2000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
		lop.MenuPathclick();
		Thread.sleep(2000); 
		lop.MyTournamentLinkClick();
		Thread.sleep(6000); 
		//lop.scrollPage();
		//Thread.sleep(6000);
		//lop.SelectOurTornamentClick();
		lop.selectOurTournamentWithoutScrollInPast();
		Thread.sleep(15000);
		lop.OKButtonOFAddNewTeamsClick();
		Thread.sleep(5000);
		lop.TournamentAboutTab();
		Thread.sleep(3000); 
		lop.tournamnetEditIconClick();
		Thread.sleep(3000); 
		lop.EditTournamentClickToUploadMainPhoto();
		Thread.sleep(4000); 
		lop.EditTornamentUploadProfilePhoto();
		Thread.sleep(4000); 
		lop.EditTournamentNameTextbox("IPL123##");
		Thread.sleep(2000); 
		lop.EditLocationNameTextbox();
		Thread.sleep(2000);
		lop.EditArenaNameTextbox();
		Thread.sleep(2000);
		lop.scrollPage();
		Thread.sleep(3000); 
		lop.EditOrganiserNameTextbox("LionsClub123##");
		Thread.sleep(2000); 
		lop.EditOrganiserContactTextbox("9825964421");
		Thread.sleep(3000);
		lop.EdittournamentStartDateIcon().click();
		Thread.sleep(2000);
		lop.createtournamentSelectStartDate("17 October 2022");
		Thread.sleep(2000);
		lop.createtournamentSelecrStartDateOKButton().click(); 
		Thread.sleep(2000);
		lop.EditTournamentCategoryclick();
		Thread.sleep(2000);
		lop.EditTournamentButtonclick();
		Thread.sleep(5000);		 
	}
	
	@Test
	public void EditTournamentMandatoryValiadtion() throws InterruptedException 
	{	
		
		lop.countryCodeDropdown();
		Thread.sleep(2000);
		lop.countryCodeSelection();
		Thread.sleep(2000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(2000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
		lop.MenuPathclick();
		Thread.sleep(2000); 
		lop.MyTournamentLinkClick();
		Thread.sleep(6000); 
		//lop.scrollPage();
		//Thread.sleep(6000);
		//lop.SelectOurTornamentClick();
		lop.selectOurTournamentWithoutScrollInPast();
		Thread.sleep(4000);
		lop.OKButtonOFAddNewTeamsClick();
		Thread.sleep(5000);
		lop.TournamentAboutTab();
		Thread.sleep(3000); 
		lop.tournamnetEditIconClick();
		Thread.sleep(3000); 
		lop.EditTournamentClickToUploadMainPhoto();
		Thread.sleep(4000); 
		lop.EditTornamentUploadProfilePhoto();
		Thread.sleep(4000); 
		lop.EditTournamentNameTextbox("");
		Thread.sleep(2000); 
		lop.EditLocationNameTextboxClear();
		Thread.sleep(2000);
		lop.EditArenaNameTextboxClear();
		Thread.sleep(2000);
		lop.scrollPage();
		Thread.sleep(3000); 
		lop.EditOrganiserNameTextbox("");
		Thread.sleep(2000); 
		lop.EditOrganiserContactTextbox("");
		Thread.sleep(3000);
		lop.EdittournamentStartDateIcon().click();
		Thread.sleep(2000);
		lop.createtournamentSelectStartDate("12 September 2022");
		Thread.sleep(2000);
		lop.createtournamentSelecrStartDateOKButton().click(); 
		Thread.sleep(2000);
		lop.EditTournamentCategoryclick();
		Thread.sleep(2000);
		lop.EditTournamentButtonclick();
		Thread.sleep(5000);
		lop.EditTournamentFieldValidation();
	}
	
	@Test
	public void CreateTournamentVerifyFieldSMaximumLengthValidation() throws InterruptedException 
	{	
		lop.countryCodeDropdown();
		Thread.sleep(2000);
		lop.countryCodeSelection();
		Thread.sleep(2000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(2000);
		lop.getOTPButton();
		Thread.sleep(4000);
		
		lop.MenuPathclick();
		Thread.sleep(2000); 
		lop.CreateTournamentLinkclick();
		Thread.sleep(2000); 
		lop.TournamentNameTextbox("IPL123#");
		Thread.sleep(2000); 
		lop.LocationNameTextbox();
		Thread.sleep(2000);
		lop.ArenaNameTextbox();
		Thread.sleep(2000);
		lop.scrollPage();
		Thread.sleep(3000); 
		lop.OrganiserNameTextbox("LionsClub123#");
		Thread.sleep(2000); 
		lop.OrganiserContactTextbox("9825964420");
		Thread.sleep(2000); 
		lop.TournamentCategoryclick();
		Thread.sleep(2000);
		lop.CreateTournamentButtonclick();
		Thread.sleep(2000);		  
	}
	
	@Test
	public void CreateTournamentMandatoryFieldsValidation() throws InterruptedException 
	{	
		lop.countryCodeDropdown();
		Thread.sleep(2000);
		lop.countryCodeSelection();
		Thread.sleep(2000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(2000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
		Thread.sleep(4000);
		lop.MenuPathclick();
		Thread.sleep(4000); 
		lop.CreateTournamentLinkclick();
		Thread.sleep(4000); 
		lop.CrateTournamentFieldValidation();
	}
	
	@Test
	public void CreateTournamentFieldsIconValidation() throws InterruptedException 
	{	
		lop.countryCodeDropdown();
		Thread.sleep(2000);
		lop.countryCodeSelection();
		Thread.sleep(2000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(2000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
		Thread.sleep(4000);
		lop.MenuPathclick();
		Thread.sleep(4000); 
		lop.CreateTournamentLinkclick();
		Thread.sleep(4000); 
		lop.CrateTournamentIconValidation();
	}
	@Test
	public void EditTournamentFieldsIconValidation() throws InterruptedException 
	{	
		lop.countryCodeDropdown();
		Thread.sleep(2000);
		lop.countryCodeSelection();
		Thread.sleep(2000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(2000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
		lop.MenuPathclick();
		Thread.sleep(2000); 
		lop.MyTournamentLinkClick();
		Thread.sleep(6000); 
		//lop.scrollPage();
		//Thread.sleep(6000);
		//lop.SelectOurTornamentClick();
		lop.selectOurTournamentWithoutScrollInPast();
		Thread.sleep(4000);
		lop.OKButtonOFAddNewTeamsClick();
		Thread.sleep(5000);
		lop.TournamentAboutTab();
		Thread.sleep(3000); 
		lop.tournamnetEditIconClick();
		Thread.sleep(4000); 
		lop.EditTournamentIconValidation();
	}
	
	//==================================Team Section=============================================================//
	
	@Test
	public void createTeam() throws InterruptedException 
	{
		CreateTournament();
		//lop.MyTournamentLinkClick();
		//lop.scrollPage();
		//Thread.sleep(3000);
		//lop.selectOurTournamentWithoutScrollInPast();
		lop.OKButtonOFAddNewTeamsClick();
		lop.TeamMenuClick();
		lop.addIconForTeamClick();
		lop.addINewTeamClick();
		lop.EnterTeamName("Ring");
		lop.EnterTeamCity("Vad");
		lop.ClickToUploadTeamPhoto();
		lop.AddTeamButtonClick();
		
		lop.EnterTeamName("Vin");
		lop.EnterTeamCity("Vad");
		lop.ClickToUploadTeamPhoto();
		lop.AddTeamButtonClick();
		
		Thread.sleep(5000);
	}
	
	@Test
	public void CreateTeamPaeValidation() throws InterruptedException 
	{
		Thread.sleep(4000);
		lop.countryCodeDropdown();
		Thread.sleep(2000);
		lop.countryCodeSelection();
		Thread.sleep(2000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(2000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
		lop.MenuPathclick();
		Thread.sleep(2000); 
		lop.MyTournamentLinkClick();
		Thread.sleep(6000); 
		//lop.scrollPage();
		//Thread.sleep(6000);
		//lop.SelectOurTornamentClick();
		lop.selectOurTournamentWithoutScrollInPast();
		Thread.sleep(4000);
		lop.OKButtonOFAddNewTeamsClick();
		Thread.sleep(5000);
		lop.TeamMenuClick();
		Thread.sleep(2000);
		lop.addIconForTeamClick();
		Thread.sleep(2000);
		lop.addINewTeamClick();
		Thread.sleep(4000);
		//lop.EnterTeamName("");
		//Thread.sleep(3000);
		//lop.EnterTeamCity("Vado");
		//Thread.sleep(3000);
		//lop.ClickToUploadTeamPhoto();
		//Thread.sleep(3000);
		lop.AddTeamButtonClick();
		Thread.sleep(4000);
		lop.CreateTeamPageValidations();
		Thread.sleep(4000);
		lop.EnterTeamName("abc123#");
		Thread.sleep(4000);
		lop.AddTeamButtonClick();
		Thread.sleep(4000);
	}

	@Test
	public void EditTeam() throws InterruptedException 
	{
		lop.countryCodeDropdown();
		Thread.sleep(2000);
		lop.countryCodeSelection();
		Thread.sleep(2000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(2000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
		lop.MenuPathclick();
		Thread.sleep(2000); 
		lop.MyTournamentLinkClick();
		Thread.sleep(6000); 
		//lop.scrollPage();
		//Thread.sleep(6000);
		lop.selectOurTournamentWithoutScrollInPast();
		Thread.sleep(15000);
		lop.OKButtonOFAddNewTeamsClick();
		Thread.sleep(5000);
		lop.TeamMenuClick();
		Thread.sleep(3000);
		lop.TeamOneClick();
		Thread.sleep(3000);
		lop.OKButtonAddNewPlayerScreen();
		Thread.sleep(3000);
		lop.EditTeamName("Ring");
		Thread.sleep(3000);
		lop.EditTeamCity("raj");
		Thread.sleep(3000);
		lop.EditClickToUploadTeamPhoto();
		Thread.sleep(5000);
		lop.EditSaveTeamButtonClick();
		Thread.sleep(4000);
	}
	
	@Test
	public void EditTeamValidations() throws InterruptedException 
	{
		Thread.sleep(4000);
		lop.countryCodeDropdown();
		Thread.sleep(2000);
		lop.countryCodeSelection();
		Thread.sleep(2000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(2000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
		lop.MenuPathclick();
		Thread.sleep(2000); 
		lop.MyTournamentLinkClick();
		Thread.sleep(6000); 
		//lop.scrollPage();
		//Thread.sleep(6000);
		//lop.SelectOurTornamentClick();
		lop.selectOurTournamentWithoutScrollInPast();
		Thread.sleep(4000);
		lop.OKButtonOFAddNewTeamsClick();
		Thread.sleep(5000);
		lop.TeamMenuClick();
		Thread.sleep(3000);
		lop.TeamOneClick();
		Thread.sleep(3000);
		lop.OKButtonAddNewPlayerScreen();
		Thread.sleep(3000);
		lop.EditTeamName("");
		Thread.sleep(3000);
		//lop.EditTeamCity("raj");
		//Thread.sleep(3000);
		//lop.EditClickToUploadTeamPhoto();
		//Thread.sleep(3000);
		lop.EditSaveTeamButtonClick2();
		Thread.sleep(3000);
		lop.EditTeamPageValidations();
		Thread.sleep(3000);
		lop.EditTeamName("VRin");
		Thread.sleep(3000);
		lop.EditSaveTeamButtonClick();
		Thread.sleep(3000);
	}
	
	//===============================Player Section==========================//
	
	@Test
	public void AddPlayersInTeam() throws InterruptedException 
	{
		/*LoginToMenu();
		lop.MyTournamentLinkClick();
		//lop.scrollPage();
		Thread.sleep(3000);
		//lop.SelectOurTornamentClick();
		lop.selectOurTournamentWithoutScrollInPast();
		lop.OKButtonOFAddNewTeamsClick();
		lop.TeamMenuClick();
		//lop.OKButtonAddNewPlayerScreen();
		//Thread.sleep(4000);*/
		createTeam();
		lop.TeamOneClick();
		lop.OKButtonAddNewPlayerScreen();
		//Thread.sleep(3000);
		// Make debug point here and click on add player icon manually 
		//lop.addplayerIconOnEditPageClick();
		//Thread.sleep(4000);
		lop.PlayerMobileNumber(lop.getAlphaNumericString(10));
		lop.PlayerFirstName("VV");
		Thread.sleep(2000);
		lop.PlayerLastName("Lax");
		lop.AddPLayerButtonClick();
		//lop.addplayerIconOnEditPageClick();
		//Thread.sleep(6000);
		lop.PlayerMobileNumber(lop.getAlphaNumericString(10));
		lop.PlayerFirstName("Saurav");
		lop.PlayerLastName("Ganguly");
		lop.AddPLayerButtonClick();
		Thread.sleep(5000);	
		lop.Back();
		lop.Back();
		lop.Back();
		lop.TeamMenuClick();
		lop.TeamTwoClick();
		lop.OKButtonAddNewPlayerScreen();
		// Make debug point here and click on add player icon manually 
		lop.PlayerMobileNumber(lop.getAlphaNumericString(10));
		lop.PlayerFirstName("VV");
		Thread.sleep(2000);
		lop.PlayerLastName("Lax");
		lop.AddPLayerButtonClick();
		//lop.addplayerIconOnEditPageClick();
		//Thread.sleep(6000);
		lop.PlayerMobileNumber(lop.getAlphaNumericString(10));
		lop.PlayerFirstName("Saurav");
		lop.PlayerLastName("Ganguly");
		lop.AddPLayerButtonClick();
		Thread.sleep(5000);	
	}
	
	@Test
	public void AddPlayersInTeamFieldValidations() throws InterruptedException 
	{
		lop.countryCodeDropdown();
		Thread.sleep(2000);
		lop.countryCodeSelection();
		Thread.sleep(2000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(2000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
		Thread.sleep(3000);
		lop.MenuPathclick();
		Thread.sleep(2000); 
		lop.MyTournamentLinkClick();
		Thread.sleep(6000); 
		//lop.scrollPage();
		//Thread.sleep(6000);
		//lop.SelectOurTornamentClick();
		lop.selectOurTournamentWithoutScrollInPast();
		Thread.sleep(4000);
		lop.OKButtonOFAddNewTeamsClick();
		Thread.sleep(4000);
		lop.TeamMenuClick();
		//Thread.sleep(2000);
		//lop.OKButtonAddNewPlayerScreen();
		Thread.sleep(4000);
		lop.TeamOneClick();
		Thread.sleep(4000);
		//lop.OKButtonAddNewPlayerScreen();
		//Thread.sleep(3000);
		// Make debug point here and click on add player icon manually 
		lop.addplayerIconOnEditPageClick();
		Thread.sleep(4000);
		//lop.PlayerMobileNumber("1234567890123");
		//Thread.sleep(2000);
		lop.AddPLayerButtonClick();
		Thread.sleep(5000);
		Thread.sleep(4000);
		lop.AddPagePlayerFirstNamealidation();
		Thread.sleep(3000);
		//lop.AddPagePlayerMobileNumberLengthValidation();
		//Thread.sleep(5000);
		
	}
	
	@Test
	public void EditPlayersInTeam() throws InterruptedException 
	{
		lop.countryCodeDropdown();
		Thread.sleep(2000);
		lop.countryCodeSelection();
		Thread.sleep(2000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(2000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
		Thread.sleep(3000);
		lop.MenuPathclick();
		Thread.sleep(2000); 
		lop.MyTournamentLinkClick();
		Thread.sleep(6000); 
		//lop.scrollPage();
		//Thread.sleep(6000);
		//lop.SelectOurTornamentClick();
		lop.selectOurTournamentWithoutScrollInPast();
		Thread.sleep(15000);
		lop.OKButtonOFAddNewTeamsClick();
		Thread.sleep(4000);
		lop.TeamMenuClick();
		//Thread.sleep(2000);
		//lop.OKButtonAddNewPlayerScreen();
		Thread.sleep(4000);
		lop.TeamOneClick();
		Thread.sleep(4000);
		lop.ClickOnEditPlayer();
		Thread.sleep(4000);
		//lop.EditPagePlayerMobileNumber("7788552233");
		//Thread.sleep(2000);
		lop.EditPagePlayerFirstName("rinkal");
		Thread.sleep(2000);
		lop.EditPagePlayerLastName("pr");
		Thread.sleep(2000);
		lop.UpdatePLayerButtonClick();
		Thread.sleep(5000);
		lop.TeamOneClick();
		
	}
	@Test
	public void EditPlayersInTeamFieldValidations() throws InterruptedException 
	{
		lop.countryCodeDropdown();
		Thread.sleep(2000);
		lop.countryCodeSelection();
		Thread.sleep(2000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(2000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
		lop.MenuPathclick();
		Thread.sleep(2000); 
		lop.MyTournamentLinkClick();
		Thread.sleep(6000); 
		//lop.scrollPage();
		//Thread.sleep(6000);
		//lop.SelectOurTornamentClick();
		lop.selectOurTournamentWithoutScrollInPast();
		Thread.sleep(4000);
		lop.OKButtonOFAddNewTeamsClick();
		Thread.sleep(4000);
		lop.TeamMenuClick();
		//Thread.sleep(2000);
		//lop.OKButtonAddNewPlayerScreen();
		Thread.sleep(4000);
		lop.TeamOneClick();
		Thread.sleep(4000);
		lop.ClickOnEditPlayer();
		Thread.sleep(4000);
		//lop.EditPagePlayerMobileNumber("1234567890123");
		//Thread.sleep(2000);
		lop.EditPagePlayerFirstName("");
		Thread.sleep(3000);
		lop.EditPagePlayerLastName("");
		Thread.sleep(3000);
		lop.UpdatePLayerButtonClick();
		Thread.sleep(4000);
		lop.EditPagePlayerFirstNamealidation();
		Thread.sleep(3000);
		//lop.EditPagePlayerMobileNumberLengthValidation();
		//Thread.sleep(5000);
	}
	//============================Create Match/Round Section=====================//
	@Test
	public void CreateMatch() throws InterruptedException 
	{
		LoginToMenu();
		lop.MyTournamentLinkClick();
		Thread.sleep(3000); 
		//lop.scrollPage();
		//Thread.sleep(6000);
		//lop.SelectOurTornamentClick();
		lop.selectOurTournamentWithoutScrollInPast();
		lop.OKButtonOFAddNewTeamsClick();
		lop.addIconForAddMatchClick();
		lop.SelectRound();
		lop.GoButtonForRound();
		lop.CreateMatchSelectDropDownClick();
		lop.CreateMatchSelectPoolAClick();
		lop.TeamOneCameraClick();
	    lop.SelectTeamForCreateMatchClick();
	    lop.TeamTwoCameraClick();
	    lop.SelectTeamForCreateMatchClick();
	    lop.scrollPage();
	    lop.CreateMatchButtonClick();
	    Thread.sleep(5000);
	   
	}
	@Test
	public void EditMatch() throws InterruptedException 
	{
		lop.countryCodeDropdown();
		Thread.sleep(2000);
		lop.countryCodeSelection();
		Thread.sleep(2000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(2000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
		Thread.sleep(3000);
		//put debug , enter OTP and go further
		lop.MenuPathclick();
		Thread.sleep(2000); 
		lop.MyTournamentLinkClick();
		Thread.sleep(6000); 
		//lop.scrollPage();
		//Thread.sleep(6000);
		//lop.SelectOurTornamentClick();
		lop.selectOurTournamentWithoutScrollInPast();
		Thread.sleep(15000);
		lop.OKButtonOFAddNewTeamsClick();
		Thread.sleep(4000);
		lop.addIconForAddMatchClick();
		Thread.sleep(3000);
		lop.SelectRound();
		Thread.sleep(3000);
		lop.GoButtonForRound();
		Thread.sleep(5000);
		//lop.CreateMatchSelectDropDownClick();
		//Thread.sleep(3000);
		//lop.CreateMatchSelectPoolAClick();
		//Thread.sleep(3000);
	    lop.TeamOneCameraClick();
	    Thread.sleep(3000);
	    lop.SelectTeamForCreateMatchClick();
	    Thread.sleep(3000);
	    lop.TeamTwoCameraClick();
	    Thread.sleep(3000);
	    lop.SelectTeamForCreateMatchClick();
	    Thread.sleep(3000);
	    lop.scrollPage();
	    Thread.sleep(4000);
	    lop.CreateMatchButtonClick();
	    Thread.sleep(8000);
	   
	}
	
	//===============================Group=====================================//
	@Test
	public void CreateGroup() throws InterruptedException 
	{	
		
		CreateTournament();
		//lop.scrollPage();
		//Thread.sleep(6000);
		//lop.selectOurTournamentWithoutScrollInPast();
		//lop.SelectOurTornamentClick();
		//Thread.sleep(15);
		lop.OKButtonOFAddNewTeamsClick();
		lop.TeamMenuClick();
		//Thread.sleep(5);
		lop.TournamentAboutTab();
		//Thread.sleep(7);
		lop.TournamentAboutTab();
		//Thread.sleep(7);
		lop.TournamentPointsTab();
		//Thread.sleep(7);
		lop.TournamentPointsTab();
		//Thread.sleep(7);
		lop.TournamentGroupTab();
		Thread.sleep(3000);
		lop.AddGroupIcon();
		Thread.sleep(3000);
		lop.AddGroupName("TestGroup");
		lop.AddGroupButton();
		lop.VerifyAddGroupSuccessmessage();
		lop.AddGroupSuccessmessagePopUpOKButton();
		lop.EditGroupIconClick();
		lop.VerifyAddedGroupName();
		Thread.sleep(3000);
		
	}
	
	@Test
	public void DeleteGroup() throws InterruptedException 
	{	
		
		lop.countryCodeDropdown();
		Thread.sleep(3000);
		lop.countryCodeSelection();
		Thread.sleep(3000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(3000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
		Thread.sleep(4000);
		lop.MenuPathclick();
		Thread.sleep(4000); 
		lop.MyTournamentLinkClick();
		Thread.sleep(4000); 
		//lop.scrollPage();
		//Thread.sleep(6000);
		lop.selectOurTournamentWithoutScrollInPast();
		//lop.SelectOurTornamentClick();
		Thread.sleep(15000);
		lop.OKButtonOFAddNewTeamsClick();
		Thread.sleep(5000);
		lop.TournamentAboutTab();
		Thread.sleep(3000); 
		lop.TournamentPointsTab();
		Thread.sleep(3000);
		lop.TournamentGroupTab();
		Thread.sleep(3000);
		lop.AddGroupIcon();
		Thread.sleep(3000);
		lop.AddGroupName("DeleteGroup");
		Thread.sleep(3000);
		lop.AddGroupButton();
		Thread.sleep(3000);
		lop.VerifyAddGroupSuccessmessage();
		Thread.sleep(3000);
		lop.AddGroupSuccessmessagePopUpOKButton();
		Thread.sleep(3000);
		lop.DeleteIconGroupClick();
		Thread.sleep(3000);
		lop.VerifyDeleteGroupSuccessmessage();
		Thread.sleep(3000);
		lop.AddGroupDeleteMessagePopUpOKButton();
		Thread.sleep(3000);
		
		
	}
	@Test
	public void EditGroup() throws InterruptedException 
	{			
		lop.countryCodeDropdown();
		Thread.sleep(3000);
		lop.countryCodeSelection();
		Thread.sleep(3000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(3000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
		lop.MenuPathclick();
		Thread.sleep(5000); 
		lop.MyTournamentLinkClick();
		Thread.sleep(4000); 
		//lop.scrollPage();
		//Thread.sleep(6000);
		lop.selectOurTournamentWithoutScrollInPast();
		//lop.SelectOurTornamentClick();
		Thread.sleep(15000);
		lop.OKButtonOFAddNewTeamsClick();
		Thread.sleep(5000);
		lop.TournamentAboutTab();
		Thread.sleep(3000); 
		lop.TournamentPointsTab();
		Thread.sleep(3000);
		lop.TournamentGroupTab();
		Thread.sleep(3000);
		lop.AddGroupIcon();
		Thread.sleep(3000);
		lop.AddGroupName("EditGroupTest");
		Thread.sleep(3000);
		lop.AddGroupButton();
		Thread.sleep(3000);
		lop.VerifyAddGroupSuccessmessage();
		Thread.sleep(3000);
		lop.AddGroupSuccessmessagePopUpOKButton();
		Thread.sleep(7000);
		lop.EditGroupIconClick();
		Thread.sleep(4000);
		lop.SelectFirstTeamInGroup();
		Thread.sleep(4000);
		lop.EditGroupIconInsideSaveButtonClick();
		Thread.sleep(4000);
		lop.VerifyMessageAddedTeamInGroup();
		Thread.sleep(4000);
		lop.VerifyMessageAddedTeamInGroupPopUpOKBUtton();
		Thread.sleep(4000);
		/*lop.VerifyAddedGroupName();
		Thread.sleep(3000);	
		lop.EditGroupIconInsideClick();
		Thread.sleep(3000);	
		lop.EditGroupNameInsideEditPage("EditGroupTest");
		Thread.sleep(3000);	
		lop.EditGroupIconInsideSaveButtonClick();
		Thread.sleep(3000);	*/
		//lop.CancelGroupIconInsideClick();
		//Thread.sleep(3000);			
	}
	@Test
	public void EditGroupSearchTeam() throws InterruptedException 
	{			
		lop.countryCodeDropdown();
		Thread.sleep(3000);
		lop.countryCodeSelection();
		Thread.sleep(3000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(3000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
		lop.MenuPathclick();
		Thread.sleep(5000); 
		lop.MyTournamentLinkClick();
		Thread.sleep(4000); 
		//lop.scrollPage();
		//Thread.sleep(6000);
		lop.selectOurTournamentWithoutScrollInPast();
		//lop.SelectOurTornamentClick();
		Thread.sleep(15000);
		lop.OKButtonOFAddNewTeamsClick();
		Thread.sleep(5000);
		lop.TournamentAboutTab();
		Thread.sleep(3000); 
		lop.TournamentPointsTab();
		Thread.sleep(3000);
		lop.TournamentGroupTab();
		Thread.sleep(3000);
		lop.AddGroupIcon();
		Thread.sleep(3000);
		lop.AddGroupName("EditGroupTest");
		Thread.sleep(3000);
		lop.AddGroupButton();
		Thread.sleep(3000);
		lop.VerifyAddGroupSuccessmessage();
		Thread.sleep(3000);
		lop.AddGroupSuccessmessagePopUpOKButton();
		Thread.sleep(7000);
		lop.EditGroupIconClick();
		Thread.sleep(4000);
		lop.SelectFirstTeamInGroup();
		Thread.sleep(4000);
		lop.EditGroupIconInsideSaveButtonClick();
		Thread.sleep(4000);
		lop.VerifyMessageAddedTeamInGroup();
		Thread.sleep(4000);
		lop.VerifyMessageAddedTeamInGroupPopUpOKBUtton();
		Thread.sleep(4000);
		/*lop.VerifyAddedGroupName();
		Thread.sleep(3000);	
		lop.EditGroupIconInsideClick();
		Thread.sleep(3000);	
		lop.EditGroupNameInsideEditPage("EditGroupTest");
		Thread.sleep(3000);	
		lop.EditGroupIconInsideSaveButtonClick();
		Thread.sleep(3000);	*/
		//lop.CancelGroupIconInsideClick();
		//Thread.sleep(3000);			
	}
	
	@Test
	public void MandatoryGroupNameVerification() throws InterruptedException 
	{			
		lop.countryCodeDropdown();
		Thread.sleep(3000);
		lop.countryCodeSelection();
		Thread.sleep(3000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(3000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
		lop.MenuPathclick();
		Thread.sleep(2000); 
		lop.MyTournamentLinkClick();
		Thread.sleep(4000); 
		//lop.scrollPage();
		//Thread.sleep(6000);
		lop.selectOurTournamentWithoutScrollInPast();
		//lop.SelectOurTornamentClick();
		Thread.sleep(7000);
		lop.OKButtonOFAddNewTeamsClick();
		Thread.sleep(5000);
		lop.TournamentAboutTab();
		Thread.sleep(3000); 
		lop.TournamentPointsTab();
		Thread.sleep(3000);
		lop.TournamentGroupTab();
		Thread.sleep(3000);
		lop.AddGroupIcon();
		Thread.sleep(3000);
		//lop.AddGroupName(" ");
		//Thread.sleep(3000);
		lop.AddGroupButton();
		Thread.sleep(3000);
		//lop.VerifyAddGroupSuccessmessage();
		//Thread.sleep(3000);
		lop.VerifyAddGroupMandatorymessage();
		Thread.sleep(3000);
	}
	
	@Test
	public void LengthGroupNameVerification() throws InterruptedException 
	{			
		lop.countryCodeDropdown();
		Thread.sleep(3000);
		lop.countryCodeSelection();
		Thread.sleep(3000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(3000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
		lop.MenuPathclick();
		Thread.sleep(2000); 
		lop.MyTournamentLinkClick();
		Thread.sleep(4000); 
		//lop.scrollPage();
		//Thread.sleep(6000);
		lop.selectOurTournamentWithoutScrollInPast();
		//lop.SelectOurTornamentClick();
		Thread.sleep(7000);
		lop.OKButtonOFAddNewTeamsClick();
		Thread.sleep(5000);
		lop.TournamentAboutTab();
		Thread.sleep(3000); 
		lop.TournamentPointsTab();
		Thread.sleep(3000);
		lop.TournamentGroupTab();
		Thread.sleep(3000);
		lop.AddGroupIcon();
		Thread.sleep(3000);
		lop.AddGroupName("");
		Thread.sleep(3000);
		lop.AddGroupButton();
		Thread.sleep(3000);
		lop.VerifyAddGroupLengthMessage();
		Thread.sleep(3000);	
		lop.GroupNameLengthMessagePopUpOKButton();
		Thread.sleep(3000);	
	}
	//===============================Gallery=======================================//
	@Test
	public void Gallery() throws InterruptedException 
	{			
		lop.countryCodeDropdown();
		Thread.sleep(3000);
		lop.countryCodeSelection();
		Thread.sleep(3000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(3000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
		lop.MenuPathclick();
		Thread.sleep(4000); 
		lop.MyTournamentLinkClick();
		Thread.sleep(4000); 
		//lop.scrollPage();
		//Thread.sleep(6000);
		lop.selectOurTournamentWithoutScrollInPast();
		//lop.SelectOurTornamentClick();
		Thread.sleep(15000);
		lop.OKButtonOFAddNewTeamsClick();
		Thread.sleep(5000);
		lop.ClickOnGallery();
		Thread.sleep(5000);
		lop.UploadPhotoButtonClick();
		Thread.sleep(4000);
		lop.UploadPhotoCameraButtonClick();
		Thread.sleep(4000);
		lop.UploadPhotoInGallery();
		Thread.sleep(4000);
		lop.DeletePhotoClickinGallery();
		Thread.sleep(4000);
		lop.VerifyEmptyGalleryMessage();
		Thread.sleep(4000);		
	}
	//=======================Toss===========================================//
	@Test
	public void Toss() throws InterruptedException 
	{			
		lop.countryCodeDropdown();
		Thread.sleep(3000);
		lop.countryCodeSelection();
		Thread.sleep(3000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(3000);
		lop.getOTPButton();
		Thread.sleep(4000);
		lop.otp("1","2","3","4");
		lop.MenuPathclick();
		Thread.sleep(4000); 
		lop.TossClick();
		Thread.sleep(4000); 
	}
	  
	//=======================Play Match===========================================//
	@Test
	public void StartSchedualMatch() throws InterruptedException 
	{
	    LoginToMenu();
		lop.MyTournamentLinkClick();
		Thread.sleep(3000); 
		//lop.scrollPage();
		//Thread.sleep(6000);
		//lop.SelectOurTornamentClick();
		lop.selectOurTournamentWithoutScrollInPast();
		Thread.sleep(10000); 
		lop.PlayIconClick();
		Thread.sleep(4000);
		lop.FirstTeamClick();
		Thread.sleep(2000);
		lop.SelectBatClick();
		Thread.sleep(2000);
		lop.GoClick();
		Thread.sleep(4000);
		lop.MaxOver();
		Thread.sleep(2000);
		lop.PowerPlay();
		Thread.sleep(2000);
		lop.MaxPlayer();
		Thread.sleep(2000);
		lop.FirstTeamSquadClick();
		Thread.sleep(2000);
		lop.SelectFirstPlayerFromFirstSquad();
		Thread.sleep(2000);
		lop.SelectSecondPlayerFromFirstSquad();
		Thread.sleep(2000);
		lop.SelectFirstPlayerAsCaptianFromFirstSquad();
		Thread.sleep(2000);
		lop.SelectSecondPlayerAsVCFromFirstSquad();
		Thread.sleep(2000);
		lop.Back();
		Thread.sleep(3000);
		lop.SecondTeamSquadClick();
		Thread.sleep(3000);
		lop.SelectFirstPlayerFromSecondSquad();
		Thread.sleep(3000);
		lop.SelectSecondPlayerFromSecondSquad();
		Thread.sleep(3000);
		lop.SelectFirstPlayerAsCaptianFromSecondSquad();
		Thread.sleep(3000);
		lop.SelectSecondPlayerAsVCFromSecondSquad();
		Thread.sleep(3000);
		lop.Back();
		Thread.sleep(3000);
		lop.GoButtonOnSelectSquad();
		Thread.sleep(10000);
	}
	
	//======================================Profile=======================================//
	
	@Test
	public void Profile() throws InterruptedException 
	{
		LoginToMenu();
		lop.ProfileIconClick();
		lop.EditProfileIconClick();	
		lop.scrollPage();		
		lop.scrollPage();	
		lop.scrollPage();
		lop.ProfileLocation();
		lop.ProfileEmailId();
		lop.ProfileGender();
		lop.ProfileWeight();
		lop.ProfileBatsman();
		lop.ProfileUpdateButton();
		lop.ProfileUpdateSuccessMsg();
		lop.ProfileUpdateSuccessMsgOKButton();	
		lop.EditProfileIconClick();
		String firstName=lop.EditProfileFirstName();
		String lastName=lop.EditProfileLastName();
		lop.scrollPage();		
		lop.scrollPage();	
		lop.ProfileUpdateButton();
		lop.ProfileUpdateSuccessMsg();
		lop.ProfileUpdateSuccessMsgOKButton();
		//lop.VerifyProfileLocation("Surat, Gujarat, India");
		lop.EditProfileIconClick();
		lop.VerifyEditProfileLastName(lastName);
		lop.VerifyEditProfileFirstName(firstName);
		lop.scrollPage();	
		lop.scrollPage();
		lop.VerifyProfileEmailId("aakash.pra@gmail.com");
		lop.VerifyProfileGender("Male");
		lop.VerifyProfileWeight("70");
		lop.VerifyProfileBatsman("Batsman");		
	}
	
	@Test
	public void VerifyProfileFirstNameMandatory() throws InterruptedException 
	{
		LoginToMenu();
		lop.ProfileIconClick();
		lop.EditProfileIconClick();	
		lop.EditProfileFirstNameMandatory();
	}
	@Test
	public void VerifyProfileLastNameMandatory() throws InterruptedException 
	{
		LoginToMenu();
		lop.ProfileIconClick();
		lop.EditProfileIconClick();	
		lop.EditProfileLastNameMandatory();
	}
	@Test
	public void VerifyProfileEmailIdValidation() throws InterruptedException 
	{
		LoginToMenu();
		lop.ProfileIconClick();
		lop.EditProfileIconClick();	
		lop.EditProfileEmailIDValidation();
	}
	@Test
	public void VerifyProfileWeightValidation() throws InterruptedException 
	{
		LoginToMenu();
		lop.ProfileIconClick();
		lop.EditProfileIconClick();	
		lop.EditProfileWeightValidation();
	}
	//=============================================================================//
	@Test
	public void LoginToMenu() throws InterruptedException 
	{
		lop.countryCodeDropdown();
		lop.countryCodeSelection();
		lop.privacyPolicyCheckbox();
		lop.getOTPButton();
		lop.otp("1","2","3","4");
		
		lop.firstNameTextbox();
		lop.LastNameTextbox();
		lop.updateButtonclick();
		
		lop.MenuPathclick();
	}
	
	@AfterTest 
	  public void teardown() {
		  
		  driver.quit();
		  service.stop();
	  
	  }
	 
}
