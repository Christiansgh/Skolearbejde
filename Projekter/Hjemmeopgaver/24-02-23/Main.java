/*
 * Ship -> publisher
 * - Needs a state -> enum
 * - Needs method to change the state to "sinking"
 * - Needs a getState()
 * - The ship is initially floating -> state in constructor
 * 
 * Person -> subscriber
 * - Needs a method to comment when the ship is sinking
 * - Has a name -> attribute
 * - The constructor takes a ship as a parameter, which the person subscribes to
 * - Update() -> calls the comment()
 */
public class Main {
    public static void main(String[] args) {
        Ship titanic = new Ship();
        Person flemming = new Person("Flemming", "**Insert dad joke**", titanic);
        Person jan = new Person("Jan", "Nihao Xiaolei", titanic);
        Person xiaolei = new Person("Xiaolei", "Du skal blive mmd", titanic);

        titanic.hitIceberg();
    }
}