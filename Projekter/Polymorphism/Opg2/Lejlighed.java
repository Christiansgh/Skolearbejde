package Opg2;

public class Lejlighed extends Bolig {
    private double monthlyRent;
    
    public Lejlighed(double inside_m2, double monthlyRent) {
        super(inside_m2);
        this.monthlyRent = monthlyRent;
    }

    public Lejlighed(Bolig otherB, Lejlighed otherL) {
        super(otherB);
        monthlyRent = otherL.monthlyRent;
    }


    public double yearlyRent() {
        return monthlyRent * 12;
    }

    @Override
    public String toString() {
        return "Lejligheden er " + getInside() + 
        " m2. Den årlige husleje er " + yearlyRent() + ".";
    }
}
