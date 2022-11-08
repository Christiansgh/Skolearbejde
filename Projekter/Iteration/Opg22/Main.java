package Opg22;

public class Main {
    public static void main(String[] args) {
        int T4[] = { 36, 20, 71, 45, 94, 36, 41 };
        int T5[] = { 53, 34, 31, 88, 85, 90, 11 };    	
        int j = T5.length - 4;
        printArray(T4);
        for(int i = 0; i < 3; i++) {
            T4[i] = T5[j];
            j++;
        }
        printArray(T4);
    }

    public static void printArray(int[] x) {
        for (int i : x) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
