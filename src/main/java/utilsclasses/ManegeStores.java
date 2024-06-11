package utilsclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ManegeStores {
//    ChromeDriver driver;
//    FunctionsLibrary functionsLibrary;

    @FindBy(xpath = "//span[text()='Sales']")
    WebElement SalesTabField;
    @FindBy(xpath = "//span[text()=\"Orders\"]")
    WebElement ordersOptionFiled;

    String storeName;
    String storeViewName;
    String code;

    @FindBy(linkText = "Log Out")
    WebElement logOutButton;
    @FindBy(xpath = "//span[text()='Create Website']")
    WebElement createWebsiteButton;
    @FindBy(id = "website_name")
    WebElement websiteNameField;
    @FindBy(id = "website_code")
    WebElement websiteCodeField;
    @FindBy(xpath = "//span[text()='Save Website']")
    WebElement saveWebsiteButton;
    @FindBy(xpath = "//*[@id=\"nav\"]/li[4]/ul/li/a/span")
    WebElement manageStoresLink;
    @FindBy(xpath = "//span[text()='System']")
    WebElement systemTab;
    @FindBy(xpath = "//span[text()='The website has been saved.']")
    WebElement createWebsiteSuccessMessage;
    @FindBy(xpath = "//span[text()='Create Store']")
    WebElement createStoreButton;
    @FindBy(id = "group_website_id")
    WebElement websiteDropDown;
    @FindBy(id = "group_name")
    WebElement storeNameField;
    @FindBy(id = "group_root_category_id")
    WebElement rootCategoryDropDown;
    @FindBy(xpath = "//span[text()='Save Store']")
    WebElement saveStoreButton;
    @FindBy(xpath = "//span[text()='The store has been saved.']")
    WebElement createStoreSuccessMessage;
    @FindBy(xpath = "//span[text()='Delete Store']")
    WebElement deleteStoreButton;
    @FindBy(xpath = "//span[text()=\"The store has been deleted.\"]")
    WebElement deleteSuccessMessage;
    @FindBy(xpath = "//span[text()=\"Delete Website\"]")
    WebElement deleteWebsiteButton;
    @FindBy(id = "messages")
    WebElement deleteWebsiteSuccessMessage;
    @FindBy(xpath = "//span[contains(text(),'abc1715719538536')]")
    WebElement addedStoreViewName;
    @FindBy(xpath = "//*[@id=\"page:main-container\"]/div[2]/h3")
    WebElement editStoreViewIcon;
    @FindBy(id = "store_name")
    WebElement storeViewNameField;
    @FindBy(id = "store_code")
    WebElement codeField;
    @FindBy(id = "store_is_active" )
    WebElement statusDropdown;
    @FindBy(id = "store_sort_order")
    WebElement sortOrderField;
    @FindBy (xpath = "//span[contains(text(),'Save Store View')]")
    WebElement saveStoreViewButton;
    @FindBy(xpath = "//span[contains(text(),'The store view has been saved')]")
    WebElement successfullyMessage;
    @FindBy(xpath = "//span[text()='Create Store View']")
    WebElement createStoreViewButton;
    @FindBy(id = "store_group_id")
    WebElement storeFieldDropDown;
    @FindBy(id = "store_is_active")
    WebElement statusFieldDropDown;
    @FindBy(xpath = "//span[text()='The store view has been saved']")
    WebElement createStoreViewSuccessMessage;
    @FindAll(@FindBy(xpath = "//table[@class='data']/tbody/tr/td/span[contains(text(),'Root Category:')]/parent::td/a"))
    List<WebElement> storeNameList;

    @FindAll(@FindBy(xpath = "//table[@class='data']/tbody/tr/td[@class='a-left last']/span"))
    List<WebElement> storeViewNameCodeList;



//    public ManegeStores(ChromeDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//        functionsLibrary = new FunctionsLibrary(driver);
        private WebDriver driver;
        private FunctionsLibrary functionsLibrary;

    public ManegeStores(ChromeDriver driver) {
    }

    public void ManageStores(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            functionsLibrary = new FunctionsLibrary((ChromeDriver) driver);
    }
    public void viewAllStores(){
        Actions actions;
        actions = new Actions(driver);
        functionsLibrary.waitForElementPresent(systemTab);
        actions.moveToElement(systemTab).perform();
        functionsLibrary.waitForElementPresent(manageStoresLink);
        actions.click(manageStoresLink).perform();
    }
    public boolean areAllStoresDisplayed(){
        if (storeNameField.isDisplayed()){
            System.out.println("All Store successully view");
            return true;
        }else
            return false;
    }


    public void logOut() {
        functionsLibrary.waitForElementPresent(logOutButton);
        logOutButton.click();
    }
}
