package utilsclasses;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class FunctionsLibrary {
    ChromeDriver driver;
    WebDriverWait wait;
    Faker faker;

    public FunctionsLibrary(ChromeDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Augmenté à 30 secondes
        faker=new Faker();
    }

    public void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void waitForElementPresent(WebElement element) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
//        wait.until(ExpectedConditions.visibilityOf(element));
        try {
            System.out.println("Waiting for element: " + element.toString());
            wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
            System.out.println("Element found: " + element.toString());
        } catch (Exception e) {
            System.out.println("Element not found within the timeout: " + element.toString());
            throw e; // Re-throw the exception to handle it in the calling method
        }
    }

    public void waitForElementClickable(WebElement element) {
         wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForAlertPresent() {
  wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public String generateFakeFirstName() {
        String firstName = faker.name().firstName();
        return firstName;
    }
    public String generateFakeLastName() {
        String lastName = faker.name().lastName();
        return lastName;
    }

    public String generateEmail() {
        String email = faker.internet().emailAddress();
        return email;
    }
    public String generateFakeWebsiteName(){
        String websiteName=faker.internet().username();
        return websiteName;
    }
    public String generateFakeCode(){
        String code=faker.name().lastName().toLowerCase(Locale.ROOT)+System.currentTimeMillis();
        return code;
    }


    public String generateProductName() {
        String[] products = {"Car", "Bike", "Phone", "Laptop", "TV", "PlayStation", "Book", "Toy", "Fruit", "Clothing"};
        int indexNumber = (int) (Math.random() * 11 - 1);
        String productName = products[indexNumber];
        return productName;
    }

    public String generateFakeStreetAddress() {
        String streetAdress = faker.address().streetAddress();
        return streetAdress;
    }

    public String generateFakeCityName() {
        String cityName = faker.address().city();
        return cityName;
    }

    public String generateFakePostcode() {
        String postCode = faker.address().postcode();
        return postCode;
    }

    public String generateFakePhoneNumber() {
        String phoneNumber = faker.phoneNumber().phoneNumberInternational();
        return phoneNumber;
    }
}
