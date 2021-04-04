package animals;

import Aviary.AviarySize;

public class Bear extends Carnivorous implements Run, Swim, Voice {

    public Bear(final String name) {
        super("Медведь", name, AviarySize.LARGE);
    }

    @Override
    public final void run() {
        System.out.println("Медведь " + getName() + " бежит");
    }

    @Override
    public final void swim() {
        System.out.println("Медведь " + getName() + " плывет");
    }

    @Override
    public final String voice() {
        return "Ггррррр";
    }
}
