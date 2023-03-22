public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static Fraction add(Fraction a, Fraction b) {
        return new Fraction(a.numerator * b.denominator + b.numerator * a.denominator, a.denominator * b.denominator);
    }

    public static Fraction deduct(Fraction a, Fraction b) {
        return new Fraction(a.numerator * b.denominator - b.numerator * a.denominator, a.denominator * b.denominator);
    }

    public static Fraction multiply(Fraction a, Fraction b) {
        return new Fraction(a.numerator * b.numerator, a.denominator * b.denominator);
    }

    public static Fraction divide(Fraction a, Fraction b) {
        return new Fraction(a.numerator * b.denominator, a.denominator * b.numerator);
    }
    
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
