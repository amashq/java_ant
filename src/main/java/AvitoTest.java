import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AvitoTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Asus\\Desktop\\seleniumAnt\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        String link = "https://www.avito.ru/";

        driver.manage().window().maximize();
        //Время ожидания для поиска элементов
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //открытие ресурса по адресу
        driver.get(link);

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("category")));

//        Выбрать в выпадающем списке “категория” значение оргтехника и расходники
        Select selectCategory = new Select(driver.findElement(By.id("category")));
        selectCategory.selectByVisibleText("Оргтехника и расходники");

//        В поле поиск по объявлению ввести значение “Принтер”
        WebElement search = driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']"));
        search.sendKeys("Принтер");

//        Нажать на поле город
        WebElement selectCity = driver.findElement(By.xpath("//div[@data-marker='search-form/region']"));
        selectCity.click();

//        Заполнить значением “Владивосток” поле город в открывшемся окне
//        и кликнуть по первому предложенному варианту.
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@data-marker='popup-location/region']")));
        WebElement inputCity = driver.findElement(By.xpath(
                "//input[@data-marker='popup-location/region/input']"));
        inputCity.sendKeys("Владивосток");

        wait.until(d -> driver.findElement(By.xpath("//ul[@data-marker='suggest-list']/li"))
                .getText().contains("Владивосток"));
        WebElement cityForClick = driver.findElement(By.xpath("//ul[@data-marker='suggest-list']/li[1]"));
        cityForClick.click();

//        Нажать на кнопку “Показать объявления”
        WebElement buttonShowAds = driver.findElement(By.xpath(
                "//button[@data-marker='popup-location/save-button']"));
        buttonShowAds.click();

//        Проверить, активирован ли чекбокс, и если не активирован – активировать
        WebElement checkBox = driver.findElement(By.xpath("//input[@data-marker='delivery-filter/input']"));
        if (!checkBox.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkBox);
            checkBox.findElement(By.xpath("./..")).click();
        }

//        нажать кнопку “Показать объявления”
        driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();

//        В выпадающем списке фильтрации выбрать фильтрацию по убыванию цены.
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[2]/select[@class='select-select-3CHiM']")));
        Select selectSort = new Select(driver.findElement(By.xpath(
                "//div[2]/select[@class='select-select-3CHiM']")));
        selectSort.selectByVisibleText("Дороже");

//        Вывести в консоль название и стоимость 3х самых дорогих принтеров
        int count = 1;
        while (count <= 3) {
            System.out.println(driver.findElement(By.xpath(
                    "//div[@data-marker='catalog-serp']/div[@data-marker='item'][position()=" + count
                            + "]//h3[@itemprop='name']")).getText());
            System.out.println(driver.findElement(By.xpath(
                    "//div[@data-marker='catalog-serp']/div[@data-marker='item'][position()=" + count
                            + "]//span[@itemprop='offers']")).getText());
            count++;
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
