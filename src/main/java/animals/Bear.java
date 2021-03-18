package animals;

public class Bear extends Carnivorous implements Run, Swim, Voice {

    public Bear(String name) {
        super("Медведь", name);
    }

    @Override
    public void run() {
        System.out.println("Медведь " + getName() + " бежит");
    }

    @Override
    public void swim() {
        System.out.println("Медведь " + getName() + " плывет");
    }

    @Override
    public String voice() {
        return "Ггррррр";
    }
}
