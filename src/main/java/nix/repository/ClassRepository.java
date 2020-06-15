package nix.repository;
import nix.data.Class;


public interface ClassRepository extends AbstractRepository<Class> {

    Class findByClassName(String ClassName);
    Class findByClassId(String classId);
}