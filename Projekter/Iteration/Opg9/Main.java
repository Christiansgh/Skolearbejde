package Opg9;

public class Main {
    public static void main(String[] args) {        
        System.out.println(getFib(6));
    }

    public static int getFib(int fibNumb) {
        if(fibNumb == 1 || fibNumb == 2) {
            return 1;
        }
        int fib1 = 1;
        int fib2 = 1;
        int fib = fib1 + fib2;

        for(int i = 0; i < fibNumb-3; i++) {
            fib1 = fib2;
            fib2 = fib;
            fib = fib1 + fib2;
        }
        return fib;
    }
}
