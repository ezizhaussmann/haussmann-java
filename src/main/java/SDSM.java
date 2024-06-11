
import Bases.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.testng.annotations.Listeners;
import utilsclasses.ManegeStores;
import utilsclasses.TestResultListener;

@Listeners(TestResultListener.class)
public class SDSM extends BaseClass {
    ManegeStores manegeStores;
    @Given("store manage is on manage stories page")
    public void storeManageIsOnManageStoriesPage() {
        manegeStores = new ManegeStores(driver);
        }


    @When("store manager view all stores")
    public void storeManagerViewAllStores() {
        manegeStores.viewAllStores();
    }

    @Then("view all stores successfully")
    public void viewAllStoresSuccessfully() {
        boolean viewAllStoresSaved = manegeStores.areAllStoresDisplayed();
        Assert.assertTrue("view all stores is failed", viewAllStoresSaved);
    }
}
