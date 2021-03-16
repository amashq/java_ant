package animals;

import food.Food;
import food.Meat;

public abstract class Carnivorous extends Animal {

    Carnivorous(String type, String name) {
        super(type, name);
    }

    @Override
    public boolean eat(Food food) {
        if (food instanceof Meat) {
            System.out.println(getType() + " поел(-а) " + food.getName());
            return true;
        } else {
            System.out.println(getType() + " не ест " + food.getName());
            return false;
        }
    }
}
