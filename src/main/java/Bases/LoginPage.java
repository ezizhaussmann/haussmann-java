package Bases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilsclasses.FunctionsLibrary;

public class LoginPage {
    ChromeDriver driver;
    FunctionsLibrary functionsLibrary;
    @FindBy(id ="username")
    WebElement userNameField;
    @FindBy(name = "login[password]")
    WebElement passwordField;
    @FindBy(xpath = "//input[@title='Login']")
    WebElement loginButton;

    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionsLibrary = new FunctionsLibrary(driver);
    }

    public void login(String userName, String password) {
        functionsLibrary.waitForElementPresent(userNameField);
        userNameField.sendKeys(userName);
        functionsLibrary.waitForElementPresent(passwordField);
        passwordField.sendKeys(password);
        functionsLibrary.waitForElementPresent(loginButton);
        loginButton.click();
    }
}
