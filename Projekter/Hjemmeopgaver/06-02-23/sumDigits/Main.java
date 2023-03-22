package sumDigits;

/*
 * Take a positive int n
 * return the sum of its digits. I.e. 126 = 1 + 2 + 6 = 9.
 * 
 * use recursion.
 * no loops allowed.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(123456789));
        System.out.println(sumOfDigits(126));
    }

    public static int sumOfDigits(int num) {
    //define the base case / stopping condition:
    //all the numbers are added up.
        if (num == 0) {
            return 0;
        } 

        //recursion to shrink the problem.
        //% 10 returns the "rest / leftovers from / 10."
        //then call itself with the leftovers removed.
        //the leftovers are accumulated in the returned int.
        return (num % 10 + sumOfDigits(num / 10));
    }
}
