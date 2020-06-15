package nix.repository.impl;

import nix.data.Student;
import nix.data.StudentClass;
import nix.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    private final List<Student> StudentList = new ArrayList<>();

    public Student findByStudentId(final String studentId) {
        for(int i=0; i<StudentList.size();i++){
            if(StudentList.get(i).getStudentId().equals(studentId)){
                return StudentList.get(i);
            }
        }
        return null;
    }
    public Student findByFirstName(final String firstName) {
        for(int i=0; i<StudentList.size();i++){
            System.out.println();
            if(StudentList.get(i).getFirstName().equals(firstName)){
                return StudentList.get(i);
            }
        }

        return null;

    }
    public Student findByLastName(final String lastName) {
        for(int i=0; i<StudentList.size();i++){
            if(StudentList.get(i).getLastName().equals(lastName)){
                return StudentList.get(i);
            }
        }
        return null;
    }



    public void save(Student student) {
        StudentList.add(student);
    }

    @Override
    public Student findById(String id) {
        for(int i=0; i<StudentList.size();i++){
            if(StudentList.get(i).getStudentId().equals(id)){
                return StudentList.get(i);
            }
        }
        return null;
    }



    public List<Student> findAll() {
        return StudentList;
    }

    public void update(Student student) {
        StudentList.forEach(currentStudent -> {
            if (student.getStudentId().equals(currentStudent.getStudentId())) {
                currentStudent.setStudentId(student.getStudentId());
                currentStudent.setFirstName(student.getFirstName());
                currentStudent.setLastName(student.getLastName());
            }
            else System.out.println("do not equals");
        });
    }

    public void remove(String id) {
        StudentList.removeIf(Student -> Student.getStudentId().equals(id));
    }
}
