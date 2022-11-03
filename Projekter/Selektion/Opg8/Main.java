package Opg8;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Roll the dice! Press anything to roll, 0 to quit!");
            String input = scanner.nextLine();
            if(input.equals("0")) {
                break;
            }
            double roll = Math.floor(Math.random() * 5);
            roll += 1;
            int x = (int)roll;
            switch(x) {
                case 1:
                    System.out.println(redundancy(1));
                    break;
                case 2:
                    System.out.println(redundancy(2));
                    break;
                case 3:
                    System.out.println(redundancy(3));
                    break;
                case 4:
                    System.out.println(redundancy(4));
                    break;
                case 5:
                    System.out.println(redundancy(5));
                    break;
                case 6:
                    System.out.println(redundancy(6));
                    break;
            }
            scanner.close();
        }
    }
    public static String redundancy(int x) {
        return "You rolled a " + x + ".";
    }
}
