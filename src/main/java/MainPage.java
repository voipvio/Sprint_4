import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends BasePage {

    // Кнопка принятия cookie
    private By cookiesButton = By.className("App_CookieButton__3cvqF");
    // Переменная индекса элемента выпадающего списка
    private int accordionArrowIndex;
    // Кнопка стрелки выпадающего списка в разделе "Вопросы о важном"
    private By accordionArrow = By.xpath(".//div[@id = 'accordion__heading-" + accordionArrowIndex + "']");
    // Заголовок элемента выпадающего списка
    private String accordionElementHeader = ".//div[@id = 'accordion__heading-%d']";
    // Описание элемента выпадающего списка
    private String accordionElementDescription = ".//div[@aria-labelledby = 'accordion__heading-%d']/p";
    // Кнопка "Заказать" в заголовке страницы
    private By headerOrderButton = By.className("Button_Button__ra12g");
    // Кнопка "Заказать" на главной странице
    private By homeOrderButton = By.className("Button_Middle__1CSJM");

    public MainPage(WebDriver driver){
        super(driver);
    }
    // Метод принимает куки
    public void acceptCookies(){
        driver.findElement(cookiesButton).click();
    }
    // Метод кликает на кнопку выпадающего списка
    public void clickAccordionArrow(int accordionArrowIndex){
        By accordionArrow = By.xpath(".//div[@id = 'accordion__heading-" + accordionArrowIndex + "']");
        driver.findElement(accordionArrow).click();
    }
    // Метод получает текст заголовка элемента выпадающего списка
    public String getAccordionHeader (int accordionArrowIndex) {
        return driver.findElement(By.xpath(String.format(accordionElementHeader, accordionArrowIndex))).getText();
    }
    // Метод получает текст описания элемента выпадающего списка
    public String getAccordionDescription (int accordionArrowIndex) {
        return driver.findElement(By.xpath(String.format(accordionElementDescription, accordionArrowIndex))).getText();
    }
    // Метод кликает на кнопку "Заказать"
    public void clickOrderButton(By orderButton){
        driver.findElement(orderButton).click();
    }

}




