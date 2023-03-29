package opg2;

public class Main {
    public static void main(String[] args) {
        int numOfDominos = 10;
        CascadeThread base = new CascadeThread(-1, null); 
        for (int i = 0; i < numOfDominos; i++) {
            CascadeThread cascadeThread = new CascadeThread(i, base);
            base = cascadeThread;
        }

        base.start();
        base.pushOver();
    }
}
