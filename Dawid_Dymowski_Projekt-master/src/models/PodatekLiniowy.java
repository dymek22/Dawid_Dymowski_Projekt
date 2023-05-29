package models;
import interfaces.PodatekInterfejs;
public class PodatekLiniowy extends Podatek implements PodatekInterfejs {
    public PodatekLiniowy(double dochod) {
        super(dochod);
    }

    @Override
    public double obliczPodatek() {
        return dochod * 0.19;
    }
}
