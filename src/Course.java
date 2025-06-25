import java.util.ArrayList;

public class Course {
    private String courseName;
    private Professor professor;
    private ArrayList<Student> students;
    private Queue<Student> waitingList = new LinkedList<>();
    private int maxStudents;

    public Course(String courseName, Professor professor) throws InvalidCourseException {
        if (courseName == null || courseName.isEmpty()) {
            throw new InvalidCourseException("Курс обязательно должен иметь название");
        }
        this.courseName = courseName;
        this.professor = professor;
        this.students = new ArrayList<>();
        this.waitingList = new LinkedList<>();
    }

    public void addStudent(Student student) {
        if (students.size() < maxStudents) {
            students.add(student);
        } else {
            waitingList.add(student);
        }

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

    public void processWaitingList() {
        while (students.size() < maxStudents && !waitingList.isEmpty()) {
            students.add(waitingList.poll());
        }
    }

    public int getWaitingListSize() {
        return waitingList.size();
    }

}
