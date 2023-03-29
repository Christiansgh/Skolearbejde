package opg3;

public class Main {
    public static void main(String[] args) {
        PrioThread max = new PrioThread(Thread.MAX_PRIORITY);
        PrioThread norm = new PrioThread(Thread.NORM_PRIORITY);
        PrioThread min = new PrioThread(Thread.MIN_PRIORITY);   

        min.run();
        norm.run();
        max.run();
    }
}
