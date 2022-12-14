public class Teacher {
    private int id;
    private String initials;

    public Teacher(int id, String initials) {
        this.id = id;
        this.initials = initials;
    }

    @Override
    public String toString() {
        return String.format("[Teacher: ID = %d, initials = %s]", id, initials);
    }
}
