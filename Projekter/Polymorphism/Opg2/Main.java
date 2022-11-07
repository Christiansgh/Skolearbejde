package Opg2;

public class Main {
    public static void main(String[] args) {
        Lejlighed bolig1 = new Lejlighed(70, 3000);
        Villa bolig2 = new Villa(110, 800, 650000, true);
        Villa bolig3 =  new Villa(140, 400, 850000, false);
        Lejlighed bolig4 = new Lejlighed(bolig1);
        Villa bolig5 = new Villa(bolig3);
        System.out.println(bolig1);
        System.out.println(bolig2);
        System.out.println(bolig3);
        System.out.println(bolig4);
        System.out.println(bolig5);
        /*
         * 1. lejlighed 70m2 3k / mdr.
         * 2. villa 110m2 650k 800m2 grund på landet.
         * 3. villa 140m2 850k 400m2 grund i byen.
         * 4. 1. -||-
         * 5. 3. -||-
         * //toString, oplysningerne, årligHusleje.
         */
    }
}