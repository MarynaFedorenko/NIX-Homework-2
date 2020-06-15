package nix.service;

import nix.data.Student;
import nix.data.StudentClass;

import java.util.List;

public interface StudentClassService extends AbstractService<StudentClass> {

    StudentClass findById(String id);
    StudentClass findByStudentId(String studentId);
    StudentClass findByClassId(String classId);

    void saveOrUpdate(StudentClass studentClass);

    void remove(String id);
}
