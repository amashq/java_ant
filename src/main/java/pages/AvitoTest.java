package pages;

import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class AvitoTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private static Screenshot screenshot;
    private static File actualFile;

    @Attachment(value = "Screenshot", type = "image/png")
    public void makePageScreenshot(String fileName) {
        // make page screenshot
        screenshot = new AShot().shootingStrategy(
                ShootingStrategies.viewportPasting(100)).takeScreenshot(this.driver);
        actualFile = new File("images/" + fileName + ".png");

        // save page screenshot
        try {
            ImageIO.write(screenshot.getImage(), "png", actualFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void openAvito(String link) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Asus\\Desktop\\seleniumAnt\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        //открытие ресурса по адресу
        driver.get(link);
        makePageScreenshot("OpenSite");
    }

    public void selectCategory(String category) {
        wait.until(driver -> ExpectedConditions.visibilityOfElementLocated(By.id("category")).apply(driver));//"category"
        //        Выбрать в выпадающем списке “категория” значение оргтехника и расходники
        Select selectCategory = new Select(driver.findElement(By.id("category")));
        selectCategory.selectByVisibleText(category);
        makePageScreenshot("SelectCategory");
    }

    public void searchPrinter(String text) {
        //        В поле поиск по объявлению ввести значение “Принтер”
        WebElement search = driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']"));
        search.sendKeys(text);
        makePageScreenshot("inputText");
    }

    public void choiceRegion() {
        //        Нажать на поле город
        WebElement selectCity = driver.findElement(By.xpath("//div[@data-marker='search-form/region']"));
        selectCity.click();
        makePageScreenshot("OpenPopUpCity");
    }

    public void inputCity(String city) {
        //        Заполнить значением “Владивосток” поле город в открывшемся окне
        //        кликнуть по первому предложенному варианту.
        wait.until(driver -> ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@data-marker='popup-location/region']")).apply(driver));
        WebElement inputCity = driver.findElement(By.xpath(
                "//input[@data-marker='popup-location/region/input']"));
        inputCity.sendKeys(city);
        makePageScreenshot("InputCity");
    }

    public void clickFirstCity() {
        //        кликнуть по первому предложенному варианту города
        wait.until(d -> driver.findElement(By.xpath("//ul[@data-marker='suggest-list']/li"))
                .getText().contains("Владивосток"));
        WebElement cityForClick = driver.findElement(By.xpath("//ul[@data-marker='suggest-list']/li[1]"));
        cityForClick.click();
        makePageScreenshot("ClickCity");
    }

    public void clickShowAds() {
        //        Нажать на кнопку “Показать объявления”
        WebElement buttonShowAds = driver.findElement(By.xpath(
                "//button[@data-marker='popup-location/save-button']"));
        buttonShowAds.click();
        makePageScreenshot("ShowAds");
    }

    public void checkPageContainsPrinters(String text) {
        WebElement title = driver.findElement(By.xpath(
                "//h1[@data-marker='page-title/text']"));
        title.getText().contains(text);
        makePageScreenshot("CheckPage");
    }

    public void checkBoxPhoto() {
        WebElement checkBox = driver.findElement(By.xpath("//input[@data-marker='search-form/with-images']"));
        checkBox.findElement(By.xpath("./..")).click();
        WebElement buttonShowAds = driver.findElement(By.xpath(
                "//button[@data-marker='search-form/submit-button']"));
        buttonShowAds.click();
        makePageScreenshot("CheckBoxPhoto");
    }

    public void choiceFilter(String sort) {
        //        В выпадающем списке фильтрации выбрать фильтрацию по убыванию цены.
        wait.until(driver -> ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[2]/select[@class='select-select-3CHiM']")).apply(driver));
        Select selectSort = new Select(driver.findElement(By.xpath(
                "//div[2]/select[@class='select-select-3CHiM']")));
        selectSort.selectByVisibleText(sort);
        makePageScreenshot("ChoiceFilter");
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
        makePageScreenshot("Printers");
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
