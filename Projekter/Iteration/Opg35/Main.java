package Opg35;
/*
 * som i opg 34, kommer parene til at være de samme, hvis der køres nok loops,
 * 46, efter 13 loops, i det her tilfælde.
 */
public class Main {
    public static void main(String[] args) {
        //x = num of iterations
        int x = 13;
        int T1[] = { 44, 71, 93, 24, 35, 21, 64 };
        
        //før
        for (int i = 1; i < T1.length; i++) {
            System.out.print("(" + T1[i-1] + " " + T1[i] + ")");
        }
        System.out.println("");

        //under
        for(int z = 0; z < x; z++) {   
            for (int i = 1; i < T1.length; i++) {
                if (!(T1[i-1] == T1[i])) {
                    T1[i] = (T1[i] + T1[i-1]) / 2;
                    T1[i-1] = (T1[i] + T1[i-1]) / 2;
                }
            }

            //efter
            System.out.println("");
            for (int i = 1; i < T1.length; i++) {
                System.out.print("(" + T1[i-1] + " " + T1[i] + ")");
            }
        }

        
    }
}
