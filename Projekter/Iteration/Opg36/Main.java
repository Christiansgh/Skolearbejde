package Opg36;
/*
 * ved flere gennemløb sorteres arrayet fra mindst --> størst.
 */
public class Main {
    public static void main(String[] args) {

        //x = num of iterations
        int x = 5;

        int T1[] = { 44, 71, 93, 24, 35, 21, 64 };
        
        //før
        for (int i = 1; i < T1.length; i++) {
            System.out.print("(" + T1[i-1] + " " + T1[i] + ")");
        }
        System.out.println("");

        //under
        for(int z = 0; z < x; z++) {   
            for (int i = 1; i < T1.length; i++) {
                if ((T1[i-1] > T1[i])) {
                    int temp = 0;
                    temp = T1[i-1];
                    //temp er størst
                    T1[i-1] = T1[i];
                    T1[i] = temp;
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