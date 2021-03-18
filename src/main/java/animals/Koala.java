package animals;

public class Koala extends Herbivore implements Run, Voice {

    public Koala(String name) {
        super("Коала", name);
    }

    @Override
    public void run() {
        System.out.println("Коала " + getName() + " бежит");
    }

    @Override
    public String voice() {
        return "Рррр-рррр";
    }
}
