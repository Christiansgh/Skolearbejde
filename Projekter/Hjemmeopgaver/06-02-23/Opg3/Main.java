package Opg3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Read a textfile.
 * Write it onto another textfile.
 * Sort out any characters that arent the characters from a-z and spaces
 */
public class Main {
    public static void main(String[] args) {
        File inputFile = new File("Opg3/jekyll_hyde.txt");
        File outputFile = new File("Opg3/result.txt");
        String filteredInput = "";

        //read and filter the inputfile.
        try {
            Scanner scanner = new Scanner(inputFile);
            while(scanner.hasNextLine()) { //read
                String line = scanner.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    char character = line.charAt(i);
                    if(Character.isLetter(character) || character == ' ') { //filter 
                        filteredInput += character;
                    }
                }
                filteredInput += "\n"; //after line, change to new line.
            }
            scanner.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found!");
        }

        //write the filtered input onto a new file.
        try {
            FileWriter writer = new FileWriter(outputFile);
            writer.write(filteredInput);
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Cant write to output file!");
        }
    }
}
