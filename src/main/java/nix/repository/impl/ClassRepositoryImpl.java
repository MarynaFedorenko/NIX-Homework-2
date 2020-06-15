package nix.repository.impl;

import nix.repository.ClassRepository;
import nix.data.Class;

import java.util.ArrayList;
import java.util.List;


public class ClassRepositoryImpl implements ClassRepository {

    private final List<Class> classList = new ArrayList<>();

    public Class findByClassName(String className) {
        for(int i=0; i<classList.size();i++){
            if(classList.get(i).getClassName().equals(className)){
                return classList.get(i);
            }
        }
        return null;
    }


    @Override
    public Class findByClassId(String classId) {
        for(int i=0; i<classList.size();i++){
            if(classList.get(i).getClassId().equals(classId)){
                return classList.get(i);
            }
        }
        return null;

    }

    public void save(Class classes) {
        classList.add(classes);
    }

    public Class findById(String id) {
        for(int i=0; i<classList.size();i++){
            if(classList.get(i).getClassId().equals(id)){
                return classList.get(i);
            }
        }
        return null;
    }

    public List<Class> findAll() {
        return classList;
    }

    public void update(Class classes) {
        classList.forEach(currentClass -> {
            if (classes.getClassId().equals(currentClass.getClassId())) {
                currentClass.setClassId(classes.getClassId());
                currentClass.setClassName(classes.getClassName());
            }
        });
    }

    public void remove(String id) {
        classList.removeIf(Class -> Class.getClassId().equals(id));
    }
}