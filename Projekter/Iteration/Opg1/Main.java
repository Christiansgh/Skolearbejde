package Opg1;

public class Main {
    public static void main(String[] args) {
        int x = -10;
        int y = 10;
        int sum = 0;

        //while & ned -> op
        while(x <= y) {
            sum += x;
            x++;
        }
        System.out.println(sum);

        //while & op -> ned
        while(y >= x) {
            sum += y;
            y--;
        }
        System.out.println(sum);

        //for & ned -> op
        for(int z = x; z <= y; z++) {
            sum += z;
        }
        System.out.println(sum);

        //for & op -> ned
        for(int z = y; z >= x; z++) {
            sum += z;
        }
        System.out.println(sum);

        //4 loops
        //-10 --> 10
        //tælle op og ned
        //while og for løkke.
    }
}