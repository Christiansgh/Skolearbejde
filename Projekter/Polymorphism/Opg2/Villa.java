package Opg2;

public class Villa extends Bolig {
    private double outside_m2;
    private double buyingPrice;
    private boolean outOfTown;

    public Villa(double inside_m2, double outside_m2, double buyingPrice, boolean outOfTown) {
        super(inside_m2);
        set(outside_m2, buyingPrice, outOfTown);
    }

    public Villa(Villa other) {
        super(other);
        set(other.outside_m2, other.buyingPrice, other.outOfTown);
    }

    public void set(double outside_m2, double buyingPrice, boolean outOfTown) {
        this.outside_m2 = outside_m2;
        this.buyingPrice = buyingPrice;
        this.outOfTown = outOfTown;
    }

    public double yearlyRent() {
        if (outOfTown) 
            return buyingPrice * 0.12;
        else 
            return buyingPrice * 0.10;
    }

    @Override
    public String toString() {
        return "Villaen er " + super.toString() + 
        ". Den omkringliggende grund er " + outside_m2 + 
        " m2. Huset koster " + buyingPrice + 
        ". Den årlige husleje er " + yearlyRent() + ". ";
    }
}
