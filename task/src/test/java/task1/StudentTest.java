package task1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    @Test
    void changeMark() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Math", 3);
        map.put("Physics", 5);
        map.put("PE", 1);
        map.put("Philosophy", 4);
        Student studentMax = new Student("Max", map);
        studentMax.changeMark("Math", 5);
        assertEquals(5, studentMax.getMark("Math"));
    }

    @Test
    void addSubject() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Math", 3);
        map.put("Physics", 5);
        map.put("PE", 2);
        map.put("Philosophy", 4);
        Student studentMax = new Student("Max", map);
        studentMax.addSubject("IT");
        map.put("IT", 4);
        assertEquals(map, studentMax.addSubject("IT"));
    }

    @Test
    void deleteSubject() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Math", 3);
        map.put("Physics", 5);
        map.put("PE", 2);
        map.put("Philosophy", 4);
        Student studentMax = new Student("Max", map);
        studentMax.deleteSubject("Math");
        assertEquals(map, studentMax.deleteSubject("Math"));

    }
}