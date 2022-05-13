package task1;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupTest {

    Group exampleGroup = new Group(
            "3530901/10004",
            "Math, IT, Physics",
            "1, 2, 3"
    );

    @Test
    public void addStudent() {
        exampleGroup.addStudent("4");
        Group expected = new Group(
                "3530901/10004",
                "Math, IT, Physics",
                "1, 2, 3, 4"
        );
        assertEquals(expected, exampleGroup);
    }

    @Test
    public void deleteStudent() {
        exampleGroup.deleteStudent("3");
        Group expected = new Group(
                "3530901/10004",
                "Math, IT, Physics",
                "1, 2"
        );
        assertEquals(expected, exampleGroup);
    }

    @Test
    public void addSubject() {
        exampleGroup.addSubject("Economics");
        Group expected = new Group(
                "3530901/10004",
                "Math, IT, Physics, Economics",
                "1, 2, 3"
        );
        assertEquals(expected, exampleGroup);
    }

    @Test
    public void deleteSubject() {
        exampleGroup.deleteSubject("Physics");
        Group expected = new Group(
                "3530901/10004",
                "Math, IT",
                "1, 2, 3"
        );
        assertEquals(expected, exampleGroup);
    }

    @Test
    public void changeStudentsGradeForSubject() {
        exampleGroup.changeStudentsGradeForSubject("1", "IT", 5);
        Group expected = new Group(
                "3530901/10004",
                Set.of("Math", "IT", "Physics"),
                List.of(
                        new Group.Student("1", Map.of("IT", 5)),
                        new Group.Student("2"),
                        new Group.Student("3")
                )
        );
        assertEquals(expected, exampleGroup);
    }

    @Test
    public void deleteStudentsGradeForSubject() {
        Group group = new Group(
                "3530901/10004",
                Set.of("Math", "IT", "Physics"),
                List.of(
                        new Group.Student("1", Map.of("IT", 5)),
                        new Group.Student("2"),
                        new Group.Student("3")
                )
        );
        group.deleteStudentsGradeForSubject("1", "IT");
        assertEquals(exampleGroup, group);
    }
}
