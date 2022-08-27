package pages;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.EventListener;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.io.Files;

import utilities.ReadConfig;

public class BasePage {
	
	ReadConfig readConfig = new ReadConfig();

    public String baseURL = readConfig.getBaseUrl();
    public String userEmail = readConfig.getUserEmail();
    public String password = readConfig.getPassword();
    public String browser = readConfig.getBrowser();
    public String contactPerson = readConfig.getContactPerson();
    public String organization = readConfig.getOrganization();
    public String dealValue = readConfig.getDealValue();
    public String currency = readConfig.getCurrency();
    public String phone = readConfig.getPhone();
    public String phonetype = readConfig.getPhoneType();
    public String email = readConfig.getEmail();
    public String emailtype = readConfig.getEmailType();
    public String meetingStartDate = readConfig.getMeetingStartDate();
    public String meetingStartTime = readConfig.getMeetingStartTime();
    public String meetingEndDate = readConfig.getMeetingEndDate();
    public String meetingEndTime = readConfig.getMeetingEndDate();
    public List<String> guestsList = readConfig.getMeetingGuests();
    public String meetingLocation = readConfig.getMeetingLocation();
    public String meetingDescription = readConfig.getMeetingDescription();
    public String meetingNotes = readConfig.getMeetingNotes();
    public String meetingTitle = readConfig.getMeetingTitle();
    public String dealCloseDate = readConfig.getDealCloseDate();
    public String changeDealCloseDate = readConfig.getChangeDealCloseDate();


    
    public WebDriver driver;
    
    @BeforeClass
    public  void launchDriver() {
        if(browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
            
            ChromeOptions opt = new ChromeOptions();
            opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
            opt.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
            driver = new ChromeDriver(opt);
        }

        if(browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath());
            driver = new FirefoxDriver();
        }

        if(browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver",readConfig.getEdgePath());
            driver = new EdgeDriver();
            }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.get(baseURL);
    }
    
    public void scrollIntoView(WebDriver driver, WebElement element) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    
    public String screenShot(WebDriver driver, String filename) throws IOException {
        TakesScreenshot ts =  (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dst = new File("../Screenshots/"+filename+".png");
        Files.copy(src,dst);
        System.out.println("Screenshot Taken");
        return filename;
    }
  
    public void explicitWait(WebElement e) {

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(e));
        
    }
    
    public void acceptAlert(WebDriver webdriver) {
    	try {
    		webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    		} catch (org.openqa.selenium.UnhandledAlertException f) {
    	    try {
    	        Alert alert = webdriver.switchTo().alert();
    	        String alertText = alert.getText();
    	        System.out.println("Alert data: " + alertText);
    	        alert.accept();
    	    } catch (NoAlertPresentException e) {
    	        e.printStackTrace();
    	    }
    	}
    }
    	
        
     
    
    @AfterClass
    public void tearDown() {
        //driver.quit();
    }

}
