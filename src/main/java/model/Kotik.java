package model;

import java.util.Random;

public class Kotik {

    private final Random random = new Random();

    private static int countOfCopy;

    private int satiety;

    private int prettiness;
    private String name;
    private int weight;
    private String meow;

    public Kotik(int prettiness, String name, int weight, String meow) {
        this.prettiness = prettiness;
        this.name = name;
        this.weight = weight;
        this.meow = meow;
        this.satiety = random.nextInt(5) + 1;
        countOfCopy++;
    }

    public Kotik() {
        countOfCopy++;
    }

    public void setKotik(int prettiness, String name, int weight, String meow) {
        this.prettiness = prettiness;
        this.name = name;
        this.weight = weight;
        this.meow = meow;
        this.satiety = random.nextInt(5) + 1;
    }

    public int getPrettiness() {
        return prettiness;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getMeow() {
        return meow;
    }

    public static int getCountOfCopy() {
        return countOfCopy;
    }

    public boolean play() {
        if (satiety <= 0) return false;
        System.out.println("Котик наслаждается игрой");
        return true;
    }

    public boolean sleep() {
        if (satiety <= 0) return false;
        System.out.println("Котик сыт и спит");
        return true;
    }

    public boolean chaseMouse() {
        if (satiety <= 0) return false;
        System.out.println("Котик ловит мышей");
        return true;
    }

    public boolean wash() {
        if (satiety <= 0) return false;
        System.out.println("Котик моется");
        return true;
    }

    public boolean lookWindow() {
        if (satiety <= 0) return false;
        System.out.println("Котик наблюдает за тем, что творится за окном");
        return true;
    }

    public void liveAnotherDay() {

        int randomNumber;
        boolean executeAction = true;
        int countMethod = 5;
        int eatMethodsNum = 3;

        for (int i = 0; i < 24; i++) {
            System.out.print(i + 1 + ": ");

            randomNumber = random.nextInt(countMethod) + 1;

            switch (randomNumber) {
                case 1:
                    executeAction = play();
                    break;
                case 2:
                    executeAction = sleep();
                    break;
                case 3:
                    executeAction = chaseMouse();
                    break;
                case 4:
                    executeAction = wash();
                    break;
                case 5:
                    executeAction = lookWindow();
                    break;
            }

            if (!executeAction) {

                randomNumber = random.nextInt(eatMethodsNum) + 1;
                switch (randomNumber) {
                    case 1:
                        eat(random.nextInt(5) + 1);
                        break;
                    case 2:
                        eat();
                        break;
                    case 3:
                        eat(random.nextInt(5) + 1, "Вкусняшка");
                        break;
                }
            } else {
                satiety -= random.nextInt(5) + 1;
            }
        }
    }

    public void eat(int countOfFood) {
        this.satiety += countOfFood;
        System.out.println("Котик покушал еды в количестве " + countOfFood + ", теперь он доволен.");
    }

    public void eat(int countOfFood, String nameOfFood) {
        this.satiety += countOfFood;
        System.out.println("Котик покушал еды " + nameOfFood + " в количестве " + countOfFood + ", теперь он доволен.");
    }

    public void eat() {
        eat(random.nextInt(5) + 1, "Рыба");
    }

}
