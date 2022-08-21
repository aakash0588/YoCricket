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
	  
	  public String getOtpButton2="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup";
	  public String submitOtp="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup";
	  public String mobileNumbarManadatoryMessage="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView";
	  public String mobileNumberMaxDigitMessage="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView";
	  public String countryCode="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView";
	  public String flag = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView";
	  public String countryListFrame = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView";
	  
	  AppiumDriverLocalService service ;
	  //= new  AppiumServiceBuilder().withAppiumJS(new
			  //File("C:\\Program Files\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js" )).withIPAddress("127.0.0.1").usingPort(4723).build();
	  
	  @BeforeTest 
	  public void setup() throws MalformedURLException, InterruptedException {
	  
	   
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability(MobileCapabilityType.APP,"C:\\Users\\LAPCARE-PC\\eclipse-workspace\\AppiumProject\\src\\test\\java\\resources\\yoCricket (4).apk"); 
	  caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
	  caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
	  caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android SDK built for x86_64");
	  caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
	  caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
	  caps.setCapability("autoGrantPermissions", "true");
	  URL url = new	  URL("http://127.0.0.1:4723/wd/hub");
	  
	  driver = new AppiumDriver<MobileElement> (url,caps);
	  lop = new LoginOtpPageElement(driver);
	  service = lop.serviceStart(service);
	  service.start();
	  Thread.sleep(7000);

	  }
	  
	  //=============================================Login & OTP  Section============================================
	  
	@Test
	public void internetOffTest() throws InterruptedException 
	{
		try 
		{
			lop.countryCodeDropdown();
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
		  String msg2 =driver.findElement(By.xpath(mobileNumberMaxDigitMessage)).getText();
		  Thread.sleep(2000);
		  assertEquals(msg2,"Mobile number should be of 10 digits", "Validation Message not match with expected");
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
		
	//===================================Tournament Section==========================================//
	
	@Test
	public void CreateTournament() throws InterruptedException 
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
		//String invalidAlertMsg = lop.VerifyInalidOtpMessage();
		//assertEquals(invalidAlertMsg,"Please enter a valid OTP.", "Text is not correct");
		
		//lop.validOtpAlertOKButtonclick();
		//Thread.sleep(3000);
		
		//lop.firstNameTextbox();
		//lop.LastNameTextbox();
		//lop.updateButtonclick();
		lop.MenuPathclick();
		Thread.sleep(2000); 
		lop.CreateTournamentLinkclick();
		Thread.sleep(3000); 
		//lop.UploadProfilePhoto();
		//Thread.sleep(4000); 
		//lop.ClickToUploadMainPhoto();
		//Thread.sleep(4000); 
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
		Thread.sleep(3000);
		lop.createtournamentStartDateIcon().click();
		Thread.sleep(2000);
		lop.createtournamentSelectStartDate("20 August 2022");
		Thread.sleep(2000);
		lop.createtournamentSelecrStartDateOKButton().click(); 
		Thread.sleep(2000);
		lop.TournamentCategoryclick();
		Thread.sleep(2000);
		lop.CreateTournamentButtonclick();
		Thread.sleep(2000);		 
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
		lop.scrollPage();
		Thread.sleep(6000);
		lop.SelectOurTornamentClick();
		Thread.sleep(4000);
		lop.OKButtonOFAddNewMatchClick();
		Thread.sleep(5000);
		lop.TournamentAboutTab();
		Thread.sleep(3000); 
		lop.tournamnetEditIconClick();
		Thread.sleep(3000); 
		lop.EditTournamentClickToUploadMainPhoto();
		Thread.sleep(4000); 
		lop.EditTornamentUploadProfilePhoto();
		Thread.sleep(4000); 
		lop.EditTournamentNameTextbox("IPL123#");
		Thread.sleep(2000); 
		lop.EditLocationNameTextbox();
		Thread.sleep(2000);
		lop.EditArenaNameTextbox();
		Thread.sleep(2000);
		lop.scrollPage();
		Thread.sleep(3000); 
		lop.EditOrganiserNameTextbox("LionsClub123#");
		Thread.sleep(2000); 
		lop.EditOrganiserContactTextbox("9825964420");
		Thread.sleep(3000);
		lop.EdittournamentStartDateIcon().click();
		Thread.sleep(2000);
		lop.createtournamentSelectStartDate("20 August 2022");
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
		lop.scrollPage();
		Thread.sleep(6000);
		lop.SelectOurTornamentClick();
		Thread.sleep(4000);
		lop.OKButtonOFAddNewMatchClick();
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
		lop.createtournamentSelectStartDate("20 August 2022");
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
		lop.scrollPage();
		Thread.sleep(6000);
		lop.SelectOurTornamentClick();
		Thread.sleep(4000);
		lop.OKButtonOFAddNewMatchClick();
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
		lop.scrollPage();
		Thread.sleep(6000);
		lop.SelectOurTornamentClick();
		Thread.sleep(4000);
		lop.OKButtonOFAddNewMatchClick();
		Thread.sleep(5000);
		lop.TeamMenuClick();
		Thread.sleep(2000);
		lop.addIconForTeamClick();
		Thread.sleep(2000);
		lop.addINewTeamClick();
		Thread.sleep(4000);
		lop.EnterTeamName("Ring");
		Thread.sleep(3000);
		lop.EnterTeamCity("Vado");
		Thread.sleep(3000);
		lop.ClickToUploadTeamPhoto();
		Thread.sleep(3000);
		lop.AddTeamButtonClick();
		Thread.sleep(8000);
	}
	
	@Test
	public void CreateTeamPaeValidation() throws InterruptedException 
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
		lop.scrollPage();
		Thread.sleep(6000);
		lop.SelectOurTornamentClick();
		Thread.sleep(4000);
		lop.OKButtonOFAddNewMatchClick();
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
		lop.AddTeamButtonClick2();
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
		lop.scrollPage();
		Thread.sleep(6000);
		lop.SelectOurTornamentClick();
		Thread.sleep(4000);
		lop.OKButtonOFAddNewMatchClick();
		Thread.sleep(5000);
		lop.TeamMenuClick();
		Thread.sleep(3000);
		lop.TeamOneClick();
		Thread.sleep(3000);
		lop.OKButtonAddNewPlayerScreen();
		Thread.sleep(3000);
		lop.EditTeamName("Rin");
		Thread.sleep(3000);
		lop.EditTeamCity("raj");
		Thread.sleep(3000);
		lop.EditClickToUploadTeamPhoto();
		Thread.sleep(3000);
		lop.EditSaveTeamButtonClick();
		Thread.sleep(4000);
	}
	
	@Test
	public void EditTeamValidations() throws InterruptedException 
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
		lop.scrollPage();
		Thread.sleep(6000);
		lop.SelectOurTornamentClick();
		Thread.sleep(4000);
		lop.OKButtonOFAddNewMatchClick();
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
		lop.EditTeamName("Rin");
		Thread.sleep(3000);
		lop.EditSaveTeamButtonClick();
		Thread.sleep(3000);
	}
	
	//===============================Player Section==========================//
	
	@Test
	public void AddPlayersInTeam() throws InterruptedException 
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
		lop.scrollPage();
		Thread.sleep(6000);
		lop.SelectOurTornamentClick();
		Thread.sleep(4000);
		lop.OKButtonOFAddNewMatchClick();
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
		lop.PlayerMobileNumber("1236956124");
		Thread.sleep(2000);
		lop.PlayerFirstName("VV");
		Thread.sleep(2000);
		lop.PlayerLastName("Lax");
		Thread.sleep(2000);
		lop.AddPLayerButtonClick();
		Thread.sleep(5000);
		//lop.addplayerIconOnEditPageClick();
		//Thread.sleep(6000);
		//lop.PlayerMobileNumber("1236956655");
		//Thread.sleep(2000);
		//lop.PlayerFirstName("Saurav");
		//Thread.sleep(2000);
		//lop.PlayerLastName("Ganguly");
		//Thread.sleep(2000);
		//lop.AddPLayerButtonClick();
		//Thread.sleep(6000);	
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
		lop.scrollPage();
		Thread.sleep(6000);
		lop.SelectOurTornamentClick();
		Thread.sleep(4000);
		lop.OKButtonOFAddNewMatchClick();
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
		lop.PlayerMobileNumber("1234567890123");
		Thread.sleep(2000);
		lop.AddPLayerButtonClick();
		Thread.sleep(5000);
		Thread.sleep(4000);
		lop.AddPagePlayerFirstNamealidation();
		Thread.sleep(3000);
		lop.AddPagePlayerMobileNumberLengthValidation();
		Thread.sleep(5000);
		
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
		lop.scrollPage();
		Thread.sleep(6000);
		lop.SelectOurTornamentClick();
		Thread.sleep(4000);
		lop.OKButtonOFAddNewMatchClick();
		Thread.sleep(4000);
		lop.TeamMenuClick();
		//Thread.sleep(2000);
		//lop.OKButtonAddNewPlayerScreen();
		Thread.sleep(4000);
		lop.TeamOneClick();
		Thread.sleep(4000);
		lop.ClickOnEditPlayer();
		Thread.sleep(4000);
		lop.EditPagePlayerMobileNumber("7788552233");
		Thread.sleep(2000);
		lop.EditPagePlayerFirstName("VVvv");
		Thread.sleep(2000);
		lop.EditPagePlayerLastName("Laxxx");
		Thread.sleep(2000);
		lop.UpdatePLayerButtonClick();
		Thread.sleep(5000);
		
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
		Thread.sleep(3000);
		lop.MenuPathclick();
		Thread.sleep(2000); 
		lop.MyTournamentLinkClick();
		Thread.sleep(6000); 
		lop.scrollPage();
		Thread.sleep(6000);
		lop.SelectOurTornamentClick();
		Thread.sleep(4000);
		lop.OKButtonOFAddNewMatchClick();
		Thread.sleep(4000);
		lop.TeamMenuClick();
		//Thread.sleep(2000);
		//lop.OKButtonAddNewPlayerScreen();
		Thread.sleep(4000);
		lop.TeamOneClick();
		Thread.sleep(4000);
		lop.ClickOnEditPlayer();
		Thread.sleep(4000);
		lop.EditPagePlayerMobileNumber("1234567890123");
		Thread.sleep(2000);
		lop.EditPagePlayerFirstName("");
		Thread.sleep(2000);
		lop.EditPagePlayerLastName("");
		Thread.sleep(3000);
		lop.UpdatePLayerButtonClick();
		Thread.sleep(4000);
		lop.EditPagePlayerFirstNamealidation();
		Thread.sleep(3000);
		lop.EditPagePlayerMobileNumberLengthValidation();
		Thread.sleep(5000);
	}
	//============================Create Match/Round Section=====================//
	@Test
	public void CreateMatch() throws InterruptedException 
	{
		lop.countryCodeDropdown();
		Thread.sleep(2000);
		lop.countryCodeSelection();
		Thread.sleep(2000);
		lop.privacyPolicyCheckbox();
		Thread.sleep(2000);
		lop.getOTPButton();
		Thread.sleep(4000);
		//put debug , enter OTP and go further
		lop.MenuPathclick();
		Thread.sleep(2000); 
		lop.MyTournamentLinkClick();
		Thread.sleep(6000); 
		lop.scrollPage();
		Thread.sleep(6000);
		lop.SelectOurTornamentClick();
		Thread.sleep(4000);
		lop.OKButtonOFAddNewMatchClick();
		Thread.sleep(4000);
		lop.addIconForAddMatchClick();
		Thread.sleep(3000);
		lop.SelectRound();
		Thread.sleep(3000);
		lop.GoButtonForRound();
		Thread.sleep(5000);
		lop.CreateMatchSelectDropDownClick();
		Thread.sleep(3000);
		lop.CreateMatchSelectPoolAClick();
		Thread.sleep(3000);
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
	  @AfterTest 
	  public void teardown() {
		  
		  driver.quit();
		  service.stop();
	  
	  }
	 
}
