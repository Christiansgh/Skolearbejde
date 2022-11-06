package Opg7;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input lower bound: ");
        int min = Integer.valueOf(scanner.nextLine());
        System.out.println("Input upper bound:");
        int max = Integer.valueOf(scanner.nextLine());
        int oddNums = 0;
        int evenNums = 0;
        int counter = min;
        while(counter <= max) {
            if(counter % 2 == 0) {
                evenNums++;
            }
            else oddNums++; 
            counter++;
        }
        System.out.println("Odd nums: " + oddNums);
        System.out.println("Even nums: " + evenNums);
        System.out.println("In the interval [" + min + ":" + max + "]");
        scanner.close();
        //to variable max min 3 16
        //iterate through range
        //count num of odd & even numbers
        //print num of odd & even numbers
    }
}
