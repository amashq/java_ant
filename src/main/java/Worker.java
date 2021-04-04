import Aviary.WrongFoodException;
import animals.Animal;
import animals.Voice;
import food.Food;
import java.util.Random;

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

//     public void feed(Animal animal, Food food) {

//         if (animal.getSatiety() < 0) {
//             System.out.println("Некого кормить. Животное '" + animal.getType() + "' погибло от голода :(");
//             return;
//         }
//         int eating = animal.getSatiety();

//         if (animal.eat(food)) {
//             eating += new Random().nextInt(10) + 1;
//             animal.setSatiety(eating);
//         } else {
//             animal.setSatiety(eating - new Random().nextInt(10) + 1);
//         }

//         if (animal.getSatiety() < 0) {
//             System.out.println("Животное '" + animal.getType() + "' погибло от голода :(");
//         }
//     }
    }
}
