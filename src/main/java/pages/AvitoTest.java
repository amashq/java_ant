package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AvitoTest {
    private WebDriver driver = new ChromeDriver();
    private WebDriverWait wait;

    public void openAvito(String link) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Asus\\Desktop\\seleniumAnt\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //открытие ресурса по адресу
        driver.get(link);

    }

    public void selectCategory(String category) {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("category")));//"category"
        //        Выбрать в выпадающем списке “категория” значение оргтехника и расходники
        Select selectCategory = new Select(driver.findElement(By.id("category")));
        selectCategory.selectByVisibleText(category);
    }

    public void searchPrinter(String text) {
        //        В поле поиск по объявлению ввести значение “Принтер”
        WebElement search = driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']"));
        search.sendKeys(text);
    }

    public void choiceRegion() {
        //        Нажать на поле город
        WebElement selectCity = driver.findElement(By.xpath("//div[@data-marker='search-form/region']"));
        selectCity.click();
    }

    public void inputCity(String city) {
        //        Заполнить значением “Владивосток” поле город в открывшемся окне
        //        кликнуть по первому предложенному варианту.
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@data-marker='popup-location/region']")));
        WebElement inputCity = driver.findElement(By.xpath(
                "//input[@data-marker='popup-location/region/input']"));
        inputCity.sendKeys(city);
    }

    public void clickFirstCity() {
        //        кликнуть по первому предложенному варианту города
        wait.until(d -> driver.findElement(By.xpath("//ul[@data-marker='suggest-list']/li"))
                .getText().contains("Владивосток"));
        WebElement cityForClick = driver.findElement(By.xpath("//ul[@data-marker='suggest-list']/li[1]"));
        cityForClick.click();

    }

    public void clickShowAds() {
        //        Нажать на кнопку “Показать объявления”
        WebElement buttonShowAds = driver.findElement(By.xpath(
                "//button[@data-marker='popup-location/save-button']"));
        buttonShowAds.click();
    }

    public void checkPageContainsPrinters(String text) {
        WebElement title = driver.findElement(By.xpath(
                "//h1[@data-marker='page-title/text']"));
        title.getText().contains(text);
    }

    public void checkBoxPhoto() {
        WebElement checkBox = driver.findElement(By.xpath("//input[@data-marker='search-form/with-images']"));
        checkBox.findElement(By.xpath("./..")).click();
        WebElement buttonShowAds = driver.findElement(By.xpath(
                "//button[@data-marker='search-form/submit-button']"));
        buttonShowAds.click();
    }

    public void choiceFilter(String sort) {
        //        В выпадающем списке фильтрации выбрать фильтрацию по убыванию цены.
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[2]/select[@class='select-select-3CHiM']")));
        Select selectSort = new Select(driver.findElement(By.xpath(
                "//div[2]/select[@class='select-select-3CHiM']")));
        selectSort.selectByVisibleText(sort);
    }

    public void printPrinters(int number) {
        //        Вывести в консоль название и стоимость 3х самых дорогих принтеров
        int count = 1;
        while (count <= number) {
            System.out.println(driver.findElement(By.xpath(
                    "//div[@data-marker='catalog-serp']/div[@data-marker='item'][position()=" + count
                            + "]//h3[@itemprop='name']")).getText());
            System.out.println(driver.findElement(By.xpath(
                    "//div[@data-marker='catalog-serp']/div[@data-marker='item'][position()=" + count
                            + "]//span[@itemprop='offers']")).getText());
            count++;
        }
        ;
    }

    public void closeDriver() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
