package Opg10;

public class Main {
    public static void main(String[] args) {        
        System.out.println(getFib(8));
    }

    public static int getFib(int negativeFibNumb) {
        int fib1 = 1;
        int fib2 = 1;
        int fib = fib1 - fib2;

        for(int i = 0; i < negativeFibNumb; i++) {
            fib1 = fib2;
            fib2 = fib;
            fib = fib1 - fib2;
        }
        return fib;
    }
}
