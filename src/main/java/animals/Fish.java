package animals;

public class Fish extends Carnivorous implements Swim {

    public Fish(String name) {
        super("Рыба", name);
    }

    @Override
    public void swim() {
        System.out.println("Рыба " + getName() + " плывет");
    }
}
