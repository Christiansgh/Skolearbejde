package opg1;

public class Main {
    public static void main(String[] args) {
        //2 objects referencing eachother
        TennisPlayer tennisPlayerOne = new TennisPlayer("Mikkel", true);
        TennisPlayer tennisPlayerTwo = new TennisPlayer("Christian", false);
        tennisPlayerOne.setOpponent(tennisPlayerTwo);
        tennisPlayerTwo.setOpponent(tennisPlayerOne);
        Thread threadOne = new Thread(tennisPlayerOne);
        Thread threadTwo = new Thread(tennisPlayerTwo);
        threadOne.start();
        threadTwo.start();
    }
}