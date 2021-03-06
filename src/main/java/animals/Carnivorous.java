package animals;

import Aviary.AviarySize;
import Aviary.WrongFoodException;
import food.Food;
import food.Meat;

import java.util.Random;

public abstract class Carnivorous extends Animal {

    Carnivorous(final String type, final String name, final AviarySize size) {
        super(type, name, size);
    }

    @Override
    public final void eat(final Food food) {
        if (getSatiety() < 0) {
            System.out.println("Некого кормить. Животное '" + getType() + "' погибло от голода :(");
            return;
        }
        int eating = getSatiety();
        if (getSatiety() < 0) {
            System.out.println("Животное '" + getType() + "' погибло от голода :(");
        }

        try {
            if (food instanceof Meat) {
                eating += new Random().nextInt(10) + 1;
                setSatiety(eating);
                System.out.println(getType() + " поел(-а) " + food.getName());
            } else {
                setSatiety(eating - new Random().nextInt(10) + 1);
                System.out.println(getType() + " " + getName() + " не поел(-а)");
                throw new WrongFoodException();
            }
        } catch (WrongFoodException e) {
            e.printStackTrace();
        }
    }
  
//       @Override
//     public boolean eat(Food food) {
//         if (food instanceof Meat) {
//             System.out.println(getType() + " поел(-а) " + food.getName());
//             return true;
//         } else {
//             System.out.println(getType() + " не ест " + food.getName());
//             return false;
//         }
}
