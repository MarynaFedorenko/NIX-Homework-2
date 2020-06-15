package nix.repository;

import nix.data.StudentClass;

import java.util.List;

public interface StudentClassRepository extends AbstractRepository<StudentClass> {
    StudentClass findById(String id);
    StudentClass findByStudentId(String studentId);
    StudentClass findByClassId(String classId);

}
