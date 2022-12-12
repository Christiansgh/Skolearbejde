package Opg38;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> primtal = new ArrayList<>();
        fillArray(primtal, 1001, 0);
        primtal.set(0, 1);
        primtal.set(1, 1);
        checkNumbers(primtal);
    }

    public static void fillArray(ArrayList<Integer> list, int length, int with) {
        for (int i = 0; i < length; i++) {
            list.add(with);
        }
    }

    public static void checkNumbers(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) {
                continue;
            }

            for (int j = i * 2; j < list.size(); j += i) {
                list.set(j, 1);
            }
            
            System.out.print(i + " ");
        }
    }
}
