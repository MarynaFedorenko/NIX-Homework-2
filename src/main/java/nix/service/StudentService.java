package nix.service;

import nix.data.Student;

import java.util.List;

public interface StudentService extends AbstractService<Student> {

    Student findByStudentId(String studentId);
    Student findByFirstName(String firstName);
    Student findByLastName(String lastName);

}