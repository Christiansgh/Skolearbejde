package Opg6;

public class Main {
    public static void main(String[] args) {
        tegnLinie(10, '#');
    }

    public static void tegnLinie(int mængde, char tegn) {
        for(int i = 0; i < mængde; i++) {
            System.out.print(tegn);
        }
    }
}
