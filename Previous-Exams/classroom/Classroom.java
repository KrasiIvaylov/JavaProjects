package classroom;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    public int capacity;
    public List<Student> students;

    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : this.students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public int getStudentCount() {
        return this.students.size();
    }


    public String registerStudent(Student student) {
        if (this.students.size() < this.capacity) {
            if (!students.contains(student)) {
                students.add(student);
                return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            } else {
                return String.format("Student is already in the classroom");
            }
        } else {
            return String.format("No seats in the classroom");
        }
    }

    public String dismissStudent(Student student) {
        if (!this.students.contains(student)) {
            return String.format("Student not found");
        } else {
            this.students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }
    }

    public String getSubjectInfo(String subject) {
        for (Student student : students) {
            if (!this.students.contains(student.getBestSubject().equals(subject))) {
                System.out.println("Subject: " + subject);
                System.out.println(String.format("%s %s", student.getFirstName(), student.getLastName()));
            } else {
                return String.format("No students enrolled for the subject");
            }
        }
        return null;
    }

    public void getStudents() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getFirstName() + " " + students.get(i).getLastName());
        }
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        System.out.println(String.format("%d%n", this.students.size()));
        for (Student student : this.students) {
            sb.append(String.format("==%s", student.toString())).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
