package Opg3;

public class Main {
    public static void main(String[] args) {
        midterst(6, 10, 8);
    }

    public static void midterst(int x, int y, int z) {
        if (y < x && x > z) {
            System.out.println(x);
        }

        else if(x > y && y < z) {
            System.out.println(y);
        }

        else {
            System.out.println(z);
        }
    }
}
