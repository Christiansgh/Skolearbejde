package Opg5;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number:");
        int x = Integer.valueOf(scanner.nextLine());
        int y = x / 10;
        //pre 10+
        switch(y) {
        case 1:
            System.out.println(format(x, y));
            break;
        case 2:
            System.out.println(format(x, y));
            break;
        case 3:
            System.out.println(format(x, y));
            break;
        case 4:
            System.out.println(format(x, y));
            break;
        case 5:
            System.out.println(format(x, y));
            break;
        case 6:
            System.out.println(format(x, y));
            break;
        case 7:
            System.out.println(format(x, y));
            break;
        case 8:
            System.out.println(format(x, y));
            break;
        case 9:
            System.out.println(format(x, y));
            break;
        default:
            System.out.println("[100:...]");
        }
        scanner.close();
    }
    public static String format(int x, int y) {
        return "Nummeret " + x + " tilhoerer intervallet: ["+y+"0:"+y+"9]";
    }
}
