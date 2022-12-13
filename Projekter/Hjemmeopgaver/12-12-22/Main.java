public class Main {
    public static void main(String[] args) {
        int[] t = {3, 1, 2, 5, 5, 1, 6, 1, 2, 5, 4};
        int[] target = {1, 2, 5};
        int[] replace = {3, 1, 2};
        checkArray(t, target);
        replaceArray(t, target, replace);
    }

    public static boolean checkTarget(int[] array, int[] target, int i) {
        for (int j = 1; j < target.length; j++) {
            if (array[i+j] != target[j]) {
                return false;
            }
        }
        return true;
    }

    public static void checkArray(int [] array, int [] target) {
        for (int i = 0; i < array.length - target.length; i++) {
            if (array[i] == target[0]) {
                if (checkTarget(array, target, i)) {
                    System.out.printf("target found @ [%d].%n", i);
                }
            }   
        }
    }

    public static void replaceTarget(int[]array, int[] replace, int i) {
        for (int x = 0; x < replace.length; x++) {
            array[x + i] = replace[x];
        }
    }

    public static void replaceArray(int[] array, int[] target, int[] replace) {
        for (int i = 0; i < array.length - target.length; i++) {
            if (array[i] == target[0]) {
                if (checkTarget(array, target, i)) {
                    replaceTarget(array, replace, i);
                    i += replace.length;
                }
            }
        }   
        
        for (int i : array) {
            System.out.printf("| %d |", i);
        }
    }
}
    
