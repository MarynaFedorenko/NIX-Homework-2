package nix.service.impl;

import nix.data.Class;
import nix.data.Student;
import nix.data.StudentClass;
import nix.repository.ClassRepository;
import nix.repository.StudentClassRepository;
import nix.repository.impl.ClassRepositoryImpl;
import nix.repository.impl.StudentClassRepositoryImpl;
import nix.service.StudentClassService;
import nix.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentClassServiceImpl implements StudentClassService {

    private final StudentClassRepository StudentClassRepository = new StudentClassRepositoryImpl();
//    private final List<StudentClass> StudentClassList = new ArrayList<>();


    @Override
    public StudentClass findById(String id) {
        return StudentClassRepository.findById(id);
    }

    @Override
    public StudentClass findByStudentId(String studentId) {
        return StudentClassRepository.findByStudentId(studentId);
    }

    @Override
    public StudentClass findByClassId(String classId) {
        return StudentClassRepository.findByClassId(classId);
    }

    @Override
    public void saveOrUpdate(StudentClass studentClass) {
//        StudentClassList.forEach(currentClass -> {
//            int count = 0;
//            if (studentClass.getClassId().equals(currentClass.getClassId())) {
//                count++;
//            }
//            if(count>0)StudentClassRepository.update(studentClass);
//            else StudentClassRepository.save(studentClass);
//        });
        StudentClassRepository.save(studentClass);
    }


    @Override
    public List<StudentClass> findAll() {
        return StudentClassRepository.findAll();
    }



    @Override
    public void remove(String id) {
            StudentClassRepository.remove(id);
    }


    private String generateId(String token) {
        StudentClass b = StudentClassRepository.findById(token);
        if (b == null) {
            return token;
        } else {
            return generateId(UUID.randomUUID().toString());
        }
    }
}
