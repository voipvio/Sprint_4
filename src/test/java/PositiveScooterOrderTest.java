import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@RunWith(Parameterized.class)
public class PositiveScooterOrderTest {

    WebDriver driver;
    By orderButton;
    String firstName;
    String lastName;
    String address;
    String metro;
    String phoneNumber;
    String whenToBring;
    String comment;
    String expectedOrderStatus;

    public PositiveScooterOrderTest (By orderButton, String firstName, String lastName, String address, String metro, String phoneNumber, String whenToBring, String comment, String expectedOrderStatus){
        this.orderButton = orderButton;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.whenToBring = whenToBring;
        this.comment = comment;
        this.expectedOrderStatus = expectedOrderStatus;

    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {By.className("Button_Button__ra12g"), "Глеб", "Ордеров", "Москва, ул. Большая Никитская, д. 18", "бульвар", "+375447769845", "29.11.2024", "Спасибо за такую классную возможность заказать самокат", "Заказ оформлен"},
                {By.className("Button_Middle__1CSJM"), "Екатерина", "Назарова", "Москва, проспект Независимости, д. 168", "киевская", "+375336574846", "28.11.2024", "Нужно ли предоставить паспорт? Если да, позвоните мне", "Заказ оформлен"},
        };
    }

    @Test
    public void positiveOrderTest(){
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage objMainPage = new MainPage(driver);
        objMainPage.acceptCookies();
        objMainPage.clickOrderButton(orderButton);

        ScooterOrderPage objScooterOrderPage = new ScooterOrderPage(driver);
        objScooterOrderPage.fillFirstNameField(firstName);
        objScooterOrderPage.fillLastNameField(lastName);
        objScooterOrderPage.fillAddressField(address);
        objScooterOrderPage.fillMetroField(metro);
        objScooterOrderPage.fillPhoneNumberField(phoneNumber);
        objScooterOrderPage.clickNextOrderPageButton();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//input[@placeholder = '* Когда привезти самокат']"))));

        objScooterOrderPage.fillWhenToBringField(whenToBring);
        objScooterOrderPage.fillRentalPeriodField();
        objScooterOrderPage.setColorCheckbox();
        objScooterOrderPage.fillCommentField(comment);
        objScooterOrderPage.clickFormOrderButton();
        objScooterOrderPage.clickConfirmOrderButton();

        String actualOrderStatus = objScooterOrderPage.checkOrderIsCreated();
        Assert.assertThat(actualOrderStatus, CoreMatchers.containsString(expectedOrderStatus));


    }

    @After
    public void tearDown(){
        driver.quit();
    }


}


