package animals;

import food.Food;

import java.util.Random;

public abstract class Animal {

    private final String type;
    private int satiety;
    private String name;

    Animal(String type, String name) {
        this.type = type;
        satiety = new Random().nextInt(10) + 1;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract boolean eat(Food food);
}
