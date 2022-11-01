package Opg4;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input tal.");
        int tal = Integer.valueOf(scanner.nextLine());
        tal += 7;
        tal *= 2;
        System.out.println("Det bliver: " + tal);
        scanner.close();
    }    
}
