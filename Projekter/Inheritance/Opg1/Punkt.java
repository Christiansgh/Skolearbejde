package Opg1;

public class Punkt {
    private double x;
    private double y;

    /*
     * constructors
     */
    public Punkt(double x, double y) {
        setAll(x, y);
    }

    public Punkt(Punkt other) {
        setAll(other.x, other.y);
    }

    /*
     * setMethod
     */
    public void setAll(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /*
     * move
     */
    public void move(double x, double y) {
        setAll(this.x + x, this.y + y);
    }

    /*
     * toString
     */
    public String toString() {
        return "x: " + x + " y; " + y;
    }
}
