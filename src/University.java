import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class University {
    private ArrayList<Course> courses;
    private HashMap<Integer, Student> studentDirectory = new HashMap<>();
    private HashMap<String, LinkedList<Course>> coursesByDept = new HashMap<>();

    public University() {
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public void showAllCourses() {
        System.out.println("Университетские курсы:");
        for (Course course: courses) {
            course.showCourseDetails();
            System.out.println("--------------------------");
        }

    }

    public void registerStudent(Student s) {
        studentDirectory.put(s.getId(), s);
    }

    public Student findStudentById(int id) throws StudentNotFoundException {
        if (!studentDirectory.containsKey(id)) {
            throw new StudentNotFoundException("Student with id " + id + " not found.");
        }
        return studentDirectory.get(id);
    }

    public void addCourseToDept(String deptName, Course c) {
        coursesByDept.putIfAbsent(deptName, new LinkedList<>());
        coursesByDept.get(deptName).add(c);
    }

    public List<Course> getCoursesForDept(String deptName) {
        return coursesByDept.getOrDefault(deptName, new LinkedList<>());
    }

}
