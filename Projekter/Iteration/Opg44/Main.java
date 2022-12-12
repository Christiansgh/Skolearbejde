package Opg44;

public class Main {
    public static void main(String[] args) {
        int[][] tipskupon = {
            {0, 2, 1, 2, 0, 0, 1, 2, 1, 2, 0, 2, 0},
            {1, 1, 2, 1, 2, 2, 1, 0, 1, 0, 0, 2, 2},
            {2, 1, 0, 0, 1, 0, 1, 1, 1, 2, 1, 4, 0}
        };

        for(int x = 0; x < tipskupon[1].length; x++) {
            System.out.print(format(x + 1) + "|");
            for(int y = 0; y < 3; y++) {
                if (tipskupon[y][x] == 0) {
                    System.out.print(" X |");
                    continue;
                }

                else if (tipskupon[y][x] == 1) {
                    System.out.print("1  |");
                    continue;
                }

                else if (tipskupon[y][x] == 2) {
                    System.out.print("  2|");
                    continue;
                }

                else {
                    System.out.print("???|");
                    continue;
                }
            }
            System.out.println("");
        }
    }

    public static String format (int x) {
        if (x < 10) {
            return " " + x;
        }
        else 
            return "" + x;
    }
}
