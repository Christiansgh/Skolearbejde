
public class Main {
    public static void main(String[] args) {
        int[] t = {3, 5, 4, 1, 1, 7, 4, 9, 9, 2, 5};
        findTopBot(t);
    }

    public static void findTopBot(int[] x) {
        for (int i = 1; i < x.length-1; i++) {
            if (x[i-1] > x[i] && x[i] < x[i+1]) {
                System.out.println("Bot: t[" + i + "] = " + x[i]);
            }

            else if (x[i-1] < x[i] && x[i] > x[i+1]) {
                System.out.println("Top: t[" + i + "] = " + x[i]);
            }
        }
    }
}