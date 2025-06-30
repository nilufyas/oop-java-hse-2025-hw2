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

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void removeCourse(Course c) {
        courses.remove(c);
    }

    public List<Course> listCourses() {
        return courses;
    }
}
