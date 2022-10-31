package Opg34;
public class Main {
    public static void main(String[] args) {
        int T1[] = { 44, 71, 93, 24, 35, 21, 64 };
        iterate(T1, 3);

        
        // (44,71)(71,93)(93,24)(24,35)(35,21)(21,64)
    }   //    01    12     23     34     45     56  
    public static void iterate(int[] T1, int iterations) {
        for(int i = 0; i <= iterations; i++) {
            for(int j = 1; j < T1.length; j++) {
                int jPrev = T1[j-1];
                int jCurr = T1[j];
                double compared = jPrev / jCurr;
                if(compared < 0) {
                    jPrev++;
                    jCurr--;
                }
                else if(compared > 1) {
                    jPrev--;
                    jCurr++;
                }
                System.out.print("("+jPrev+","+jCurr+")");
            }
        }
    }
}