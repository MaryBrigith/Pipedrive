package pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ManageDealPage extends BasePage {
	
	public ManageDealPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath = "//div/a[@href='/deal/1']")
    @CacheLookup
    WebElement MyDeal;
	
	
	@FindBy(xpath = "//span[text()='Notes']")
    @CacheLookup
    WebElement Notes;
	
	@FindBy(xpath = "//div[@class='bodyEditor']")
    @CacheLookup
    WebElement NotesEdit;
	
	@FindBy(xpath = "//span[text()='Notes']")
    @CacheLookup
    WebElement NotesSave;
	
    @FindBy(xpath = "//span[text()='Activity']")
    @CacheLookup
    WebElement Activity;
    
    @FindBy(xpath = "//div[contains(@class,'ieodm8-4 hkUdzy')]/div/input")
    @CacheLookup
    WebElement ActivityCall;
    
    @FindBy(xpath = "(//div[contains(@class,'ieodm8-2 dFJCOW')]/button)[2]")
    @CacheLookup
    WebElement ActivityMeetingButton;
    
    @FindBy(xpath = "//div[contains(@class,'ieodm8-4 hkUdzy')]/div/input")
    @CacheLookup
    WebElement ActivityMeetingInput;
    
    @FindBy(xpath = "//button[contains(@class,'1ois2jh-4 kTLlsO')]/span[text()='Save']")
    @CacheLookup
    WebElement ActivityMeetingSave;
    
    @FindBy(xpath = "(//div[contains(@class,'1ura0dj-0 chtILt')]/span/div/div/input)[1]")
    @CacheLookup
    WebElement ActivityMeetingStartDate;
    
    @FindBy(xpath = "(//div[contains(@class,'1ura0dj-0 chtILt')]/span/div/div/div/input)[1]")
    @CacheLookup
    WebElement ActivityMeetingStartTime;
    
    @FindBy(xpath = "(//div[contains(@class,'1ura0dj-0 chtILt')]/span/div/div/input)[2]")
    @CacheLookup
    WebElement ActivityMeetingEndDate;
    
    @FindBy(xpath = "(//div[contains(@class,'1ura0dj-0 chtILt')]/span/div/div/div/input)[2]")
    @CacheLookup
    WebElement ActivityMeetingEndTime;
    
    @FindBy(xpath = "//div[contains(@class,'ieodm8-5 PcwKn')][1]")
    @CacheLookup
    WebElement MeetingGuests;
    
    @FindBy(xpath = "(//div[contains(@class,'ieodm8-9 iPnnXg')])[1]")
    @CacheLookup
    WebElement MeetingGuestsLink;
    
    @FindBy(xpath = "//div[contains(@class,'1b2xpky-0 fbQnCB')]/div/input")
    @CacheLookup
    WebElement MeetingGuestsInput;
    
    @FindBy(xpath = "//div[contains(text(),'Location')]")
    @CacheLookup
    WebElement MeetingLocation;
    
    @FindBy(xpath = "(//div[contains(@class,'ieodm8-9 iPnnXg')])[2]")
    @CacheLookup
    WebElement MeetingLocationLink;
    
    @FindBy(xpath = "//div[contains(@class,'LocationInput-sc-wkdudv-0 glwsmh')]//input")
    @CacheLookup
    WebElement MeetingLocationInput;
    
    @FindBy(xpath = "//div[contains(@class,'ff_v882__InputSelect__suggestion__nwT')]//span")
    @CacheLookup
    List<WebElement> LocationSuggestion;
    
    @FindBy(xpath = "//div[contains(text(),'Description')]")
    @CacheLookup
    WebElement MeetingDescription;
    
    @FindBy(xpath = "(//div[contains(@class,'PublicDescription-sc-ieodm8-17')]/div)[1]")
    @CacheLookup
    WebElement MeetingDescriptionInput;
    
    @FindBy(xpath = "(//div[contains(@class,'Description')]//button[contains(@class,'toolbar_italic')])")
    @CacheLookup
    WebElement DescriptionItalicToolbar;
 
    @FindBy(xpath = "//div[contains(@class,'ePtzFE bodyEditor activityNote')]")
    @CacheLookup
    WebElement MeetingNotes;
    
    @FindBy(xpath = "(//div[contains(@class,'NotesWysiwyg')]//button[contains(@class,'toolbar_bold')])")
    @CacheLookup
    WebElement NotesBoldToolbar;
    
    @FindBy(xpath = "//a[@class='scheduleButton-flow']")
    @CacheLookup
    WebElement ProposeTime;
    
    @FindBy(xpath = "//a/span[text()='Call']")
    @CacheLookup
    WebElement Call;
    
    @FindBy(xpath = "//a/span[text()='Email']")
    @CacheLookup
    WebElement Email;
    
    @FindBy(xpath = "//a/span[text()='Files']")
    @CacheLookup
    WebElement Files;
    
    @FindBy(xpath = "//a/span[text()='Documents']")
    @CacheLookup
    WebElement Documents;
    
    @FindBy(xpath = "//a[@class='invoiceButton-flow']")
    @CacheLookup
    WebElement Invoice;
    
	@FindBy(xpath = "//button[@id='pipeButton-3iOi6vSN']")
    @CacheLookup
    WebElement WonButton;
	
	@FindBy(xpath = "//button[@id='pipeButton-Nc6zemO8']")
    @CacheLookup
    WebElement LostButton;
	
	@FindBy(xpath = "//button[contains(@class,'SaveButton')]")
    @CacheLookup
    WebElement SaveButton;
	
	@FindBy(xpath = "//span[contains(@class,'selectSettings')]/button")
    @CacheLookup
    WebElement PipeButton;
	
    @FindBy(xpath = "//div[contains(@class,'cui5StyleDropdown ')]//div[@class='cui5-option ']/span")
    @CacheLookup
    List<WebElement> PipeButtonOptions;
    
    @FindBy(xpath = "//div[contains(@class,'flowItemContainer activity')]//span//a")
    @CacheLookup
    List<WebElement> PlannedActivities;
    
    @FindBy(xpath = "//div[@class='flowFiltersWrapper']//li[text()='Activities']")
    @CacheLookup
    WebElement Activities;
    
    @FindBy(id = "pipeButton-glEpEr5P")
    @CacheLookup
    WebElement DoneActivityPipeButton;
    
    @FindBy(xpath = "//div[contains(@class,'dropMenuVisible')]//li[@class='delete']")
    @CacheLookup
    WebElement DoneActivityDelete;
    
    @FindBy(xpath = "//div[contains(@class,'dialog__actions')]//span[text()='Delete']")
    @CacheLookup
    WebElement ConfirmDeleteButton;
    
    @FindBy(xpath = "//div[@class='expectedCloseDateWrapper link']")
    @CacheLookup
    WebElement ExpectedCloseDate;
    
    @FindBy(xpath = "//div[@class='valueWrap clearfix date']//input[@name='expected_close_date']")
    @CacheLookup
    WebElement CloseDateInput;
    
    @FindBy(xpath = "//div[@class='actions']//a/span[text()='Save']")
    @CacheLookup
    WebElement CloseDateSaveButton;
    
    @FindBy(xpath = "(//div[@class='expectedCloseDateWrapper']/span)[2]")
    @CacheLookup
    WebElement setExpectedCloseDate;
    
    @FindBy(xpath = "//div[@class='actions']//a[contains(@class,'action remove')]")
    @CacheLookup
    WebElement CloseDateDeleteButton;
    
    @FindBy(xpath = "//a[contains(@href,'/users/details/')]//div[@class='info']")
    @CacheLookup
    WebElement userLabel;
    
    public WebElement getMyDeal() {
    	return MyDeal;
    }
    
    public WebElement getUserLabel() {
		return userLabel;
	}
    
    public void clickMyDeal() {
    	MyDeal.click();
    }
    
    public void clickOnNotes( ) {
    	Notes.click();
    }
   
    
    public void clickOnNotesSave() {
    	NotesSave.click();
    }
    
    public void setNotes(String notes) {
    	NotesEdit.sendKeys(notes);
    }
    
    public void clickActivity() {
    	Activity.click();
    }
    
    public WebElement getActivityButton() {
    	return ActivityMeetingButton;
    }
    
    public void clickMeeting() {
    	ActivityMeetingButton.click();
    }
    
    public void setMeetingTitle(String title) {
    	ActivityMeetingInput.sendKeys(title);
    }
    
    public void setMeetingStartDate(String startDate) {
    	ActivityMeetingStartDate.sendKeys(startDate);
    }
    
    public void setMeetingStartTime(String startTime) {
    	ActivityMeetingStartTime.sendKeys(startTime);
    }
    
    public void setMeetingEndTime(String endTime) {
    	ActivityMeetingEndTime.sendKeys(endTime);
    }
    
    public void setMeetingEndDate(String endDate) {
    	ActivityMeetingEndDate.sendKeys(endDate);
    }
    
    public void setMeetingGuests(List<String> meetingGuests) {
    	MeetingGuests.click();
		MeetingGuestsLink.click();

    	for(String guest : meetingGuests) {
    		MeetingGuestsInput.sendKeys(guest +",");
    	}
    	MeetingGuestsInput.sendKeys(Keys.TAB);
    }
    
    public void setMeetingLocation(String location) {
    	MeetingLocation.click();
    	MeetingLocationInput.sendKeys(location);
    	MeetingLocationInput.sendKeys(Keys.DOWN);
    	LocationSuggestion.get(2).click();;
    	MeetingLocationInput.sendKeys(Keys.TAB);
    	
    }
    
    public void setMeetingDescription(String description) {
    	MeetingDescription.click();
    	DescriptionItalicToolbar.click();
    	MeetingDescriptionInput.sendKeys(description);
    	
    }
    
    public void setMeetingNotes(String notes) {
    	MeetingNotes.click();
    	NotesBoldToolbar.click();
    	MeetingNotes.sendKeys(notes);
    	
    }
    
    public void clickSaveButton() {
    	SaveButton.click();
    	
    }
    
    public void verifyPlannedMeeting(String meetingTitle) {
    	for(WebElement e : PlannedActivities) {
    		System.out.println(e.getText());
            if(e.getText().equalsIgnoreCase(meetingTitle)) {
            	Assert.assertTrue(true);
            } 
    	}
    }
    
    public void clickMarkAsDoneCheckBox(WebDriver webDriver) {
        webDriver.findElement(By.xpath("//div[contains(@class,'flowComponent activity ')]//a[text()='"+meetingTitle+"']/parent::span//preceding-sibling::span")).click();    	
    }
    
    public void clickActivities() {
    	Activities.click();
    	
    }
    
    public void verifyDoneMeeting(WebDriver webDriver) {
    	Assert.assertTrue(webDriver.findElement(By.xpath("//div[@class='flowContainer done']//div//a[text()='"+meetingTitle+"']")).isDisplayed() );   	
    }
    
    public void clickDoneActivityPipeButton(WebDriver webDriver) {
        webDriver.findElement(By.xpath("//div[@class='flowContainer done']//div//a[text()='"+meetingTitle+"']//ancestor::h3//preceding-sibling::div[@class='actionButtons']")).click();    	
    	
    }
    
    public void clickDoneActivityDelete() {
    	DoneActivityDelete.click();
    	ConfirmDeleteButton.click();
    	
    }
    
    public void verifyMeetingDeleted(WebDriver webDriver) {
    	Assert.assertEquals(0,webDriver.findElements(By.xpath("//div[@class='flowContainer done']//div//a[text()='"+meetingTitle+"']")).size() );   	
    }
    
    public void setExpectedCloseDate(String closeDate) {
    	ExpectedCloseDate.click();
    	CloseDateInput.sendKeys(closeDate);
    	CloseDateInput.sendKeys(Keys.TAB);
    	CloseDateSaveButton.click();

    	
    }
    
    
    public void verifyExpectedCloseDate(String closeDate) throws ParseException {
        SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy");
        Date date = dt.parse(closeDate);
        SimpleDateFormat dt1 = new SimpleDateFormat("MMMMM dd, yyyy");
    	String newstring = dt1.format(date);
    	Assert.assertEquals(newstring, setExpectedCloseDate.getText());
    }
    
    public void changeExpectedCloseDate(String closeDate) throws ParseException {
    	explicitWait(setExpectedCloseDate);
    	setExpectedCloseDate.click();
    	CloseDateInput.sendKeys(closeDate);
    	CloseDateInput.sendKeys(Keys.TAB);
    	CloseDateSaveButton.click();
    }
    
    
    public void deleteExpectedCloseDate() {
    	setExpectedCloseDate.click();
    	CloseDateDeleteButton.click();
    }
    
    public void verifyCloseDateDeleted() {
    	Assert.assertTrue(ExpectedCloseDate.isDisplayed());
    }
    
    
    public void deleteDeal() {
    	PipeButton.click();
    	for(WebElement e : PipeButtonOptions) {
    		System.out.println(e.getText());
            if(e.getText().equalsIgnoreCase("Delete")) {
                e.click();
            }
    	}
    }

}
