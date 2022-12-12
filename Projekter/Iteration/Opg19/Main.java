package Opg19;

public class Main {
    public static void main(String[] args) {
        int PosNeg[]= { 4, 9, -2, -6, 2, 6, -9, 4, 9, -1, 1, 0, -3, -3, 2, 7 };
        int sum = 0;
        for(int i = 0; i < PosNeg.length; i++) {
            sum += PosNeg[i];
        }
        System.out.println(sum);
    }
}
