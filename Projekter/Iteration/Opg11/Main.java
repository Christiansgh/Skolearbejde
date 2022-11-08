package Opg11;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input tallet som skal checkes:");
        int n = Integer.valueOf(scanner.nextLine());
        for(int i = 2; i <= 100; i++) {
            if (n % 2 == 0 && (!(n == 2))) {
                System.out.println("Tallet er lige, og derfor ikke et primtal.");
                break;
            }
            else if (n % i == 0) {
                if (n == i) {
                    continue;
                }
                else {
                    System.out.println(n + " % " + i + 
                    " = 0. Tallet går op i andet end sig selv, og er derfor ikke et primtal.");
                    break;
                }
            }
            else if (i == 100) {
                System.out.println("Tallet er et primtal!");
            }
        }
        scanner.close();
    } 
}
