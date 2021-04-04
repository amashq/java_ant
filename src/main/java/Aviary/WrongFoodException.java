package Aviary;

public class WrongFoodException extends Exception {
    public WrongFoodException() {
        super("Не тот тип еды");
    }
}
