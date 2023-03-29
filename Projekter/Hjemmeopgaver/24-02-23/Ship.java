import java.util.ArrayList;

public class Ship {
    private ArrayList<Person> subscriberPersons; 
    private State state;
    
    enum State {
        FLOATING,
        SINKING
    }
    
    public Ship() {
        subscriberPersons = new ArrayList<Person>();
        state = State.FLOATING;
    }

    public void addSubscriber(Person person) {
        subscriberPersons.add(person);
    }

    public void removeSubscriber(Person person) {
        subscriberPersons.remove(person);
    }

    public void hitIceberg() {
        state = State.SINKING;
        notifySubscribers();
    }

    public State getState() {
        return state;
    }

    private void notifySubscribers() {
        System.out.println("");
        for (Person person : subscriberPersons) {
            person.update();
        }
        System.out.println("");
    }
}
