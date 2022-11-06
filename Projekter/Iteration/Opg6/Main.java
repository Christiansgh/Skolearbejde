package Opg6;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i <= 20; i++) {
            if(!(i % 2 == 0)) {
                sum += i;
            }
        }
        System.out.println("The sum of the odd numbers is: " + sum);
        //iterate 1-20
        //add odd numbers to sum
        //print sum
    }
}
