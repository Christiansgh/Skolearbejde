public class Main {
    public static void main(String[] args) {
        int T1[] = { 44, 71, 93, 24, 35, 21, 64 };
        for(int i = 1; i < T1.length; i++) {
            int iPrev = T1[i-1];
            int iCurr = T1[i];
            double compared = iPrev / iCurr;
            if(compared < 0) {
                iPrev++;
                iCurr--;
            }
            else if(compared > 1) {
                iPrev--;
                iCurr++;
            }
            System.out.print("("+iPrev+","+iCurr+")");
        }
         

        
        // (44,71)(71,93)(93,24)(24,35)(35,21)(21,64)
    }   //    01    12     23     34     45     56  
}