package Opg21;

public class Main {
    public static void main(String[] args) {
        int T3[] = { 25, 54, 62, 10, 99, 45, 23 };
        int j = T3.length - 1;
        for(int i = 0; i < T3.length; i++) {
            System.out.println(T3[j]);
            j--;
        }
    }
}
