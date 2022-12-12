package Opg25;

public class Main {
    public static void main(String[] args) {
        int T3[] = { 25, 54, 62, 10, 99, 45, 23 };
        int half = T3.length / 2;
        int j = T3.length - 1;
        int temp = 0;
        for(int i = 0; i < half; i++) {
            temp = T3[i];
            T3[i] = T3[j];
            T3[j] = temp;
            j--;
        } 

        for (int i : T3) {
            System.out.print(i + " ");
        }
    }
}
