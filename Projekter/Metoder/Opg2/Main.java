package Opg2;

public class Main {
    public static void main(String[] args) {
        meddelFejl(5, 14);
    }

    public static void meddelFejl(int nummer, int linie) {
        System.out.println("Der er en fejl");
        System.out.println("Fejl nr. " + nummer);
        System.out.println("Fejl nr. " + nummer + " i linie " + linie);
    }
}
