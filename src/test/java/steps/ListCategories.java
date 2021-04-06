package steps;

public enum ListCategories {
    оргтехника("Оргтехника и расходники"),
    одежда("Одежда, обувь, аксессуары"),
    планшеты("Планшеты и электронные книги"),
    хобби("Хобби и отдых"),
    ноутбуки("Ноутбуки");
    // слишком много значений выпадающего списка - выбрала только некоторые

    public String value;

    public String getValue(ListCategories category){
        return category.value;
    }
    ListCategories(String value){
        this.value = value;
    }
}
