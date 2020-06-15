package nix.data;

import java.util.List;

public class Student extends AbstractData<Student> {
    private String studentId;
    private String firstName;
    private String lastName;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    @Override
    public String toString() {
        return "Student{" + "studentId = "+studentId+
                ", firstName= " + firstName + ", lastName = " + lastName +
                '}';
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}