package Opg2;

public abstract class Bolig {
    private double inside_m2;

    /*
     * constructors
     */
    public Bolig(double inside_m2) {
        this.inside_m2 = inside_m2;
    }

    public Bolig(Bolig other) {
        this(other.inside_m2);
    }
    
    /*
     * årligHusleje
     */
    public abstract double yearlyRent();

    public String toString() {
        return inside_m2 + " m2";
    }
}