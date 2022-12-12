package Opg31;

public class Main {
    public static void main(String[] args) {
        int T5[] = { 53, 34, 31, 88, 85, 90, 11 };
        int lowest = T5[0];
        for (int i : T5) {
            if (lowest > i) {
                lowest = i;
            }
        }
        System.out.println(lowest);
    }
}
