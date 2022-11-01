package Opg5;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input tal 1:");
        int a = Integer.valueOf(scanner.nextLine());
        System.out.println("Input tal 2:");
        int b = Integer.valueOf(scanner.nextLine());
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));
        scanner.close();
    }
}
