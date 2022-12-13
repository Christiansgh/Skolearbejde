package Opg9;

public class Main {
    public static void main(String[] args) {
        int[] t1 = {5, 42, 9, 53, 3, 10};
        int[] t2 = {3, 9, 19, 33, 10, 1};
        printArray(t1);
        printArray(t2);
        add(t1, t2);
        printArray(t1);
        printArray(t2);
    }

    public static void add(int[] x, int[] y) {
        for(int i = 0; i < x.length; i++) {
            x[i] += y[i];
        }
    }

    public static void printArray(int[] x) {
        for (int i : x) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
