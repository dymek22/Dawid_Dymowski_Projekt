package controllers;

import models.Podatek;

import java.util.Scanner;
import models.PodatekLiniowy;
import models.PodatekProgresywny;


public class PodatkiController{
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

