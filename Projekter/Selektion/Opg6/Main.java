package Opg6;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input 3 numbers:");
        System.out.println("Input the first number(x):");
        int x = Integer.valueOf(scanner.nextLine());
        System.out.println("Input the second number(y):");
        int y = Integer.valueOf(scanner.nextLine());
        System.out.println("Input the third number(z):");
        int z = Integer.valueOf(scanner.nextLine());
        scanner.close();
        if(x > y) {
            if(z > x) {
                result("x");
            }
            else if(y > z) {
                result("y");
            }
            else if(z > y) {
                result("z");
            }
        }
        else if(y > x) {
            if(y > z) {
                result("z");
            }
            else if(z > y) {
                result("y");
            }
            else if(x > z) {
                result("x");
            }
        }
        else if(x == y || x == z || y == z) {
            if(x == y) {
                result("x");
            }
            else if(x == z) {
                result("z");
            }
            else if(z == y) {
                result("y");
            }
        }
    }
    public static void result(String result) {
        System.out.println("The middle number is " + result);
    }
}