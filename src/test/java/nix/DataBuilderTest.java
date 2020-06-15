package nix;

import nix.data.StudentClass;
import nix.service.StudentClassService;
import nix.service.impl.ClassServiceImpl;
import nix.service.impl.StudentClassServiceImpl;
import nix.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import nix.builder.DataBuilder;
import nix.config.ApplicationEnvironment;
import nix.data.Student;
import nix.data.Class;
import nix.service.StudentService;
import nix.service.ClassService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DataBuilderTest {

    DataBuilder dataBuilder = new DataBuilder();


    @BeforeAll
    public static void setEnv() {
        ApplicationEnvironment.setPropertyLang("en");
    }

    @Test
    public void build() {
        dataBuilder.buildDataList();

        ClassService classService = dataBuilder.getClassService();
        StudentService studentService = dataBuilder.getStudentService();
        StudentClassService studentClassService = dataBuilder.getStudentClassService();

        assertTrue(classService.findAll().size() == 15);
        assertEquals(studentService.findAll().size(), 5);

        Student student = new Student();
        String studentId = "6";
        String studentFirstName = "Erich";
        String studentLastName = "Gamma";
        student.setStudentId(studentId);
        student.setFirstName(studentFirstName);
        student.setLastName(studentLastName);

        Class classes = new Class();
        String classId = "1";
        String className = "Programming";
        classes.setClassId(classId);
        classes.setClassName(className);


        StudentClass studentClass = new StudentClass();
        String id = "76";
        studentClass.setId(id);
        studentClass.setStudentId(studentId);
        studentClass.setClassId(classId);

        studentService.saveOrUpdate(student);
        classService.saveOrUpdate(classes);
        studentClassService.saveOrUpdate(studentClass);

        assertTrue(classService.findAll().size() == 16);
        assertEquals(studentService.findAll().size(), 6);


    }

    @Test
    public void findByStudentId(){
        dataBuilder.buildDataList();
        StudentService studentService = dataBuilder.getStudentService();
        assertTrue(studentService.findByStudentId("5").getLastName().equals("Martin"));

    }

    @Test
    public void findByFirstName(){
        dataBuilder.buildDataList();
        StudentService studentService = dataBuilder.getStudentService();
        assertTrue(studentService.findByFirstName("Dennis").getStudentId().equals("2"));
    }

    @Test
    public void findByLastName(){
        dataBuilder.buildDataList();
        StudentService studentService = dataBuilder.getStudentService();
        assertTrue(studentService.findByLastName("Stroustrup").getStudentId().equals("1"));
    }

    @Test
    public void findByClassId(){
        dataBuilder.buildDataList();
        ClassService classService = dataBuilder.getClassService();
        assertTrue(classService.findByClassId("3").getClassName().equals("Physics"));
    }

    @Test
    public void findByClassName(){
        dataBuilder.buildDataList();
        ClassService classService = dataBuilder.getClassService();
        assertTrue(classService.findByClassName("Java").getClassId().equals("5"));

    }

    @Test
    public void findById(){
        dataBuilder.buildDataList();
        StudentClassService studentClassService = dataBuilder.getStudentClassService();
        assertTrue(studentClassService.findById("5").getClassId().equals("7"));
    }

    @Test
    public void findByStudentIdInStudentClass(){
        dataBuilder.buildDataList();
        StudentClassService studentClassService = dataBuilder.getStudentClassService();
        assertTrue(studentClassService.findByStudentId("5").getId().equals("5"));
    }


    @Test
    public void findByClassIdInStudentClass(){
        dataBuilder.buildDataList();
        StudentClassService studentClassService = dataBuilder.getStudentClassService();
        assertTrue(studentClassService.findByClassId("3").getId().equals("1"));


    }

}
