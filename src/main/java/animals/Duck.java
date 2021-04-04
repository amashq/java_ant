package animals;

import Aviary.AviarySize;

public class Duck extends Herbivore implements Fly, Swim, Run, Voice {

    public Duck(final String name) {
        super("Утка", name, AviarySize.NORMAL);
    }

    @Override
    public final void fly() {
        System.out.println("Утка " + getName() + " летит");
    }

    @Override
    public final void run() {
        System.out.println("Утка " + getName() + " бежит");
    }

    @Override
    public final void swim() {
        System.out.println("Утка " + getName() + " плывет");
    }

    @Override
    public final String voice() {
        return "Кря-кря";
    }
}
