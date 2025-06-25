import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Course implements Publishable {
    private static final int WAITING_LIST_LIMIT = 3;
    private String courseName;
    private Professor professor;
    private ArrayList<Student> students;
    private Queue<Student> waitingList = new LinkedList<>();
    private int maxStudents;
    private LinkedList<String> feed = new LinkedList<>();
    private LinkedList<Event> schedule = new LinkedList<>();

    public Course(String courseName, Professor professor) throws InvalidCourseException {
        if (courseName == null || courseName.isEmpty()) {
            throw new InvalidCourseException("Курс обязательно должен иметь название");
        }
        this.courseName = courseName;
        this.professor = professor;
        this.students = new ArrayList<>();
        this.waitingList = new LinkedList<>();
    }

    public void addStudent(Student student) throws CourseFullException {
        if (students.size() < maxStudents) {
            students.add(student);
        } else if (waitingList.size() < WAITING_LIST_LIMIT) {
            waitingList.add(student);
        }
        else {
            throw new CourseFullException(courseName);
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
    @Override
    public void publish(String message) {
        feed.add(message);
    }

    @Override
    public List<String> getFeed() {
        return feed;
    }

    public void scheduleEvent(String description, String dateTime) {
        schedule.add(new Event(description, dateTime));
    }

    public List<Event> getSchedule() {
        return schedule;
    }

    public String getCourseName() {
        return courseName;
    }
}
