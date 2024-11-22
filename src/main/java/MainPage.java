import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Objects;

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
    // Путь до описания элемента выпадающего списка
    private By accordionDescriptionPath = By.xpath(".//div[@id = 'accordion__panel-" + accordionArrowIndex + "']/p");
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
    // Метод возвращает путь до описания элемента выпадающего списка в зависимости от индекса
    public By getAccordionDescriptionPath (int accordionArrowIndex) {
        return accordionDescriptionPath = By.xpath(".//div[@id = 'accordion__panel-" + accordionArrowIndex + "']/p");
    }
    // Метод кликает на кнопку "Заказать" в заголовке или теле страницы, в зависимости от параметра
    public void clickOrderButton(String orderButtonPlace){
        if (Objects.equals(orderButtonPlace, "Кнопка Заказать в заголовке")) {
            driver.findElement(headerOrderButton).click();
        } else {
            driver.findElement(homeOrderButton).click();
        }
    }

}
