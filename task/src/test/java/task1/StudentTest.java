package task1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private static final String NAME = "Даша Гусева";

    @Test
    void getName() {
        HashMap<String, Integer> sub = new HashMap<>();
        Student student = new Student(NAME, sub);
        assertEquals(NAME, student.getName());
    }

    @Test
    void addSubject() {
        String subject = "Физика";
        Integer mark = 2;
        HashMap<String, Integer> sub = new HashMap<>();
        sub.put("Математика", 4);
        Student student = new Student("Даша Гусева", sub);
        assertEquals(sub, student.addSubject(subject, mark));
    }

    @Test
    void deleteSubject() {
        HashMap<String, Integer> sub = new HashMap<>();
        sub.put("Физра", 6);
        sub.put("Математика", 4);
        HashMap<String, Integer> subjects = new HashMap<>();
        subjects.put("Физра", 6);
        Student student = new Student(" Даша Гусева", sub);
        assertEquals(subjects, student.deleteSubject("Математика"));

    }

    @Test
    void replaceMark() {
        HashMap<String, Integer> sub = new HashMap<>();
        sub.put("Физра", 6);
        sub.put("Математика", 4);
        HashMap<String, Integer> subjects = new HashMap<>();
        subjects.put("Физра", 6);
        subjects.put("Математика", 6);
        Student student = new Student(" Даша Гусева", sub);
        assertEquals(subjects, student.replaceMark("Математика", 6));
    }
}