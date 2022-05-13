package task1;

import java.util.*;

public class Group {

    String number;
    Set<String> subjects;
    Map<String, Student> students;

    public Group(String number, Set<String> subjects, List<Student> students) {
        this.number = number;
        this.subjects = new HashSet<>(subjects);

        Map<String, Student> studentMap = new HashMap<>();
        for (Student student : students) {
            student.setSubjects(this.subjects);
            studentMap.put(student.name, student);
        }
        this.students = studentMap;
    }

    public Group(String number, String subjects, String students) {
        this.number = number;
        this.subjects = new HashSet<>(List.of(subjects.split(", ")));

        Map<String, Student> studentMap = new HashMap<>();
        for (String studentName : students.split(", ")) {
            Student student = new Student(studentName);
            student.setSubjects(this.subjects);
            studentMap.put(studentName, student);
        }
        this.students = studentMap;
    }

    // добавляет студента если его еще нет в списке иначе ничего не делает
    public void addStudent(String studentName) {
        if (students.get(studentName) != null) return;
        Student student = new Student(studentName);
        student.setSubjects(subjects);
        students.put(studentName, student);
    }

    // удаляет студента
    public void deleteStudent(String studentName) {
        students.remove(studentName);
    }

    // добавляет предмет
    public void addSubject(String subjectName) {
        subjects.add(subjectName);
        for (String studentName : students.keySet()) {
            students.get(studentName).addSubject(subjectName);
        }
    }

    // удаляет предмет
    public void deleteSubject(String subjectName) {
        subjects.remove(subjectName);
        for (String studentName : students.keySet()) {
            students.get(studentName).deleteSubject(subjectName);
        }
    }

    // выполняет функцию как изменения так и добавления оценки у заданного студента по заданному предмету
    public void changeStudentsGradeForSubject(String studentName, String subjectName, Integer grade) {
        students.get(studentName).changeGradeForSubject(subjectName, grade);
    }

    // удаляет оценку по заданному предмету у заданного предмета, по факту просто меняет ее на null
    public void deleteStudentsGradeForSubject(String studentName, String subjectName) {
        changeStudentsGradeForSubject(studentName, subjectName, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(number, group.number) &&
                Objects.equals(subjects, group.subjects) &&
                Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, subjects, students);
    }

    // класс одного студента
    static class Student {
        private final String name;
        private final Map<String, Integer> grades;

        public Student(String name, Map<String, Integer> grades) {
            this.name = name;
            this.grades = new HashMap<>(grades);
        }

        public Student(String name) {
            this(name, new HashMap<>());
        }

        // добавляет предмет с пустой оценкой по нему студенту
        private void addSubject(String subject) {
            grades.put(subject, null);
        }

        // удаляет предмет и оценку по нему у студента
        private void deleteSubject(String subject) {
            grades.remove(subject);
        }

        // добавляет все предметы студенту, если такой предмет уже есть то ничего не происходит
        // если нет то ставит пустую оценку по нему
        private void addAllSubjects(Set<String> subjects) {
            List<String> notIntersectionList = new ArrayList<>(subjects);
            notIntersectionList.removeAll(grades.keySet());
            notIntersectionList.forEach(subjectName -> grades.put(subjectName, null));

        }

        // устанавливает предметы для студента
        // если некоторых предметов нет у студента то добавляет их
        // если есть лишние то удаляет их
        public void setSubjects(Set<String> subjects) {
            addAllSubjects(subjects);
            if (grades.size() == subjects.size()) return;
            grades.forEach( (subject, grade) -> {
                if (!subjects.contains(subject)) deleteSubject(subject);
            });
        }

        // меняет данному студенту оценку по данному предмету
        public void changeGradeForSubject(String subject, Integer grade) {
            grades.put(subject, grade);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) && Objects.equals(grades, student.grades);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, grades);
        }
    }

}