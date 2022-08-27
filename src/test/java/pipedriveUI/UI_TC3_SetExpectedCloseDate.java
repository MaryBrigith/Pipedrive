package pipedriveUI;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.AddDealsPage;
import pages.LoginPage;
import pages.ManageDealPage;
import utilities.Log;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import pages.BasePage;

@Listeners(io.qameta.allure.testng.AllureTestNg.class)
@Story("Set Expected CloseDate")
public class UI_TC3_SetExpectedCloseDate extends BasePage {
	
	LoginPage loginPage;
	AddDealsPage addDealsPage;
	ManageDealPage manageDealPage;


	
	@Test(priority = 1) 
	@Step("Login")
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
        Log.info("User logged in");
    }
	
	@Test(priority = 2)
	@Step("Set Expected Close Date")
    @Description("Set Expected Close Date")

    public void setExpectedCloseDate() throws IOException, InterruptedException, ParseException {
		
		manageDealPage = new ManageDealPage(driver);
		explicitWait(manageDealPage.getMyDeal());
		manageDealPage.clickMyDeal();
		manageDealPage.setExpectedCloseDate(dealCloseDate);
		manageDealPage.verifyExpectedCloseDate(dealCloseDate);
		Log.info("Expected close date selected");
        

    }
	
	@Test(priority = 3)
	@Step("Change Expected Close Date")
    @Description("Change Expected Close Date")

    public void changeExpectedCloseDate() throws IOException, InterruptedException, ParseException {
		
		manageDealPage = new ManageDealPage(driver);
		explicitWait(manageDealPage.getUserLabel());
		manageDealPage.changeExpectedCloseDate(changeDealCloseDate);
		Log.info("Chnged expected close date");
        

    }
	
	@Test(priority = 4)
	@Step("Delete Expected Close Date")
    @Description("Delete Expected Close Date")

    public void deleteExpectedCloseDate() throws IOException {
		
		manageDealPage = new ManageDealPage(driver);
		explicitWait(manageDealPage.getUserLabel());
		manageDealPage.deleteExpectedCloseDate();
		manageDealPage.verifyCloseDateDeleted();
		Log.info("Expected close date deleted");

    }

}
