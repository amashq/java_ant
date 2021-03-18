package animals;

public class Lynx extends Carnivorous implements Run, Swim, Voice {

    public Lynx(String name) {
        super("Рысь", name);
    }

    @Override
    public void run() {
        System.out.println("Рысь " + getName() + " бежит");
    }

    @Override
    public void swim() {
        System.out.println("Рысь " + getName() + " плывет");
    }

    @Override
    public String voice() {
        return "Рррмяу-ррр";
    }
}
