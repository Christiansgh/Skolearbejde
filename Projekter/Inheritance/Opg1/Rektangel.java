package Opg1;

public class Rektangel extends Punkt {
    private double bredde;
    private double længde;

    public Rektangel(double x, double y, double bredde, double længde) {
        super(x, y);
        this.bredde = bredde;
        this.længde = længde;
    }

    public double areal() {
        return bredde*længde;
    }

    public double omkreds() {
        return bredde*2 + længde*2;
    }
}
