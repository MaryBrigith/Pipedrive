package pipedriveUI;

import java.io.IOException;
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
import utilities.Log;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import pages.BasePage;

@Listeners(io.qameta.allure.testng.AllureTestNg.class)
@Feature("Add new deal")

public class UI_TC1_AddDeal extends BasePage {
	
	LoginPage loginPage;
	AddDealsPage addDealsPage;

	
	@Test(priority = 1) 
	@Story("Login")
    @Description("User Login")
    public void loginTest() throws IOException {
        loginPage = new LoginPage(driver);
        addDealsPage = new AddDealsPage(driver);
        Log.info("URL is opened.");
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
	@Story("Add new deal")
    @Description("User add new deal")

    public void addDeal() throws IOException, InterruptedException {
        
		explicitWait(addDealsPage.getDeal());
		Log.info("Click on add deal button");
		addDealsPage.clickOnDealButton();
		Assert.assertTrue(driver.getTitle().equals("Pipeline - Deals"));
		Log.info("New deal page opened");
		Log.info("Set contact person");
		addDealsPage.setContactPerson(contactPerson);
		Log.info("Set Organiztion");
		addDealsPage.setOrganization(organization);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Log.info("Set deal value");
		addDealsPage.setDealValue(dealValue);
		//dealsPage.setCurrency(currency);
		Log.info("Set Phone");
		addDealsPage.setPhone(phone);
		addDealsPage.setPhoneType(phonetype);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Log.info("Setemil");
		addDealsPage.setEmail(email);
		addDealsPage.setEmailType(emailtype);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Log.info("New deal created");

    }

}
