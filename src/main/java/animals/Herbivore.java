package animals;

import Aviary.AviarySize;
import Aviary.WrongFoodException;
import food.Food;
import food.Grass;

import java.util.Random;

public abstract class Herbivore extends Animal {

    public Herbivore(final String type, final String name, final AviarySize size) {
        super(type, name, size);
    }

    @Override
    public final void eat(final Food food) throws WrongFoodException {
        if (getSatiety() < 0) {
            System.out.println("Некого кормить. Животное '" + getType() + "' погибло от голода :(");
            return;
        }
        int eating = getSatiety();
        if (getSatiety() < 0) {
            System.out.println("Животное '" + getType() + "' погибло от голода :(");
        }

        if (food instanceof Grass) {
            eating += new Random().nextInt(10) + 1;
            setSatiety(eating);
            System.out.println(getType() + " поел(-а) " + food.getName());
        } else {
            setSatiety(eating - new Random().nextInt(10) + 1);
            System.out.println(getType() + " " + getName() + " не поел(-а)");
            throw new WrongFoodException();
        }
    }
}