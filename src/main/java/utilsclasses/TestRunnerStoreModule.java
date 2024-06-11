package utilsclasses;


import Bases.BaseClass;
import Bases.LoginPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-html-report-store.html","json:target/cucumber-store.json"},
        features = {"src/test/resources"},
        tags = "@StoreModuleRegressionTest"
)
public class TestRunnerStoreModule extends BaseClass {
    public static String fileName = "config.properties";
    @BeforeClass
    public static void setUp() {
        openBrowser();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Config.readFromConfig(fileName, "usernamestore"), Config.readFromConfig(fileName, "ui.password"));
    }

    @AfterClass
    public static void tearDown() {
        ManageStoresPageStoreModule manageStoresPageStoreModule = new ManageStoresPageStoreModule(driver);
        manageStoresPageStoreModule.logOut();
        closeBrowser();
    }


}
