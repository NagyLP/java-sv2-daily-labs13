package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ClassNotebook {

    private Map<Student, List<Integer>> notebook = new TreeMap<>();

    public void addStudent(Student student) {
        notebook.put(student, new ArrayList<>());
    }

    public Student addMark(int id, int mark) {
        for (Student item : notebook.keySet()) {
            if (item.getId() == id) {
                return item;
            }
        }
        throw new IllegalArgumentException("Ivalid ID");
    }
}
