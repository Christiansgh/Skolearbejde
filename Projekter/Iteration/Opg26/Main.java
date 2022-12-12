package Opg26;

public class Main {
    public static void main(String[] args) {
        int Tabel[] = { 5, 8, 1, 9, 3, 6, 2, 3, 9, 4, 7, 5, 7, 2, 0, 1, 0, 2 };
        int target = 10;
        int c = 0;
        for (int i = 0; i < Tabel.length; i++) {
            if (Tabel[i] == target) {
                c++;
                System.out.println(i);
            }
        }
        System.out.println(c);
    }
}
