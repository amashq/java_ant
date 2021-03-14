import model.Kotik;

public class Application {

    public static void main(String[] args) {

        Kotik Peryshko = new Kotik(8, "Перышко", 5, "Мяу-Мяу");
        Kotik Milka = new Kotik();

        Milka.setKotik(10, "Милка", 3, "Мяяяяу");

        Milka.liveAnotherDay();
        System.out.println("\nМилый котик " + Milka.getName() + " весит " + Milka.getWeight() + " кг");

        if (Peryshko.getMeow().equals(Milka.getMeow())) {
            System.out.println("Котики разговаривают одинаково :)");
        } else {
            System.out.println("Котики говорят разные слова ");
        }

        System.out.println("\nБыло создано " + Kotik.getCountOfCopy() + " котиков");
    }
}
