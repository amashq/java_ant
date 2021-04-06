package steps;

public enum Sort {
    Умолчание("По умолчанию"),
    Дешевле("Дешевле"),
    Дороже("Дороже"),
    Дата("По дате");
    public String value;

    public String getValue(Sort sort) {
        return sort.value;
    }

    Sort(String value) {
        this.value = value;
    }
}