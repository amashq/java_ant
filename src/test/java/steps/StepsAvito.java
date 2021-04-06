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
    public void открытРесурсАвито() {
        pageAvito.openAvito("https://www.avito.ru/");
    }


    @И("в выпадающем списке категорий выбрана {categories}")
    public void вВыпадающемСпискеКатегорийВыбранаОргтехника(ListCategories category) {
        pageAvito.selectCategory(category.value);
    }

    @И("в поле поиска введено значение {word}")
    public void вПолеПоискаВведеноЗначениеПринтер(String text) {
        pageAvito.searchPrinter(text);
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public void кликнутьПоВыпадающемуСпискуРегиона() {
        pageAvito.choiceRegion();
    }

    @Тогда("в поле регион введено значение {word}")
    public void вПолеРегионВведеноЗначениеВладивосток(String city) {
        pageAvito.inputCity(city);
        pageAvito.clickFirstCity();
    }

    @И("нажата кнопка показать объявления")
    public void нажатаКнопкаПоказатьОбъявления() {
        pageAvito.clickShowAds();
    }

    @Тогда("открылась страница результаты по запросу {word}")
    public void открыласьСтраницаРезультатыПоЗапросуПринтер(String text) {
        pageAvito.checkPageContainsPrinters(text);
    }

    @И("активирован чекбокс только с фотографией")
    public void активированЧекбоксТолькоСФотографией() {
        pageAvito.checkBoxPhoto();
    }

    @И("в выпадающем списке сортировка выбрано значение {sort}")
    public void вВыпадающемСпискеСортировкаВыбраноЗначениеДороже(Sort sort) {
        pageAvito.choiceFilter(sort.value);
    }

    @И("в консоль выведено значение названия и цены {int} первых товаров")
    public void вКонсольВыведеноЗначениеНазванияИЦеныПервыхТоваров(int number) {
        pageAvito.printPrinters(number);
        pageAvito.closeDriver();
    }
}
