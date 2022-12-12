package Opg4;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number");
        int n = Integer.valueOf(scanner.nextLine());
        int total = 1;
        int prevResult = 1;
        for(int i = 1; i <= n; i++) {
            total *= i;
            System.out.println(prevResult + " x " + i + " = " + total);
            prevResult = total;
        }
        scanner.close();
    }
}
