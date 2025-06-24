public class CourseFullException extends Exception {
    public CourseFullException(String courseName) {
        super("Course [" + courseName + "] is completely full");
    }

    public CourseFullException(String courseName, Throwable cause) {
        super("Course [" + courseName + "] is completely full", cause);
    }
}