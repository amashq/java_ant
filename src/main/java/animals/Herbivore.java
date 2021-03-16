package animals;

import food.Food;
import food.Grass;

public abstract class Herbivore extends Animal {

    public Herbivore(String type, String name) {
        super(type, name);
    }

    @Override
    public boolean eat(Food food) {
        if (food instanceof Grass) {
            System.out.println(super.getType() + " поел(-а) " + food.getName());
            return true;
        } else {
            System.out.println(super.getType() + " не ест " + food.getName());
            return false;
        }
    }
}
