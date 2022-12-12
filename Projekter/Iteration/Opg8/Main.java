package Opg8;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input lower bound: ");
        int min = Integer.valueOf(scanner.nextLine());
        System.out.println("Input upper bound:");
        int max = Integer.valueOf(scanner.nextLine());
        int sum = 0;
        int nums = 0;
        System.out.print("for ["+min+":"+max+"] (");
        for(int c = min; c <= max; c++) {
            if(c % 2 == 0) {
                sum += c;
                nums++;
                System.out.print(c + " ");
            }
        }
        double avg = sum / nums;
        System.out.println(") = " + sum + " / " + nums + " = " + avg);
        scanner.close();
    }
}
