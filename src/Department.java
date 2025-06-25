import java.util.LinkedList;
import java.util.List;

public class Department implements Departmental {
    private String name;
    private Professor head;
    private LinkedList<Course> courses = new LinkedList<>();

    public Department(String name, Professor head) {
        this.name = name;
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public Professor getHead() {
        return head;
    }

    @Override
    public void addCourse(Course c) {
        courses.add(c);
    }

    @Override
    public void removeCourse(Course c) {
        courses.remove(c);
    }

    @Override
    public List<Course> listCourses() {
        return new LinkedList<>(courses);
    }
}

