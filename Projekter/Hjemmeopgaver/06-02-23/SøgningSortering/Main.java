package SøgningSortering;

import java.util.Arrays;

/**
 * Testanvendelse af:
 * Javas understøttelse af søgning & sortering.
 * int [] & String []
 * selvvalgt indhold.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("test");

        //declare arrays
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};    
        String[] words = {"flag", "evig", "dag", "citron", "bog", "abe"};

        System.out.println("=== Pre sort ===");
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(words));
        
        //sort the arrays
        Arrays.sort(nums);
        Arrays.sort(words);

        //test the sort
        System.out.println("=== Post sort ===");
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(words));

        //search and return index
        int indexOfSix = Arrays.binarySearch(nums, 6);
        int indexOfBog = Arrays.binarySearch(words, "bog");

        //test the index
        System.out.printf("Index of \"6\" = %d, Index of \"Bog\" = %d\n", indexOfSix, indexOfBog);
    }
}