package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class AddDealsPage extends BasePage {
	

	public AddDealsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath = "//span[text()='Deal']")
    @CacheLookup
    WebElement Deal;
	
    @FindBy(id = "downshift-0-input")
    @CacheLookup
    WebElement ContactPerson;

    @FindBy(id = "downshift-1-input")
    @CacheLookup
    WebElement Organization;
    
    @FindBy(xpath = "(//div[@class='cui5-input__box']/input)[5]")
    @CacheLookup
    WebElement DealValue;

    @FindBy(xpath = "//div[@id='downshift-1-menu']/div")
    @CacheLookup
    List<WebElement> CurrencyType;
    
    @FindBy(xpath = "(//span[@class='cui5-select__box'])[1]")
    @CacheLookup
    WebElement CurrencyTypeDropdown;
    
    @FindBy(xpath = "(//div[@class='cui5-input__box']/input)[7]")
    @CacheLookup
    WebElement Phone;
    
    @FindBy(xpath = "(//span[@class='cui5-select__box'])[3]")
    @CacheLookup
    WebElement PhoneTypeDropdown;
    
    @FindBy(xpath = "//div[@id='downshift-2-menu']/div")
    @CacheLookup
    List<WebElement> PhoneType;
    
    @FindBy(xpath = "(//span[@class='cui5-select__box'])[4]")
    @CacheLookup
    WebElement EmailTypeDropdown;
    
    @FindBy(xpath = "(//div[@class='cui5-input__box']/input)[8]")
    @CacheLookup
    WebElement Email;
    
    @FindBy(xpath = "downshift-3-menu")
    @CacheLookup
    List<WebElement> EmailType;

    @FindBy(xpath = "//button/span[text()='Save']")
    @CacheLookup
    WebElement SaveButton;
    
    @FindBy(xpath = "//button/span[text()='Cancel']")
    @CacheLookup
    WebElement CancelButton;
    
    @FindBy(xpath = "//div[text()='Add products']")
    @CacheLookup
    WebElement AddProducts;
    
    @FindBy(xpath = "(//div[@class='cui5-input'])[2]")
    @CacheLookup
    WebElement Item;
    
    @FindBy(xpath = "(//div[@class='cui5-input'])[3]")
    @CacheLookup
    WebElement Price;
    
    @FindBy(xpath = "(//div[@class='cui5-input'])[4]")
    @CacheLookup
    WebElement Quantity;
    
    @FindBy(xpath = "(//div[@class='cui5-input'])[5]")
    @CacheLookup
    WebElement Tax;
    
    @FindBy(xpath = "(//div[@class='cui5-input'])[6]")
    @CacheLookup
    WebElement Amount;

    
    
	public WebElement getDeal() {
		return Deal;
	}
	
	public WebElement getContactPerson() {
		return ContactPerson;
	}
	
	@Step("Click on deal button")
    public void clickOnDealButton() {
		Deal.click();
    }

	@Step("Set Phone Type")
    public void setPhoneType(String phonetype) {
    	PhoneTypeDropdown.click();
    	for(WebElement e : PhoneType) {
            if(e.getText().equalsIgnoreCase(phonetype)) {
                e.click();
                break;
            }
    	}System.out.println("mobile selected");
    }
    
	@Step("Set email type")
    public void setEmailType(String emailtype) {
    	EmailTypeDropdown.click();
    	for(WebElement e : EmailType) {
            if(e.getText().equalsIgnoreCase(emailtype)) {
                e.click();
                break;
            }
    	}System.out.println("email selected");
    }
    
	@Step("Set Contact Person")
    public void setContactPerson(String contact) {
        ContactPerson.sendKeys(contact);
    }
    
	@Step("Set Organization")
    public void setOrganization(String org) {
    	Organization.sendKeys(org);
    }
    
	@Step("Set Deal Value")
    public void setDealValue(String value) {
    	DealValue.sendKeys(value);
    }
    
	@Step("Set currency")
    public void setCurrency(String currency) {
    	CurrencyTypeDropdown.click();
    	for(WebElement e : CurrencyType) {
            if(e.getText().equalsIgnoreCase(currency)) {
                e.click();
            }
    	}
    }
    	
	@Step("Set Phone")
    public void setPhone(String phone) {
    	Phone.sendKeys(phone);
    }
    
	@Step("Set email")
    public void setEmail(String email) {
    	Email.sendKeys(email);
    }
    
	@Step("Click on save button")
    public void clickSaveButton () {
    	SaveButton.click();
    }

	@Step("Click cancel button")
    public void clickCancelButton () {
    	CancelButton.click();
    }

	@Step("Click on add products")
    public void clickAddProducts () {
    	AddProducts.click();
    }

	@Step("Set Item")
    public void setItem (String productItem) {
    	Item.sendKeys(productItem);
    }


}
