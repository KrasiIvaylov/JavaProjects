package classroom;

public class Student {
   public String firstName;
   public String lastName;
   public String bestSubject;

    public Student(String firstName, String lastName, String bestSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestSubject = bestSubject;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBestSubject() {
        return this.bestSubject;
    }

    public void setBestSubject(String bestSubject) {
        this.bestSubject = bestSubject;
    }

    @Override
    public String toString() {
       return String.format("First name: %s, Last Name = %s, Best Subject = %s",
               this.firstName, this.lastName, this.bestSubject);
    }

}
