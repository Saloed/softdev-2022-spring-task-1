package task1;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private final int numb;
    private final List<String> student;
    private final List<String> subjects;
    private final List<Integer> marks;

    public Group(int numb, ArrayList<String> student, ArrayList<String> subjects, ArrayList<Integer> marks) {
        this.numb = numb;
        this.student = student;
        this.subjects = subjects;
        this.marks = marks;
    }
    public int a;
    public List<String> delName (String delname) {
        if (student.contains(delname))
            a = student.indexOf(delname) + 1;
        student.remove(delname);
        for (int i = 0; i<subjects.size(); i++) {
            marks.remove(a*subjects.size());
            a += 1;
        }
        return (student);
    }
    public List<String> addName (String addname) {
        if (!student.contains(addname))
            student.add(addname);
        return student;
    }
    public List<String> addSubject (String addsubject) {
        if (!subjects.contains(addsubject))
            subjects.add(addsubject);
        return subjects;
    }
    public List<String> dellSubject (String dellsub) {
        if (subjects.contains(dellsub))
            a = subjects.indexOf(dellsub) + 1;
        subjects.remove(dellsub);
        for (int i = 0; i<subjects.size();i++){
            marks.remove(a);
            a += subjects.size();
        }
        return subjects;
    }
    public ArrayList<Integer> dellmark (String stud, String sub){
        ArrayList<Integer> test = new ArrayList<>();
        marks.set(subjects.indexOf(sub)+student.indexOf(stud)*subjects.size(), null);
        for (int i=student.indexOf(stud)* subjects.size(); i<(student.indexOf(stud)+1)* subjects.size();i++){
            test.add(marks.get(i));
        }
        return test;
    }
    public ArrayList<Integer> changemark (Integer dm, String stud, String sub){
        ArrayList<Integer> test = new ArrayList<>();
        marks.set(subjects.indexOf(sub)+student.indexOf(stud)*subjects.size(), dm);
        for (int i=student.indexOf(stud)* subjects.size(); i<(student.indexOf(stud)+1)* subjects.size();i++){
            test.add(marks.get(i));
        }
        return test;
    }
}

