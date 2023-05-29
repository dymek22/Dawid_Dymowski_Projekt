//Programowanie Obiektowe - projekt, zaliczenie
//Dawid Dymowski 72151 INLS2

import java.util.Scanner;

// Abstrakcyjna klasa reprezentująca podatki
abstract class Podatek {
    protected double dochod;

    public Podatek(double dochod) {
        this.dochod = dochod;
    }

    public abstract double obliczPodatek();
}

// Implementacja klasy Podatek dla podatku liniowego
class PodatekLiniowy extends Podatek {
    public PodatekLiniowy(double dochod) {
        super(dochod);
    }

    @Override
    public double obliczPodatek() {
        return dochod * 0.19;
    }
}

// Implementacja klasy Podatek dla progresywnego podatku dochodowego
class PodatekProgresywny extends Podatek {
    public PodatekProgresywny(double dochod) {
        super(dochod);
    }

    @Override
    public double obliczPodatek() {
        if (dochod <= 85528) {
            return dochod * 0.18;
        } else {
            return (dochod - 85528) * 0.32 + 15395.04;
        }
    }
}

// Interfejs definiujący operacje na podatkach
interface PodatekInterfejs {
    double obliczPodatek();
}

// Kontroler programu
class PodatkiController {
    private Scanner scanner;

    public PodatkiController() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Witaj w programie do obliczania podatków!");

        System.out.print("Podaj dochód: ");
        double dochod = scanner.nextDouble();

        System.out.print("Wybierz rodzaj podatku (1 - liniowy, 2 - progresywny): ");
        int wybor = scanner.nextInt();

        Podatek podatek;

        switch (wybor) {
            case 1:
                podatek = new PodatekLiniowy(dochod);
                break;
            case 2:
                podatek = new PodatekProgresywny(dochod);
                break;
            default:
                System.out.println("Nieprawidłowy wybór. Wybieram domyślny podatek liniowy.");
                podatek = new PodatekLiniowy(dochod);
                break;
        }

        double kwotaPodatku = podatek.obliczPodatek();
        System.out.println("Podatek do zapłacenia: " + kwotaPodatku);
    }
}

// Główna klasa programu
public class ProgramPodatkowy {
    public static void main(String[] args) {
        PodatkiController controller = new PodatkiController();
        controller.start();
    }
}
