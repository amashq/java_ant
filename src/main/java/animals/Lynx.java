package animals;

import Aviary.AviarySize;

public class Lynx extends Carnivorous implements Run, Swim, Voice {

    public Lynx(final String name) {
        super("Рысь", name, AviarySize.LARGE);
    }

    @Override
    public final void run() {
        System.out.println("Рысь " + getName() + " бежит");
    }

    @Override
    public final void swim() {
        System.out.println("Рысь " + getName() + " плывет");
    }

    @Override
    public final String voice() {
        return "Рррмяу-ррр";
    }
}
