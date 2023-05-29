package models;
import interfaces.PodatekInterfejs;
public class PodatekProgresywny extends Podatek implements PodatekInterfejs{
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
