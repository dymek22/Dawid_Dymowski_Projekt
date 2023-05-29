package models;

// Abstrakcyjna klasa reprezentująca podatki
public abstract class Podatek {
    protected double dochod;

    public Podatek(double dochod) {
        this.dochod = dochod;
    }

    public abstract double obliczPodatek();
}
