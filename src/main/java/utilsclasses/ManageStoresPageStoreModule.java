package utilsclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ManageStoresPageStoreModule {
    ChromeDriver driver;
    FunctionsLibrary functionsLibrary;

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
    @FindBy(xpath = "//span[text()='Manage Stores']")
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



    public ManageStoresPageStoreModule(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionsLibrary = new FunctionsLibrary(driver);
    }
    public void createWebsite(){
        functionsLibrary.waitForElementPresent(createWebsiteButton);
        createWebsiteButton.click();
        functionsLibrary.waitForElementPresent(websiteNameField);
        String websiteName=functionsLibrary.generateFakeWebsiteName();
        functionsLibrary.sleep(1);
        DataHolder.setWebsiteName(websiteName);
        websiteNameField.sendKeys(websiteName);
        String code= functionsLibrary.generateFakeCode();
        int randomNumber = 1 + (int) (Math.random() * 100);
        DataHolder.setCode(code+randomNumber);
        websiteCodeField.sendKeys(code+randomNumber);
        saveWebsiteButton.click();
    }
    public boolean verifyCreateWebsite(){
        if (createWebsiteSuccessMessage.isDisplayed()){
            return true;
        }else
            return false;
    }
    public void editWebsite(){
        Actions actions = new Actions(driver);
        actions.moveToElement(systemTab).build().perform();
        actions.click(manageStoresLink).build().perform();
        WebElement editWebsiteLink = driver.findElement(By.linkText(DataHolder.getWebsiteName()));
        editWebsiteLink.click();
        websiteNameField.clear();
        String newWebsiteName = functionsLibrary.generateFakeFirstName();
        DataHolder.setWebsiteName(newWebsiteName);
        websiteNameField.sendKeys(newWebsiteName);
        websiteCodeField.clear();
        String newWebsiteCode =  functionsLibrary.generateFakeCode();
        websiteCodeField.sendKeys(newWebsiteCode);
        saveWebsiteButton.click();

    }
    public boolean verifyEditWebsite(){
        if (createWebsiteSuccessMessage.isDisplayed()){
            return true;
        }else
            return false;
    }
    public void deleteWebsite(){
        toManageStorePage();
        WebElement deleteWebsiteLink = driver.findElement(By.linkText(DataHolder.getWebsiteName()));
        deleteWebsiteLink.click();
        functionsLibrary.waitForElementPresent(deleteWebsiteButton);
        deleteWebsiteButton.click();

    }
    public boolean verifyDeleteWebsite(){
        if (deleteWebsiteSuccessMessage.isDisplayed()){
            return true;
        }else
            return false;
    }
    public void createStore(){
        toManageStorePage();
        functionsLibrary.waitForElementPresent(createStoreButton);
        createStoreButton.click();
        functionsLibrary.waitForElementPresent(websiteDropDown);
        Select select=new Select(websiteDropDown);
         select.selectByVisibleText(DataHolder.getWebsiteName());
         storeName=functionsLibrary.generateFakeFirstName();
         storeNameField.sendKeys(storeName);
         DataHolder.setStoreName(storeName);
         Select select1=new Select(rootCategoryDropDown);
         select1.selectByVisibleText(DataHolder.getRootCategoryName());
         saveStoreButton.click();

    }
    public boolean verifyCreateStore(){
        if (createStoreSuccessMessage.isDisplayed()){
            return true;
        }else
            return false;
    }
    public void editStore(){
        Actions actions = new Actions(driver);
        actions.moveToElement(systemTab).build().perform();
        actions.click(manageStoresLink).build().perform();
        WebElement editStoreLink= driver.findElement(By.linkText(DataHolder.getStoreName()));
        editStoreLink.click();
        storeNameField.clear();
        storeName=functionsLibrary.generateFakeFirstName();
        DataHolder.setStoreName(storeName);
        storeNameField.sendKeys(storeName);
        saveStoreButton.click();


    }
    public boolean verifyEditStore(){
        if (createStoreSuccessMessage.isDisplayed()){
            return true;
        }else
            return false;
    }

    public void toManageStorePage(){
        Actions actions=new Actions(driver);
        functionsLibrary.waitForElementPresent(systemTab);
        actions.moveToElement(systemTab).build().perform();
        functionsLibrary.waitForElementPresent(manageStoresLink);
        actions.click(manageStoresLink).build().perform();
    }
    public void deleteStore() {
        WebElement deleteStoreLink= driver.findElement(By.linkText(DataHolder.getStoreName()));
        functionsLibrary.waitForElementPresent(deleteStoreLink);
        deleteStoreLink.click();
        functionsLibrary.sleep(1);
        functionsLibrary.waitForElementClickable(deleteStoreButton);
        deleteStoreButton.click();

    }
    public boolean verifyDeleteStore(){
        if (deleteSuccessMessage.isDisplayed()){
            return true;
        }else
            return false;
    }



    public void toOrdersPage(){
        functionsLibrary.waitForElementClickable(SalesTabField);
        SalesTabField.click();
        functionsLibrary.waitForElementClickable(ordersOptionFiled);
        ordersOptionFiled.click();
    }

    public void createStoreView(){
        Actions actions = new Actions(driver);
        actions.moveToElement(systemTab).build().perform();
        actions.click(manageStoresLink).build().perform();
        functionsLibrary.sleep(1);
        createStoreViewButton.click();
        functionsLibrary.waitForElementPresent(storeFieldDropDown);
        Select select=new Select(storeFieldDropDown);
        select.selectByVisibleText(DataHolder.getStoreName());
        storeViewName=functionsLibrary.generateFakeFirstName();
        DataHolder.setStoreViewName(storeViewName);
        storeViewNameField.sendKeys(storeViewName);
        codeField.sendKeys(DataHolder.getCode());
        Select select1=new Select(statusFieldDropDown);
        select1.selectByVisibleText("Disabled");
        saveStoreViewButton.click();

    }

    public boolean verifyCreateStoreView(){
        if (createStoreViewSuccessMessage.isDisplayed()){
            return true;
        }else
            return false;
    }

    public void editStoreView() {
        functionsLibrary.waitForElementPresent(addedStoreViewName);
        addedStoreViewName = driver.findElement(By.xpath("//a[contains(text(),'"+DataHolder.getStoreViewName()+"')]"));
        addedStoreViewName.click();
        functionsLibrary.waitForElementPresent(editStoreViewIcon);
        storeViewNameField.clear();
        storeViewNameField.click();
        storeViewName=functionsLibrary.generateProductName();
        storeViewNameField.sendKeys(storeViewName);
        codeField.click();
        codeField.clear();
        code=functionsLibrary.generateFakeCode();
        codeField.sendKeys(code);
        Select select=new Select(statusDropdown);
        select.selectByValue("0");
        sortOrderField.click();
        sortOrderField.clear();
        saveStoreViewButton.click();
    }

    public boolean verifyEditStoreView() {
        if (successfullyMessage.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
    public void viewAllStores(){
//        Actions actions = new Actions(driver);
        functionsLibrary.waitForElementPresent(systemTab);
//        actions.moveToElement(systemTab).perform();
        systemTab.click();
        functionsLibrary.waitForElementPresent(manageStoresLink);
//        actions.click(manageStoresLink).perform();
        manageStoresLink.click();
    }

    public boolean areAllStoresDisplayed(){
        if (storeNameField.isDisplayed()) {
            System.out.println("All stores successfully viewed");
            return true;
        } else {
            System.out.println("Stores are not displayed");
            return false;
        }
    }


    public void logOut() {
        functionsLibrary.waitForElementPresent(logOutButton);
        logOutButton.click();
    }
}
