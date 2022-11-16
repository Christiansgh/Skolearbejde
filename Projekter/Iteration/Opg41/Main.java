package Opg41;

public class Main {
    public static void main(String[] args) {
        int[][] ticTacToe = {{1, 2, 1},{2, 1, 0},{0, 0, 2}};
        for(int i = 0; i < ticTacToe.length; i++) {
            for(int j = 0; j < ticTacToe.length; j++) {
                switch(ticTacToe[i][j]) {
                case 1:
                    printFormat("X");
                    break;
                    
                case 2:
                    printFormat("O");
                    break;

                default:
                    printFormat(" ");
                }
            }
            System.out.println("");   
        }
    }

    public static void printFormat(String text) {
        System.out.print("[" + text + "]");
    }
}
