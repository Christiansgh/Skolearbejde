package Opg34;
/*
 * Ved mange loops, kommer man tæt på at sættene bliver lige store.
 */

public class Main {
    public static void main(String[] args) {
        //x = num of iterations
        int x = 200;
        int T1[] = { 44, 71, 93, 24, 35, 21, 64 };
        
        for (int i = 1; i < T1.length; i++) {
            System.out.print("(" + T1[i-1] + " " + T1[i] + ")");
        }
        System.out.println("");

        for(int z = 0; z < x; z++) {   
            for (int i = 1; i < T1.length; i++) {
                System.out.print("(" + T1[i-1] + " " + T1[i] + ")");
                if (!(T1[i-1] == T1[i])) {
                    if (T1[i] > T1[i-1]) {
                        T1[i] -= 1;
                        T1[i-1] += 1;
                    }
                    else {
                        T1[i] += 1;
                        T1[i-1] -= 1;
                    }
                }
            }
        }

        System.out.println("");
        for (int i = 1; i < T1.length; i++) {
            System.out.print("(" + T1[i-1] + " " + T1[i] + ")");
        }
    }    
}
