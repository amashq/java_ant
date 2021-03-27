package animals;

import Aviary.AviarySize;
import food.Food;

import java.util.Objects;
import java.util.Random;

public abstract class Animal {

    private final String type;
    private int satiety;
    private String name;
    private AviarySize size;


    Animal(final String type, final String name, final AviarySize size) {
        this.type = type;
        satiety = new Random().nextInt(10) + 1;
        this.name = name;
        this.size = size;
    }

    public final String getType() {
        return type;
    }

    public final int getSatiety() {
        return satiety;
    }

    public final void setSatiety(final int satiety) {
        this.satiety = satiety;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public abstract void eat(Food food);

    public final AviarySize getSize() {
        return size;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return satiety == animal.satiety && type.equals(animal.type)
                && name.equals(animal.name) && size == animal.size;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(type, satiety, name, size);
    }
}
