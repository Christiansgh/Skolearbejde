package Opg42;

public class Main {
    public static void main(String[] args) {
        boolean success = true;
        int[][] matrix = {{1,0,0,0},{0,2,0,0},{0,0,3,0},{0,0,0,4}};
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                if(i == j) {
                    continue;
                }
                else if(matrix[i][j] != 0) {
                    System.out.println("Not a diagonal matrix!");
                    System.out.println("Exception in line " + i);
                    success = false;
                    break;
                }
            }
            if(!success) {
                break;
            }
            System.out.println("Row " + (i + 1) + " checked");
        }
        if(success) {
            System.out.println("The array IS a diagonal matrix!");
        }
    }
}
