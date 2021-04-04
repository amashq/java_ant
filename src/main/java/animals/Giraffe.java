package animals;

import Aviary.AviarySize;

public class Giraffe extends Herbivore implements Run, Voice {
    public Giraffe(final String name) {
        super("Жираф", name, AviarySize.LARGE);
    }

    @Override
    public final void run() {
        System.out.println("Жираф " + getName() + " бежит");
    }

    @Override
    public final String voice() {
        return "Груу-уууу";
    }
}
