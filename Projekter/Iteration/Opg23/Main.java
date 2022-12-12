package Opg23;

public class Main {
    public static void main(String[] args) {
        int PosNeg[]= { 4, 9, -2, -6, 2, 6, -9, 4, 9, -1, 1, 0, -3, -3, 2, 7 };
        for (int i : PosNeg) {
            i *= -1;
            System.out.print(i + " ");
        }
    }
}
