package Opg1;

public class Cirkel extends Punkt {
    private double radius;

    public Cirkel(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    public double areal() {
        return Math.PI*Math.pow(radius, 2);
    }

    public double omkreds() {
        return 2*Math.PI*radius;
    }
}
