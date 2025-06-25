import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class University {
    private List<Course> courses = new ArrayList<>();
    private HashMap<Integer, Student> studentDirectory = new HashMap<>();
    private HashMap<String, LinkedList<Course>> coursesByDept = new HashMap<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public void showAllCourses() {
        System.out.println("Университетские курсы:");
        for (Course course : courses) {
            course.showCourseDetails();
            System.out.println("--------------------------");
        }
    }

    public void registerStudent(Student s) {
        studentDirectory.put(s.getId(), s);
    }

    public Student findStudentById(int id) throws StudentNotFoundException {
        Student s = studentDirectory.get(id);
        if (s == null) {
            throw new StudentNotFoundException(id);
        }
        return s;
    }

    public void addCourseToDept(String deptName, Course c) {
        coursesByDept
                .computeIfAbsent(deptName, k -> new LinkedList<>())
                .add(c);
    }

    public List<Course> getCoursesForDept(String deptName) {
        return coursesByDept.getOrDefault(deptName, new LinkedList<>());
    }
}