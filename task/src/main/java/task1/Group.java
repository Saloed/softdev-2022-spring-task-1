package task1;

import java.util.ArrayList;

public class Group {
    private final int numb;
    private final ArrayList<String> student;
    private final ArrayList<String> subjects;
    private final ArrayList<Integer> marks;

    public Group(int numb, ArrayList<String> student, ArrayList<String> subjects, ArrayList<Integer> marks) {
        this.numb = numb;
        this.student = student;
        this.subjects = subjects;
        this.marks = marks;
    }
    public int a;
    public ArrayList<String> delName (String delname) {
        if (student.contains(delname))
            a = student.indexOf(delname) + 1;
        student.remove(delname);
        for (int i = 0; i<subjects.size(); i++) {
            marks.remove(a*subjects.size());
            a += 1;
        }
        return (student);
    }
    public ArrayList<String> addName (String addname) {
        if (!student.contains(addname))
            student.add(addname);
        return student;
    }
    public ArrayList<String> addSubject (String addsubject) {
        if (!subjects.contains(addsubject))
            subjects.add(addsubject);
        return subjects;
    }
    public ArrayList<String> dellSubject (String dellsub) {
        if (subjects.contains(dellsub))
            a = subjects.indexOf(dellsub) + 1;
        subjects.remove(dellsub);
        for (int i = 0; i<subjects.size();i++){
            marks.remove(a);
            a += subjects.size();
        }
        return subjects;
    }
    public int idp;
    public int ids;
    public ArrayList<Integer> test = new ArrayList<>();
    public ArrayList<Integer> dellmark (String stud, String sub){
        test = new ArrayList<>();
        idp = subjects.indexOf(sub);
        ids = student.indexOf(stud);
        marks.set(idp+ids*subjects.size(), null);
        for (int i=ids* subjects.size(); i<(ids+1)* subjects.size();i++){
            test.add(marks.get(i));
        }
        return test;
    }
    public ArrayList<Integer> changemark (Integer dm, String stud, String sub){
        test = new ArrayList<>();
        idp = subjects.indexOf(sub);
        ids = student.indexOf(stud);
        marks.set(idp+ids*subjects.size(), dm);
        for (int i=ids* subjects.size(); i<(ids+1)* subjects.size();i++){
            test.add(marks.get(i));
        }
        return test;
    }
}

