package Opg30;

public class Main {
    public static void main(String[] args) {
        int PosNeg[]= { 4, 9, -2, -6, 2, 6, -9, 4, 9, -1, 1, 0, -3, -3, 2, 7 };
        int neg = 0;
        int i = 0;

        do {
            if (PosNeg[i] < 0) {
                System.out.println(PosNeg[i]);
                break;
            }
            i++;
        }
        while (neg >= 0);

        for (int j = 0; j < PosNeg.length; j++) {
            if (PosNeg[j] < 0) {
                System.out.println(PosNeg[j]);
                break;
            }
        }
        
        int k = 0;
        while (k < PosNeg.length) {
            if (PosNeg[k] < 0) 
                System.out.println(PosNeg[k]);
                break;
        }
    }
}

