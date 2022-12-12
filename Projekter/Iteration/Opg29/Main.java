package Opg29;

public class Main {
    public static void main(String[] args) {
        int Tabel[] = { 5, 8, 1, 9, 3, 6, 2, 3, 9, 4, 7, 5, 7, 2, 0, 1, 0, 2 };
        int[] forkomster = new int[10];
        for (int i : Tabel) {
            forkomster[i]++;
        }

        for (int i : forkomster) {
            System.out.println(i);
        }
    }
}
