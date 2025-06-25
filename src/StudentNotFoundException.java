public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(int id) {
        super("Student with id " + id + " not found");
    }
}