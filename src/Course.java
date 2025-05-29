import java.util.ArrayList;

public class Course {
    private String courseName;
    private Professor professor;
    private ArrayList<Student> students;

    public Course(String courseName, Professor professor) throws InvalidCourseException {
        if (courseName == null || courseName.isEmpty()) {
            throw new InvalidCourseException("Курс обязательно должен иметь название");
        }
        this.courseName = courseName;
        this.professor = professor;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    public void showCourseDetails() {
        System.out.println("Курс: " + courseName);
        System.out.println("Преподаватель: " + professor.getDetails());
        System.out.println("Записанные студенты:");
        for (Student student: students) {
            System.out.println(" - " + student.getDetails());
        }
    }
}
