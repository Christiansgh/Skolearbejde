package Opg32;

public class Main {
    public static void main(String[] args) {
        int T1[] = { 44, 71, 93, 24, 35, 21, 64 };
        for (int i = 1; i < T1.length; i++) {
            System.out.print("(" + T1[i-1] + " " + T1[i] + ")");
        }
    }
}
