import java.util.ArrayList;

public class University {
    private ArrayList<Course> courses;

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
}
