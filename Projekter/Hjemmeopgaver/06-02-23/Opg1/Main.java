package Opg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    /*
     * Tager en tekst fil som kilde.
     * Indlæs tekstfilen (scanner)
     * Udskriv tekstfilen while(scanner.hasNextLine)
     */
    
     public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Opg1/jekyll_hyde.txt");
        Scanner scanner = new Scanner(file);
        
        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        scanner.close();
     }
}