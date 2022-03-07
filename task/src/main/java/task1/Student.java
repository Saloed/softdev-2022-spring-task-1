package task1;

import java.util.HashMap;

public class Student {

    public String name;

    private final HashMap<String, Integer> subjects;

    public Student(String name, HashMap<String, Integer> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public void changeMark(String subject, Integer mark) {
        this.subjects.put(subject, mark);
    }

    public Integer getMark(String subject) {
        return subjects.get(subject);
    }

    public HashMap<String, Integer> addSubject(String subject) {
        if (!subject.contains(subject)) {
            subjects.put(subject, null);
        }
        return subjects;
    }

    public HashMap<String, Integer> deleteSubject(String subject) {
        if (subjects.containsKey(subject)) {
            subjects.remove(subject);
        }
        return subjects;
    }
}