package task1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapTest {

    @Test
    void addStudent() {
        HashMap<String, Integer> mapOfSubjects = new HashMap<>();
        mapOfSubjects.put("Math", 4);
        mapOfSubjects.put("Physics", 3);
        mapOfSubjects.put("PE", 3);
        HashMap<String, Student> mOS = new HashMap<>();
        Student studentIvan = new Student("Ivan", mapOfSubjects);
        Student studentAlex = new Student("Alex", mapOfSubjects);
        Student studentLera = new Student("Lera", mapOfSubjects);
        mOS.put(studentIvan.name, studentIvan);
        mOS.put(studentAlex.name, studentAlex);
        StudentMap mapOfStudents = new StudentMap(mOS);
        mapOfStudents.addStudent("Lera", studentLera);
        assertEquals("Lera", mapOfStudents.getName("Lera"));
    }

    @Test
    void deleteStudent() {
        HashMap<String, Integer> mapOfSubjects = new HashMap<>();
        mapOfSubjects.put("Math", 4);
        mapOfSubjects.put("Physics", 3);
        mapOfSubjects.put("PE", 3);
        HashMap<String, Student> mOS = new HashMap<>();
        Student studentIvan = new Student("Ivan", mapOfSubjects);
        Student studentAlex = new Student("Alex", mapOfSubjects);
        Student studentLera = new Student("Lera", mapOfSubjects);
        Student studentMarat = new Student("Marat", mapOfSubjects);
        mOS.put(studentIvan.name, studentIvan);
        mOS.put(studentAlex.name, studentAlex);
        mOS.put(studentLera.name, studentLera);
        mOS.put(studentMarat.name, studentMarat);
        StudentMap mapOfStudents = new StudentMap(mOS);
        mapOfStudents.deleteStudent("Marat");
        assertEquals("Marat", mapOfStudents.deleteStudent("Marat"));
    }
}