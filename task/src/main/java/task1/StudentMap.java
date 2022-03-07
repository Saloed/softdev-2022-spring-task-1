package task1;

import java.util.HashMap;
import java.util.Map;

public class StudentMap {

    private final HashMap<String, Student> students;

    public StudentMap(HashMap<String, Student> students) {
        this.students = students;
    }

    public void addStudent(String name, Student student) {
        if (!this.students.containsKey(name))
            this.students.put(name, student);
    }

    public String deleteStudent(String name) {
        if (this.students.containsKey(name))
            this.students.remove(name);
        if (!this.students.containsKey(name))
            return name;
        return null;
    }

    public String getName(String name) {
        return students.get(name).name;
    }
}