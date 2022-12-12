package Opg2;

public class Main {
    public static void main(String[] args) {
        //udskriver alle ulige tal [10:21]
        int lowerBound = 10;
        int upperBound = 21;
        while(lowerBound <= upperBound) {
            if(!(lowerBound % 2 == 0)) {
                System.out.println(lowerBound);
            }
            lowerBound++;
        }
    }
}
