package Opg1;

public class Main {
    public static void main(String[] args) {
        skrivAdresse("Ikast Handelsskole", "Bøgildvej 12", "7430 Ikast");
    }

    public static void skrivAdresse(String navn, String adresse, String postnummer) {
        System.out.println(navn);
        System.out.println(adresse);
        System.out.println(postnummer);
    }
}