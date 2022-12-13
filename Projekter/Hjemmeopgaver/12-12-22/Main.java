public class Main {
    public static void main(String[] args) {
        int[] t = {3, 1, 2, 5, 5, 1, 6, 1, 2, 5, 4};
        int[] target = {1, 2, 5};
        int[] replace = {3, 1, 2};
        //checkArray(t, target);
        replaceArray(t, target, replace);
    }

    public static void checkArray(int [] array, int [] target) {
        for (int i = 0; i < array.length - target.length; i++) {
            if (array[i] == target[0]) {
                boolean found = false;
                for (int j = 1; j < target.length; j++) {
                    if (array[i+j] != target[j]) {
                        break;
                    }
                    found = true;
                }
                if (found) {
                    System.out.println("target found @ [" + i + "]");
                }
            }   
        }
    }

    public static void replaceArray(int [] array, int [] target, int [] replace) {
        for (int i = 0; i < array.length - target.length; i++) {
            if (array[i] == target[0]) {
                boolean found = false;
                for (int j = 1; j < target.length; j++) {
                    if (array[i+j] != target[j]) {
                        break;
                    }
                    found = true;
                }
                if (found) {
                    for (int k = 0; k < replace.length; k++) {
                        array[i + k] = replace[k];
                        System.out.print(array[i + k]);
                    }
                    i += replace.length;
                }
            }
        }   
        

        for (int i : array) {
            System.out.print("| " + i + " |");
        }
    }

    public static void replaceWith(int []array, int [] replace) {
        for (int i = 0; i < replace.length; i++) {
            array[i] = replace[i];
        }
    }
}
    
