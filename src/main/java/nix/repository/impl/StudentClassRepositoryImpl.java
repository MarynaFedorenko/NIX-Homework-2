package nix.repository.impl;

import nix.data.Class;
import nix.data.StudentClass;
import nix.repository.StudentClassRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentClassRepositoryImpl implements StudentClassRepository {

    private final List<StudentClass> StudentClassList = new ArrayList<>();

    @Override
    public StudentClass findById(String id) {
        for(int i=0; i<StudentClassList.size();i++){
            if(StudentClassList.get(i).getId().equals(id)){
                return StudentClassList.get(i);
            }
        }
        return null;
    }

    @Override
    public StudentClass findByStudentId(String studentId) {
        for(int i=0; i<StudentClassList.size();i++){
            if(StudentClassList.get(i).getStudentId().equals(studentId)){
                return StudentClassList.get(i);
            }
        }
        return null;
    }
    @Override
    public StudentClass findByClassId(String classId) {
        for(int i=0; i<StudentClassList.size();i++){
            if(StudentClassList.get(i).getClassId().equals(classId)){
                return StudentClassList.get(i);
            }
        }
        return null;

    }


    @Override
    public void save(StudentClass studentClass) {
        StudentClassList.add(studentClass);
    }



    @Override
    public List<StudentClass> findAll() {
        return StudentClassList;
    }

    @Override
    public void update(StudentClass studentClass) {
        StudentClassList.forEach(currentStudent -> {
            if (studentClass.getId().equals(currentStudent.getId())) {
                currentStudent.setClassId(studentClass.getClassId());
                currentStudent.setStudentId(studentClass.getStudentId());
            }
        });
    }

    @Override
    public void remove(String id) {
        StudentClassList.removeIf(StudentClass -> StudentClass.getId().equals(id));
    }
}
