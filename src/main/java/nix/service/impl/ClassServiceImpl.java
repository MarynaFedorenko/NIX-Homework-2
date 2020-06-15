package nix.service.impl;

import nix.data.Class;
import nix.data.Student;
import nix.repository.impl.ClassRepositoryImpl;
import nix.service.ClassService;
import nix.repository.ClassRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ClassServiceImpl implements ClassService {

    private final ClassRepository ClassRepository = new ClassRepositoryImpl();
//    private final List<Class> ClassList = new ArrayList<>();


    public Class findByClassId(String classId) {
        return ClassRepository.findByClassId(classId);
    }

    public Class findByClassName(String className) {
        return ClassRepository.findByClassName(className);
    }


    public void saveOrUpdate(Class classes) {
//        ClassList.forEach(currentClass -> {
//            int count = 0;
//            if (classes.getClassId().equals(currentClass.getClassId())) {
//                count++;
//            }
//            if(count>0){
//                System.out.println("Update classes"); ClassRepository.update(classes);}
//            else {System.out.println("Save classes"); ClassRepository.save(classes);}
//        });
        ClassRepository.save(classes);
    }

    public Class findById(String id) {
        return ClassRepository.findById(id);
    }

    public List<Class> findAll() {
        return ClassRepository.findAll();
    }

    @Override
    public void remove(String id) {
        ClassRepository.remove(id);
    }


    private String generateId(String token) {
        Class b = ClassRepository.findByClassId(token);
        if (b == null) {
            return token;
        } else {
            return generateId(UUID.randomUUID().toString());
        }
    }
}