package opg3;

public class PrioThread implements Runnable {
    private int prio;

    public PrioThread(int prio) {
        this.prio = prio;
    }

    @Override
    public void run() {
        Sleeper.sleep(2);
        System.out.println(prio);
    }
}
