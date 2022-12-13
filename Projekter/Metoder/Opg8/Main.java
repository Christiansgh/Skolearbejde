package Opg8;

public class Main {
    public static void main(String[] args) {
        int[] tal = {1, 2, 3};
        printArray(tal);
        incrementArray(tal);
        printArray(tal);
    }

    public static void incrementArray(int[] x) {
        for (int i = 0; i < x.length; i++) {
            x[i]++;
        }
    }

    public static void printArray(int[] x) {
        for (int i : x) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
