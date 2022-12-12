package Opg37;

public class Main {
    static boolean sorted = false;
    static int comparisons = 0;
    public static void main(String[] args) {
        int T1[] = { 44, 71, 93, 24, 35, 21, 64 };
        System.out.println("");
        System.out.println("Manuel:");
        
        //sorting by x
        printArray(T1);
        sortTimes(10, T1);
        printArray(T1);

        System.out.println("");
        System.out.println("Indtil:");
        int T2[] = { 44, 71, 93, 24, 35, 21, 64 };
        comparisons = 0;

        //sorting until sorted
        printArray(T2);
        sortUntil(T2);
        printArray(T2);
        System.out.println("");
    }

    public static void sortUntil(int[] array) {
        while(!checkSorted(array)) {
            sortArray(array);
        }
    }

    public static boolean checkSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if ((array[i-1] > array[i])) {
                return false;
            }
        }
        return true;
    }

    public static void sortArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            comparisons++;
            if ((array[i-1] > array[i])) {
                int temp = 0;
                temp = array[i-1];
                array[i-1] = array[i];
                array[i] = temp;
            }
        }
    }

    public static void sortTimes(int times, int[] array) {
        for(int i = 0; i < times; i++) {
            sortArray(array);
        }
    }

    public static void printArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            System.out.print("(" + array[i-1] + ", " + array[i] + ")");
        }
        System.out.println("");
        System.out.println("Sammenligninger: " + comparisons);
    }
}
