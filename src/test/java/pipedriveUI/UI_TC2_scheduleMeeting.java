package pipedriveUI;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import pages.BasePage;
import pages.AddDealsPage;
import pages.LoginPage;
import pages.ManageDealPage;
import utilities.Log;

@Listeners(io.qameta.allure.testng.AllureTestNg.class)
@Story("Schedule appointment")
public class UI_TC2_scheduleMeeting extends BasePage{
	
	LoginPage loginPage;
	AddDealsPage addDealsPage;
	ManageDealPage manageDealPage;
	
	@Test(priority = 1)  
	@Step("User Login")
    @Description("User Login")
    public void loginTest() throws IOException {
		loginPage = new LoginPage(driver);
        addDealsPage = new AddDealsPage(driver);
         loginPage.setEmail(userEmail);
         loginPage.setPassword(password);
         loginPage.clickLogin();
         System.out.println(driver.getTitle());
        if(driver.getTitle().equals("Pipedrive")) {
            Assert.assertTrue(true);
        }
        else {
            //screenShot(driver,"login");
            Assert.assertTrue(false);
        }
         System.out.println("User looged in");
    }
	
	@Test(priority = 2)
	@Step("Schedule an appointment")
    @Description("User scheduling new appointment")

    public void scheduleAppointment() throws IOException, InterruptedException {
		
		manageDealPage = new ManageDealPage(driver);
		explicitWait(manageDealPage.getMyDeal());
		Log.info("Click on mydeal");
		manageDealPage.clickMyDeal();
		Log.info("My Deal opened");
		Log.info("Set notes");
		manageDealPage.clickOnNotes();
		manageDealPage.setNotes("testing");
		Log.info("Set activity");
		manageDealPage.clickActivity();
		explicitWait(manageDealPage.getActivityButton());
		Log.info("Schedule meeting");
		manageDealPage.clickMeeting();
		
		manageDealPage.setMeetingTitle(meetingTitle);
		manageDealPage.setMeetingStartDate(meetingStartDate);
		manageDealPage.setMeetingStartTime(meetingStartTime);
		manageDealPage.setMeetingEndDate(meetingEndDate);
		manageDealPage.setMeetingEndTime(meetingEndTime);
		manageDealPage.setMeetingGuests(guestsList);
		manageDealPage.setMeetingLocation(meetingLocation);
		manageDealPage.setMeetingDescription(meetingDescription);
		manageDealPage.setMeetingNotes(meetingNotes);
		manageDealPage.clickSaveButton();
		Log.info("Meeting scheduled");
		
		manageDealPage.verifyPlannedMeeting(meetingTitle);
		Log.info("Meeting available in plnned meeting");
		manageDealPage.clickMarkAsDoneCheckBox(driver);
		manageDealPage.clickActivities();
		manageDealPage.verifyDoneMeeting(driver);
		Log.info("Activity moved to done meeting");
		manageDealPage.clickDoneActivityPipeButton(driver);
		manageDealPage.clickDoneActivityDelete();
		manageDealPage.verifyMeetingDeleted(driver);
		Log.info("Activity deleted");
    }


}
