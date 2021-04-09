package steps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import pages.AvitoTest;

public class StepsAvito {
    AvitoTest pageAvito = new AvitoTest();

    @ParameterType(".*")
    public ListCategories categories(String category) {
        return ListCategories.valueOf(category);
    }

    @ParameterType(".*")
    public Sort sort(String sort) {
        return Sort.valueOf(sort);
    }


    @Пусть("открыт ресурс авито")
    public void openAvito() {
        pageAvito.openAvito("https://www.avito.ru/");
    }


    @И("в выпадающем списке категорий выбрана {categories}")
    public void selectCategory(ListCategories category) {
        pageAvito.selectCategory(category.value);
    }

    @И("в поле поиска введено значение {word}")
    public void searchPrinter(String text) {
        pageAvito.searchPrinter(text);
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public void choiceRegion() {
        pageAvito.choiceRegion();
    }

    @Тогда("в поле регион введено значение {word}")
    public void inputCity(String city) {
        pageAvito.inputCity(city);
        pageAvito.clickFirstCity();
    }

    @И("нажата кнопка показать объявления")
    public void clickShowAds() {
        pageAvito.clickShowAds();
    }

    @Тогда("открылась страница результаты по запросу {word}")
    public void checkPageContainsPrinters(String text) {
        pageAvito.checkPageContainsPrinters(text);
    }

    @И("активирован чекбокс только с фотографией")
    public void checkBoxPhoto() {
        pageAvito.checkBoxPhoto();
    }

    @И("в выпадающем списке сортировка выбрано значение {sort}")
    public void choiceFilter(Sort sort) {
        pageAvito.choiceFilter(sort.value);
    }

    @И("в консоль выведено значение названия и цены {int} первых товаров")
    public void printPrinters(int number) {
        pageAvito.printPrinters(number);
        pageAvito.closeDriver();
    }
}
