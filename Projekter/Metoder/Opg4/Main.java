package Opg4;

public class Main {
    public static void main(String[] args) {
        int x = 20;
        stjerneLinie(x);
    }

    public static void stjerneLinie(int x) {
        for(int i = 0; i < x; i++) {
            System.out.print("*");
        }
    }
}
