public class CourseFullException extends Exception {
    public CourseFullException(String courseName) {
        super("Course " + courseName + " is completely full");
    }
}

