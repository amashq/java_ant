package animals;

import Aviary.AviarySize;

public class Koala extends Herbivore implements Run, Voice {

    public Koala(final String name) {
        super("Коала", name, AviarySize.BIG);
    }

    @Override
    public final void run() {
        System.out.println("Коала " + getName() + " бежит");
    }

    @Override
    public final String voice() {
        return "Рррр-рррр";
    }
}
