package Opg1;

public class Main {
    public static void main(String[] args) {
        Punkt p1 = new Punkt(1, 0);
        System.out.println("p1 " + p1);
        Punkt p2 = new Punkt(p1);
        System.out.println("p2 " + p2);
        p1.move(-1, 1);
        System.out.println("p1 " + p1);
        p1.move(0, 0);
        System.out.println("p1 " + p1);
        Cirkel cirkel = new Cirkel(0, 0, 10);
        System.out.println("cirkel omkreds " + cirkel.omkreds());
        System.out.println("cirkel areal " + cirkel.areal());
        Rektangel rektangel = new Rektangel(0, 0, 5, 10);
        System.out.println("rektangel omkreds " + rektangel.omkreds());
        System.out.println("rektangel areal " + rektangel.areal());
    }
}