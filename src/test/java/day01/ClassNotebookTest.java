package day01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClassNotebookTest {

    @Test
    void testAddStudent() {
        ClassNotebook classNotebook = new ArrayList<>();

        Student s = (new Student(1, "John"));
        classNotebook.addStudent(s);;

        assertTrue(classNotebook.getNotebook().keySet().contains(s));
        assertEquals(0, classNotebook.getNotebook().get(s).size());
    }
}