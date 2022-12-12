package Opg40;

public class Main {
    public static void main(String[] args) {
        int[][] lille = new int[10][10];
        for(int i = 0; i < lille.length; i++) {
            for(int j = 0; j < lille.length; j++) {
                lille[i][j] = (i+1) * (j+1);
            }
        }

        for(int i = 0; i < lille.length; i++) {
            for(int j = 0; j < lille.length; j++) {
                System.out.print(lille[i][j] + " ");
            }
            System.out.println("");
        }
    }
}