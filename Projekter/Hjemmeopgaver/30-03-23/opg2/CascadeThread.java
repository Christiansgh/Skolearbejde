package opg2;

public class CascadeThread extends Thread {
    private CascadeThread next;
    private int id;
    private boolean isStanding;
    private boolean first;

    public CascadeThread(int id, CascadeThread next) {
        this.id = id;
        this.next = next;
        isStanding = true;
    }

    private void printIDs() {
        System.out.print("[");
        getAllIDs();
        System.out.println("");
    }

    private void getAllIDs() {
        System.out.print(id);
        if (next != null) {
            System.out.print(", ");
            next.getAllIDs();
        } else {
            System.out.print("]");
        }
    }

    @Override
    public void run() { 
        if (next != null) {
            next.start();
        }

        while (isStanding) {
            Sleeper.sleepRandom(2);
        }
    }

    public void pushOver() {
        isStanding = false;
        printIDs();
        if (next != null) {
            Sleeper.sleep(0.25);
            next.pushOver();
        }
    }
}
