package Opg28;

public class Main {
    public static void main(String[] args) {
        int T1[] = { 44, 71, 93, 24, 35, 21, 64 };
        int greatest = 0;
        for (int i : T1) {
            if (i > greatest) {
                greatest = i;
            }
        }
        System.out.println(greatest);
    }
}
