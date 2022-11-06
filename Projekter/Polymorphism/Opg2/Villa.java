package Opg2;

public class Villa extends Bolig {
    private double outside_m2;
    private double buyingPrice;
    private boolean outOfTown;

    public Villa(double inside_m2, double outside_m2, double buyingPrice, boolean outOfTown) {
        super(inside_m2);
        set(outside_m2, buyingPrice, outOfTown);
    }

    public Villa(Bolig otherB, Villa otherV) {
        super(otherB);
        set(otherV.outside_m2, otherV.buyingPrice, otherV.outOfTown);
    }

    public void set(double outside_m2, double buyingPrice, boolean outOfTown) {
        this.outside_m2 = outside_m2;
        this.buyingPrice = buyingPrice;
        this.outOfTown = outOfTown;
    }

    public double yearlyRent() {
        if(outOfTown == true) {
            return buyingPrice * 0.12;
        }
        return buyingPrice * 0.1;
    }

    @Override
    public String toString() {
        return "Villaen er " + getInside() + 
        " m2. Den omkringliggende grund er " + outside_m2 + " m2. Huset koster " + buyingPrice + 
        ". Den årlige husleje er " + yearlyRent() + ". ";
    }
}
