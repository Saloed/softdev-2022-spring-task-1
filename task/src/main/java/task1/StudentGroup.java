package task1;

import java.util.HashMap;
import java.util.Map;

public class StudentGroup {

    private final Map<String, Student> students;

    private final Integer number;

    public StudentGroup(Integer number, HashMap<String, Student> group) {
        this.students = new HashMap<>();
        this.number = number;
    }

    public void addStudent(Student student) {
        this.students.put(student.getName(), student);
    }

    public void deleteStudent(String name) {
        if (students.containsKey(name))
            students.remove(name);
    }

    public Student getStudent(String name) {
        return students.get(name);
    }
}