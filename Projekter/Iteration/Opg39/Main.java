package Opg39;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] t1 = { 3, 8, 9, 4, 3, 6, 5, 4, 1, 7,
            2, 8, 7, 6, 9, 4, 5, 2, 6, 1,
            0, 4, 9, 7, 8, 6, 2, 4, 9, 2 };
        
        int[] counter = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ArrayList<Integer> list = new ArrayList<>();

        countArray(counter, t1);
        printArray(counter);
        pourArray(counter, list);
        printArray(list);
        printArray(counter);
    }

    public static void pourArray(int[] counter, ArrayList<Integer> array) {
        for(int i = 0; i < counter.length; i++) {
            while(counter[i] > 0) {
                array.add(i);
                counter[i]--;
            }
        }
    }

    public static void countArray(int[] counter, int[] array) {
        for (int i : array) {
            counter[i]++;
        }
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void printArray(ArrayList<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println("");
    }
}
