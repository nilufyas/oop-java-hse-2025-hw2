public class StudentNotFoundException extends Exception {
    public StudentNotFoundException() {
        super("Студент не найден");
    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}