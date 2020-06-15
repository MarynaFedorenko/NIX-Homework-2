package nix.service.impl;

import nix.data.Student;
import nix.repository.impl.StudentRepositoryImpl;
import nix.service.StudentService;
import nix.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;


public class StudentServiceImpl implements StudentService {

    private final StudentRepository StudentRepository = new StudentRepositoryImpl();
//    private final List<Student> StudentList = new ArrayList<>();


    public Student findByStudentId(String studentId) {
        return StudentRepository.findByStudentId(studentId);
    }
    public Student findByFirstName(String firstName) { return StudentRepository.findByFirstName(firstName);    }

    public Student findByLastName(String lastName) {
        return StudentRepository.findByLastName(lastName);
    }


    public void saveOrUpdate(Student student) {
//        StudentList.forEach(currentStudent -> {
//            int count = 0;
//            if (student.getStudentId().equals(currentStudent.getStudentId())) {
//                count++;
//            }
//            if(count>0)StudentRepository.update(student);
//            else StudentRepository.save(student);
//        });
        StudentRepository.save(student);
    }

    public Student findById(String id) {
        return StudentRepository.findById(id);
    }

    public List<Student> findAll() {
        return StudentRepository.findAll();
    }

    @Override
    public void remove(String id) {
        StudentRepository.remove(id);
    }

}