
public class Student { // DBO: DataBærende Object
  private int id;
  private String lastName, firstName;
  private int semesterNo;
  
  public Student(int id, String lastName, String firstName, int semesterNo) {
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
    this.semesterNo = semesterNo;
  }
  
  @Override
  public String toString() {
    return String.format("[Student: ID = %d, lastName = %s, firstName = %s, semesterNo = %d]", id, lastName, firstName, semesterNo);
  }
}
