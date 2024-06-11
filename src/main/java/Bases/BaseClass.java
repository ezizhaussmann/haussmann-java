package Bases;


import org.openqa.selenium.chrome.ChromeDriver;
import utilsclasses.Config;

public class BaseClass {
    public static ChromeDriver driver;

    public static void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Config.readFromConfig("config.properties", "ui.url"));
    }

    public static void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
