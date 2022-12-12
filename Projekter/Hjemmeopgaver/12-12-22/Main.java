public class Main {
    public static void main(String[] args) {
        int[] t = {3, 1, 2, 5, 5, 1, 6, 1, 2, 5, 4};
        int[] target = {1, 2, 5};
        checkArray(t, target);
    }

    public static void checkArray(int [] array, int [] target) {
        for (int i = 0; i < array.length - target.length; i++) {
            if (array[i] == target[0]) {
                int skipIndexes = 0;
                boolean found = false;
                for (int j = 1; j < target.length; j++) {
                    skipIndexes++;
                    if (array[i+j] != target[j]) {
                        skipIndexes--;
                        i += skipIndexes;
                        break;
                    }
                    found = true;
                }
                if (found) {
                    System.out.println("target found @ [" + i + "]");
                }
                i += skipIndexes;
            }   
        }
    }
}
    
