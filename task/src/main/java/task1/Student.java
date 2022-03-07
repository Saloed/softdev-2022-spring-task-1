package task1;

import java.util.HashMap;
import java.util.Map;

public class Student {

    private final String name;

    private final HashMap<String, Integer> subjects;

    public Student(String name, HashMap<String, Integer> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return this.name;
    }

    public HashMap<String, Integer> addSubject(String subject, Integer mark) {
        this.subjects.put(subject, mark);
        return subjects;
    }

    public HashMap<String, Integer> deleteSubject(String subject) {
        this.subjects.remove(subject);
        return subjects;
    }

    public HashMap<String, Integer> replaceMark(String subject, Integer mark) {
        if (this.subjects.containsKey(subject)) {
            this.subjects.replace(subject, mark);
        }
        return subjects;
    }
    public Integer getMark(String subject) {
        return this.subjects.get(subject);
    }
}

