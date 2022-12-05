package Opg10;

public class Main {
    public static void main(String[] args) {
        int[] t1 = {5, 42, 9, 53, 3, 10};
        int[] t2 = {3, 9, 19, 33, 10, 1};
        printArray(t1);
        printArray(t2);
        maxArray(t1, t2);
        printArray(t1);
        printArray(t2);
    }

    public static void printArray(int[] x) {
        for (int i : x) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    //PRE: x & y are the same length.
    public static void maxArray(int[] x, int[] y) {
        for(int i = 0; i < x.length; i++) {
            if (x[i] < y[i]) {
                x[i] = y[i];
            }
        }
    }
}
