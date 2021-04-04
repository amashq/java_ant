package Aviary;

import animals.Animal;

import java.util.HashMap;
import java.util.Map;

public class Aviary<T extends Animal> {

    private AviarySize size;
    private Map<String, T> animals;

    public Aviary(final AviarySize size) {
        animals = new HashMap<>();
        this.size = size;
    }

    public final void add(final T animal) {
        if (animal.getSize().getAviarySize() < size.getAviarySize()) {
            animals.put(animal.getName(), animal);
            System.out.println(animal.getName() + " добавлен в вольер размера " + size);
        } else {
            System.out.println("Размер вольера " + size + " не подходит животному "
                    + animal.getType() + " " + animal.getName());
        }
    }

    public final void remove(final String name) {
        if (animals.remove(name) == null) {
            System.out.println("Животного " + name + " нет в вольере");
        } else {
            System.out.println(name + " удален из вольера");
        }
    }

    private Animal getAnimalByName(final String name) {
        return animals.get(name);
    }
}
