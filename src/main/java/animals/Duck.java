package animals;

public class Duck extends Herbivore implements Fly, Swim, Run, Voice {

    public Duck(String name) {
        super("Утка", name);
    }

    @Override
    public void fly() {
        System.out.println("Утка " + getName() + " летит");
    }

    @Override
    public void run() {
        System.out.println("Утка " + getName() + " бежит");
    }

    @Override
    public void swim() {
        System.out.println("Утка " + getName() + " плывет");
    }

    @Override
    public String voice() {
        return "Кря-кря";
    }
}
