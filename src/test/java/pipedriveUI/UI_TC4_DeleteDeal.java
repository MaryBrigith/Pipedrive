package pipedriveUI;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import pages.AddDealsPage;
import pages.LoginPage;
import pages.ManageDealPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import pages.BasePage;

@Listeners(io.qameta.allure.testng.AllureTestNg.class)
@Feature("Delete a deal")
public class UI_TC4_DeleteDeal extends BasePage {
	
	LoginPage loginPage;
	AddDealsPage addDealsPage;
	ManageDealPage manageDealPage;

	
	@Test(priority = 1) 
	@Story("Login")
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
	@Story("User Delete Deal from pipeline")
    @Description("User delete  deal from pipeline")

    public void addDeal() throws IOException, InterruptedException {
        
		manageDealPage = new ManageDealPage(driver);
		explicitWait(manageDealPage.getMyDeal());
		manageDealPage.clickMyDeal();
		manageDealPage.deleteDeal();
		acceptAlert(driver);
    }

}
