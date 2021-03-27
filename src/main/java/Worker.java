import animals.Animal;
import animals.Voice;
import food.Food;

public class Worker {

    public final void feed(final Animal animal, final Food food) {
        animal.eat(food);
    }

    public final void getVoice(final Voice animal) {
        System.out.println(((Animal) animal).getType() + " " + ((Animal) animal).getName()
                + " подал(-а) голос: " + animal.voice());
    }
}
