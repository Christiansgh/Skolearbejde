package Opg11;

public class Main {
    public static void main(String[] args) {
        int[] første = {5, 42, 9, 53, 3, 10};
        int[] andet = {3, 9, 19, 33, 10, 1};
        printArray(første);
        printArray(andet);
        swap(første, andet);
        printArray(første);
        printArray(andet);
    }

    public static void swap(int[] x, int[] y) {
        int temp = 0;
        for(int i = 0; i < x.length; i++) {
            temp = x[i];
            x[i] = y[i];
            y[i] = temp;
        }
    }

    public static void printArray(int[] x) {
        for (int i : x) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
