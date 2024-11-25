import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ScooterOrderPage extends BasePage {
    // Заголовок страницы "Когда привезти самокат?"
    private By orderPageHeader = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    // Поле "Имя"
    private By firstNameField = By.xpath(".//input[@placeholder = '* Имя']");
    // Поле "фамилия"
    private By lastNameField = By.xpath(".//input[@placeholder = '* Фамилия']");
    // Поле "Адрес: куда привезти заказ"
    private By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    // Поле "Станция метро"
    private By metroField = By.xpath(".//input[@placeholder = '* Станция метро']");
    // Поле "Телефон"
    private By phoneNumberField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    // Кнопка "Далее" на первой странице заказа
    private By nextOrderPageButton = By.className("Button_Middle__1CSJM");
    // Поле "Когда привезти самокат"
    private By whenToBringField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    // Строка для выбора даты в календаре, открывающемся по клику на поле "Когда привезти самокат"
    private String dayInCalendar = "div.react-datepicker__day--0%d";
    // Поле "Срок аренды"
    private By rentalPeriodField = By.className("Dropdown-placeholder"); // or Dropdown-arrow
    // Опция в дропдауне, появляющемся по клику на поле "Срок аренды"
    private By rentalPeriodValue = By.className("Dropdown-option"); // текст у нее сутки, трое суток
    // Чекбокс поля "Цвет самоката" - "Черный жемчуг"
    private By colorCheckbox = By.id("black");
    // Поле "Комментарий для курьера"
    private By commentField = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    // Кнопка "Заказать"
    private By formOrderButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    // Кнопка подтверждения заказа
    private By confirmOrderButton = By.xpath(".//button[text() = 'Да']");
    // Всплывающее окно с текстом об успешном оформлении заказа
    private By successOrderPopup = By.className("Order_Modal__YZ-d3");
    // Заголовок "Заказ успешно оформлен" на всплывающем окне об успешном оформлении заказа
    private By successOrderHeader = By.className("Order_ModalHeader__3FDaJ");

    public ScooterOrderPage(WebDriver driver){
        super(driver);
    }

    // Метод возвращает заголовок страницы "Когда привезти самокат?"
    public By getOrderPageHeader () {
        return orderPageHeader;
    }
    // Метод вводит значение в поле "Имя"
    public void fillFirstNameField (String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    // Метод вводит значение в поле "Фамилия"
    public void fillLastNameField (String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    // Метод вводит значение в поле "Адрес"
    public void fillAddressField (String address){
        driver.findElement(addressField).sendKeys(address);
    }
    // Метод вводит значение в поле "Станция метро"
    public void fillMetroField (String metro){
        driver.findElement(metroField).sendKeys(metro);
        driver.findElement(metroField).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(metroField).sendKeys(Keys.ENTER);
    }
    // Метод вводит значение в поле "Телефон"
    public void fillPhoneNumberField (String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }
    // Метод кликает на кнопку "Далее" на первой странице данных заказа
    public void clickNextOrderPageButton () {
        driver.findElement(nextOrderPageButton).click();
    }
    // Метод вводит значение в поле "Когда привезти самокат"
    public void fillWhenToBringField(String whenToBring){
        driver.findElement(whenToBringField).sendKeys(whenToBring);
        driver.findElement(whenToBringField).sendKeys(Keys.ENTER);
    }
    // Метод вводит значение в поле "Срок аренды"
    public void fillRentalPeriodField(){
        driver.findElement(rentalPeriodField).click();
        driver.findElement(rentalPeriodValue).click();
    }
    // Метод кликает на чекбокс выбора цвета самоката
    public void setColorCheckbox(){
        driver.findElement(colorCheckbox).click();
    }
    // Метод вводит значение в поле "Комментарий для курьера"
    public void fillCommentField(String comment){
        driver.findElement(commentField).sendKeys(comment);
    }
    // Метод кликает на кнопку "Заказать" под формой данных заказа
    public void clickFormOrderButton(){
        driver.findElement(formOrderButton).click();
    }
    // Метод кликает на кнопку "Заказать" на поп-апе подтверждения заказа
    public void clickConfirmOrderButton(){
        driver.findElement(confirmOrderButton).click();
    }
    // Метод проверяет, что поткрывается поп-ап успешного оформления заказа с текстом "Заказ оформлен"
    public String checkOrderIsCreated() {
        driver.findElement(successOrderPopup);
        return driver.findElement(successOrderHeader).getText();
    }




}
