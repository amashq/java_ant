package food;

public abstract class Food {
    private String name;

    public Food(final String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }
}
