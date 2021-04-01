import Aviary.WrongFoodException;
import animals.Animal;
import animals.Voice;
import food.Food;

public class Worker {

    public final void feed(final Animal animal, final Food food) {
        try {
            animal.eat(food);
        } catch (WrongFoodException e) {
            e.printStackTrace();
        }
    }

    public final void getVoice(final Voice animal) {
        System.out.println("Животное подало голос: " + animal.voice());
    }
}
