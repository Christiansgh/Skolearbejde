package Opg43;

public class Main {
    public static void main(String[] args) {
        boolean[][] figur = {
            {false, true, true, true, false, false, false, false},
            {false, true, true, false, false, false, false, false},
            {false, true, false, false, true, false, false, false},
            {false, false, false, true, true, true, false, false},
            {false, false, false, false, true, true, false, false},
            {false, true, true, false, false, false, true, false},
            {false, false, true, false, false, true, false, false},
            {false, false, true, false, false, false, false, false}
        };
        
        for(int i = 0; i < figur.length; i++) {
            for(int j = 0; j < figur.length; j++) {
                //check kanterne
                if (i == 0 || i == figur.length-1)
                    continue;
                else if (j == 0 || j == figur.length-1) {
                    continue;
                }
                //check om feltet er markeret
                if (figur[i][j] != true) {
                    continue;
                }
                //check omkringliggende felter
                if (figur[i-1][j] != true)
                    continue;
                if (figur[i][j-1] != true)
                    continue;
                if (figur[i][j+1] != true)
                    continue;
                if (figur[i+1][j] != true)
                    continue;
                
                System.out.println("Index [" + i + ", " + j + "] er et krydsfelt");
            }
        }
    }
}
