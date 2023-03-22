/*
 * Represent a fraction.
 *  numerator & denominator.
 * 
 *  toString()
 * 
 *  + - * / operators
 */
public class Main {
    public static void main(String[] args) {
        Fraction a = new Fraction(1, 3);
        Fraction b = new Fraction(1, 2);
        Fraction c = Fraction.add(a, b);
        System.out.println(c);
    }
}