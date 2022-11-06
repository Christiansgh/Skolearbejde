package Opg2;

public abstract class Bolig {
    protected double inside_m2;

    /*
     * constructors
     */
    public Bolig(double inside_m2) {
        set(inside_m2);
    }

    public Bolig(Bolig other) {
        set(other.inside_m2);
    }

    /*
     * set & get
     */
    public void set(double inside_m2) {
        this.inside_m2 = inside_m2;
    }

    public double getInside() {
        return inside_m2;
    }
    
    /*
     * årligHusleje
     */
    public abstract double yearlyRent();
}