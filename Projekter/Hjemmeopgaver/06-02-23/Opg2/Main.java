package Opg2;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Locale locale = new Locale("en", "US");
        int[] occurance = new int[256]; // 256 ASCII characters
        int totalChars = 0;

        File file = new File("Opg2/jekyll_hyde.txt");
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNextLine()) { //keep iterating until we run out of lines.
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char bogstav = line.charAt(i); //iterate through the line. 
                occurance[(int) bogstav]++; //cast the char into an int. increment the index to keep track of times occured.
                totalChars ++;
            }
        }
        scanner.close(); //all lines have been counted.

        for (int i = 0; i < occurance.length; i++) { 
            if (occurance[i] > 0) { //if not found, dont print.
                System.out.printf("[%c] occured [%,6d] times out of %,d times | %.2f%%.\n", (char) i, occurance[i], totalChars, (double) occurance[i] / totalChars * 100);
            }
        }

        /*
         * O(n) - worst case:
         *  - iterate through the entire text file.
         *  - constant amount of work.
         *      - increment [] occurance 
         *          - amount of computations is linear / proportional to the amount of characters that need to be analyzed.
         */
    }
}
