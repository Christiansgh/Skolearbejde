package opg1;
/*
 * 2 objects waiting for each other.
 *  - => state.
 *  - hit the ball / pass it to eachother.
 * 
 * TennisPlayer objects.
 *  - 2 instances
 * 
 * 2 methods:
 *  - recieveBall
 *   - called when the opponent hits the ball.
 *   - 80% chance to return the ball to the opponent.
 */
public class TennisPlayer implements Runnable {
    private String name;
    private TennisPlayer opponent;
    private boolean hasBall;
    private boolean hasActiveGame = true;

    public void setOpponent(TennisPlayer opponent) {
        this.opponent = opponent;
    }

    public TennisPlayer(String name, boolean hasBall) {
        this.name = name;
        this.hasBall = hasBall;
    }

    private void receiveBall() {
        opponent.hasBall = false;
        hasBall = true;
    }

    private boolean sendBall() {
        return Math.random() < 0.8;
    }

    private void endGame() {
        hasActiveGame = false;
        opponent.hasActiveGame = false;
    }

    @Override
    public void run() {
        while (hasActiveGame) { 
            if (hasBall) {
                if (sendBall()) { //if ball hit, pass to opponent.
                    System.out.printf("%s hit the ball, passing it to %s. \n", name, opponent.name);
                    opponent.receiveBall();
                } else { //else miss and lose the game.
                    System.out.printf("%s missed the ball. Game won by %s. \n", name, opponent.name);
                    endGame();
                }
            } else {
                Sleeper.sleepRandom(2);
            }
        }
    }
}
