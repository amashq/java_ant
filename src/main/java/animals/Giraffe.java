package animals;

public class Giraffe extends Herbivore implements Run, Voice {
    public Giraffe(String name) {
        super("Жираф", name);
    }

    @Override
    public void run() {
        System.out.println("Жираф " + getName() + " бежит");
    }

    @Override
    public String voice() {
        return "Груу-уууу";
    }
}
