package nix.builder;

import nix.config.ApplicationEnvironment;
import nix.data.Student;
import nix.data.Class;
import nix.data.StudentClass;
import nix.service.StudentService;
import nix.service.ClassService;
import nix.service.StudentClassService;
import nix.service.impl.StudentServiceImpl;
import nix.service.impl.ClassServiceImpl;
import nix.service.impl.StudentClassServiceImpl;

import java.util.*;

public class DataBuilder implements AbstractBuilder{

    private final StudentService StudentService = new StudentServiceImpl();
    private final ClassService ClassService = new ClassServiceImpl();
    private final StudentClassService StudentClassService = new StudentClassServiceImpl();


    @Override
    public void buildDataList() {

        for (Map.Entry<String, String> entry : getKeyValueMapByBundleProperties(ApplicationEnvironment.getPropertyLang()).entrySet()) {
            StringTokenizer str = new StringTokenizer(entry.getValue(), "#");
            StudentClass studentClass = new StudentClass();

            Student student = new Student();
            String studentId = entry.getKey();


            String studentFirstNameProperties = str.nextToken();
                String studentLastNameProperties = str.nextToken();
                student.setStudentId(studentId);
                studentClass.setId(studentId);
                studentClass.setStudentId(studentId);
                student.setFirstName(studentFirstNameProperties);
                student.setLastName(studentLastNameProperties);
                StudentService.saveOrUpdate(student);



                while(str.hasMoreTokens()==true){
                    Class classes = new Class();
                    String classesId = str.nextToken();

                    classes.setClassId(classesId);
                    String className = str.nextToken();
                    classes.setClassName(className);
                    ClassService.saveOrUpdate(classes);
                    studentClass.setClassId(classesId);
                    StudentClassService.saveOrUpdate(studentClass);
                }

        }

        StudentService.findAll().forEach(Student -> {
            System.out.println();
            System.out.println("Student id = " + Student.getStudentId());
            System.out.println("First name = " + Student.getFirstName());
            System.out.println("Last name = " + Student.getLastName());
            System.out.println();
        });
        ClassService.findAll().forEach(Class -> {
            System.out.println();
            System.out.println("Class id = " + Class.getClassId());
            System.out.println("Class name = " + Class.getClassName());
            System.out.println();
        });
        StudentClassService.findAll().forEach(StudentClass -> {
            System.out.println();
            System.out.println("Id = " + StudentClass.getStudentId());
            System.out.println("Student id = " + StudentClass.getStudentId());
            System.out.println("Class id = " + StudentClass.getClassId());
            System.out.println();
        }); }

    public StudentService getStudentService() {
        return StudentService;
    }

    public ClassService getClassService() {
        return ClassService;
    }

    public StudentClassService getStudentClassService() {
        return StudentClassService;
    }

}
