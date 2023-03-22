package NeumannsRNG;

import java.util.Scanner;

/*
 * Produce pesudorandom numbers:
 * 1. Initial value 4 digits / 0000 -> 9999.
 * 2. Multiply by itself. This should result in 8 digits, if not, add leading zeros.
 * 3. Truncate the first and last 2 digits (remove)
 * 4. Return a value containing 4 digits.
 * 5. If desired, repeat with the returned number.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            promptDigits();
            String inputDigits = scanner.nextLine();
            if (inputDigits.equals("")) {
                break;
            }
            promptLoops();
            String inputLoops = scanner.nextLine();
            if (inputLoops.equals("")) {
                break;
            }
            System.out.println(generate(inputDigits, Integer.parseInt(inputLoops)));
        }
        scanner.close();
    }

    //PRE: The input is a 4 digit int.
    public static String generate(String n, int loops) {
        //multiply
        int multiplied = Integer.parseInt(n) * Integer.parseInt(n);
        String multipliedString = Integer.toString(multiplied);

        //add leading zeros if the length is less than 8.
        if (multipliedString.length() < 8) {
            while (multipliedString.length() < 8) {
                multipliedString = "0" + multipliedString;
            }
        }

        //truncate first 2 and last 2
        String result = multipliedString.substring(2, 6);

        if (loops == 1) { //return 4 digit result when loops left is 1
            return String.format("Your random number is: %s", result);
        }
        
        //if multiple loops desired, recur
        loops--;
        return generate(result, loops);
    }

    private static void promptDigits() {
        String lines = "======================================================\n";
        System.out.printf("%sInput a number. 1-4 digits. Input nothing to exit.\n%s", lines, lines);
    }

    private static void promptLoops() {
        String lines = "======================================================\n";
        System.out.printf("%sInput times to loop // Input nothing to exit.\n%s", lines, lines);
    }
}
