package task1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class StudentGroupTest {

    @Test
    void addStudent() {
        Student student = new Student("Даша Гусева", new HashMap<>());
        StudentGroup group = new StudentGroup(17, new HashMap<>());
        group.addStudent(student);
        assertEquals(group.getStudent(student.getName()), student);
    }

    @Test
    void deleteStudent() {
        Student student = new Student("Даша Гусева", new HashMap<>());
        StudentGroup group = new StudentGroup(17, new HashMap<>());
        group.addStudent(student);
        group.deleteStudent(student.getName());
        assertNull(group.getStudent(student.getName()));
    }
}