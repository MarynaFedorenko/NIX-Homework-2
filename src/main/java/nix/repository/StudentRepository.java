package nix.repository;

import nix.data.Student;
import nix.data.StudentClass;

import java.util.List;


public interface StudentRepository extends AbstractRepository<Student> {

    Student findByStudentId (String studentId);
    Student findByFirstName (String firstName);
    Student findByLastName(String lastName);
}