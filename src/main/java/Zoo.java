import Aviary.Aviary;
import Aviary.AviarySize;
import animals.*;
import food.*;

import java.util.Random;

public class Zoo {

    public static void main(final String[] args) {

        Worker worker = new Worker();

        Bear bear = new Bear("Буренький");
        Duck duck = new Duck("Кряква");
        Duck duck1 = new Duck("Лиана");
        Fish fish = new Fish("Роберт");
        Giraffe giraffe = new Giraffe("Василий");
        Koala koala = new Koala("Нюша");
        Lynx lynx = new Lynx("Лея");

        Carrot carrot = new Carrot();
        Clover clover = new Clover();
        Eucalyptus eucalyptus = new Eucalyptus();
        Pork pork = new Pork();
        Rabbit rabbit = new Rabbit();
        SmallFish smallFish = new SmallFish();

        Animal[] animals = {bear, duck, duck1, fish, giraffe, koala, lynx};

        Swim[] pond = {bear, duck, duck1, fish, lynx};
        Food[] foods = {carrot, clover, eucalyptus, pork, rabbit, smallFish};

        System.out.println("\nЗаплыв!");
        for (Swim animal : pond) {
            animal.swim();
        }

        System.out.println("\nВсе говорят!");
        Voice[] voices = {bear, duck, duck1, giraffe, koala, lynx};
        for (Voice voice : voices) {
            worker.getVoice(voice);
        }

        System.out.println("\nВремя еды!");
        for (int i = 0; i < 40; i++) {
            worker.feed(animals[new Random().nextInt(animals.length)],
                    foods[new Random().nextInt(foods.length)]);
        }

        System.out.println("\nДобавление в вольеры!");
        Aviary<Herbivore> aviarySmall = new Aviary(AviarySize.SMALL);
        Aviary<Carnivorous> aviaryNormal = new Aviary(AviarySize.NORMAL);
        Aviary<Herbivore> aviaryBig = new Aviary(AviarySize.BIG);
        Aviary<Carnivorous> aviaryLarge = new Aviary(AviarySize.LARGE);
        Aviary[] aviaries = {aviarySmall, aviaryNormal, aviaryBig, aviaryLarge};

        for (Aviary a : aviaries) {
            a.add(animals[new Random().nextInt(animals.length)]);
            a.remove(animals[new Random().nextInt(animals.length)].getName());
        }
    }
}
