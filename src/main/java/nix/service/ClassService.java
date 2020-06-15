package nix.service;
import nix.data.Class;

public interface ClassService extends AbstractService<Class> {

    Class findByClassId(String classId);
    Class findByClassName(String className);

}
