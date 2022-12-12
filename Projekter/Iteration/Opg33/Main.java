package Opg33;

public class Main {
    public static void main(String[] args) {
        int T1[] = { 44, 71, 93, 24, 35, 21, 64 };
        for (int i = 1; i < T1.length; i++) {
            System.out.print("(" + T1[i-1] + " " + T1[i] + ")");
            if (!(T1[i-1] == T1[i])) {
                if (T1[i] > T1[i-1]) {
                    T1[i] -= 1;
                    T1[i-1] += 1;
                }
                else {
                    T1[i] += 1;
                    T1[i-1] -= 1;
                }
            }
        }
        System.out.println("");
        for (int i = 1; i < T1.length; i++) {
            System.out.print("(" + T1[i-1] + " " + T1[i] + ")");
        }
    }
}
