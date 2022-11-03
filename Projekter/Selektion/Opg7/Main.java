package Opg7;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number1:");
        int number1 = Integer.valueOf(scanner.nextLine());
        System.out.println("Input number2:");
        int number2 = Integer.valueOf(scanner.nextLine());
        if(number1 - number2 >= 10) {
            System.out.println("Der er større forskel end ");
        }
        scanner.close();
    }   
}
