package animals;

import Aviary.AviarySize;

public class Fish extends Carnivorous implements Swim {

    public Fish(final String name) {
        super("Рыба", name, AviarySize.SMALL);
    }

    @Override
    public final void swim() {
        System.out.println("Рыба " + getName() + " плывет");
    }
}
