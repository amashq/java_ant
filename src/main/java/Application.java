import model.Kotik;

public class Application {

    public static void main(String[] args) {

        Kotik peryshko = new Kotik(8, "Перышко", 5, "Мяу-Мяу");
        Kotik milka = new Kotik();

        milka.setKotik(10, "Милка", 3, "Мяяяяу");

        milka.liveAnotherDay();
        System.out.println("\nМилый котик " + milka.getName() + " весит " + milka.getWeight() + " кг");

        if (peryshko.getMeow().equals(milka.getMeow())) {
            System.out.println("Котики разговаривают одинаково :)");
        } else {
            System.out.println("Котики говорят разные слова ");
        }

        System.out.println("\nБыло создано " + Kotik.getCountOfCopy() + " котиков");
    }
}
