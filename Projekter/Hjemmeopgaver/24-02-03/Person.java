public class Person {
    private String name;
    private String comment;
    private Ship subscribedShip;

    public Person(String name, String comment, Ship subscribedShip) {
        this.name = name;
        this.comment = comment;
        this.subscribedShip = subscribedShip;
        subscribedShip.addSubscriber(this);
    }

    public void speak() {
        System.out.printf("%-8s: %s\n", name, comment);
    }

    public void update() {
        if(subscribedShip.getState() == Ship.State.SINKING) {
            speak();
        }
    }
}