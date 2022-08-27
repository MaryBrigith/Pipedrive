package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	
	 public WebDriver ldriver;

	public LoginPage(WebDriver ldriver) {
	        this.ldriver = ldriver;
	        PageFactory.initElements(ldriver, this);
	    }
	
	@FindBy(className="puco-navigation-link__text")
    @CacheLookup
    WebElement loginButton;
	
	@FindBy(id="login")
    @CacheLookup
    WebElement Email;

    @FindBy(id="password")
    @CacheLookup
    WebElement Password;

    @FindBy(name="submit")
    @CacheLookup
    WebElement Login;

    @FindBy(id = "name")
    WebElement errorMsg;

    @FindBy(id = "submit")
    @CacheLookup
    WebElement Submit;
    
    public void clickLoginButton() {
    	loginButton.click();
    }

    
    public void setEmail(String email) {
    	Email.sendKeys(email);
    }

    public void setPassword(String password) {
        Password.sendKeys(password);
    }

//    public void clickLogin() {
//    	//scrollIntoView(driver,Login);
//    	JavascriptExecutor js = (JavascriptExecutor) ldriver;
//        js.executeScript("arguments[0].scrollIntoView();", Login);
//        Login.click();
//    }

    public String getErrorMsg() {
        return errorMsg.getText();
    }

    public void clickLogin() {
    	Login.click();
    }

}
