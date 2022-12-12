package Opg2;

public class Lejlighed extends Bolig {
    private double monthlyRent;
    
    public Lejlighed(double inside_m2, double monthlyRent) {
        super(inside_m2);
        this.monthlyRent = monthlyRent;
    }

    public Lejlighed(Lejlighed other) {
        super(other);
        monthlyRent = other.monthlyRent;
    }

    public double yearlyRent() {
        return monthlyRent * 12;
    }

    @Override
    public String toString() {
        return "Lejligheden er " + super.toString() + 
        ". Den årlige husleje er " + yearlyRent() + ".";
    }
}
