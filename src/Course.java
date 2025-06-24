import java.util.*;

public class Course implements Publishable, Schedulable {
    private String courseName;
    private Professor professor;
    private ArrayList<Student> students;
    private int maxStudents;
    private Queue<Student> waitingList;
    private LinkedList<String> feed;
    private LinkedList<Event> schedule;
    private int maxWaitingListSize;

    public Course(String courseName, Professor professor, int maxStudents, int maxWaitingListSize) throws InvalidCourseException {
        if (courseName == null || courseName.isEmpty()) {
            throw new InvalidCourseException("Курс обязательно должен иметь название");
        }
        this.courseName = courseName;
        this.professor = professor;
        this.maxStudents = maxStudents;
        this.maxWaitingListSize = maxWaitingListSize;
        this.students = new ArrayList<>();
        this.waitingList = new LinkedList<>();
        this.feed = new LinkedList<>();
        this.schedule = new LinkedList<>();
    }

    // --- Методы из Publishable ---
    @Override
    public void publish(String message) {
        feed.addLast(message);
    }

    @Override
    public List<String> getFeed() {
        return new LinkedList<>(feed);
    }

    // --- Методы из Schedulable ---
    @Override
    public void scheduleEvent(String description, String dateTime) {
        schedule.add(new Event(description, dateTime));
    }

    @Override
    public List<Event> getSchedule() {
        return new LinkedList<>(schedule);
    }

    // --- Остальные методы ---

    public void addStudent(Student student) throws CourseFullException {
        if (students.size() < maxStudents) {
            students.add(student);
        } else if (waitingList.size() >= maxWaitingListSize) {
            throw new CourseFullException(courseName);
        } else {
            waitingList.add(student);
            System.out.println(student.getDetails() + " добавлен(а) в очередь ожидания.");
        }
    }

    public void removeStudent(Student student) {
        if (students.remove(student)) {
            System.out.println(student.getDetails() + " отчислен(а). Проверяю очередь...");
            processWaitingList();
        }
    }

    public void processWaitingList() {
        while (!waitingList.isEmpty() && students.size() < maxStudents) {
            Student student = waitingList.poll();
            if (student != null) {
                students.add(student);
                System.out.println(student.getDetails() + " переведён(а) из очереди в основной список.");
            }
        }
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    public int getWaitingListSize() {
        return waitingList.size();
    }

    public String getCourseName() {
        return courseName;
    }

    public void showCourseDetails() {
        System.out.println("Курс: " + courseName);
        System.out.println("Преподаватель: " + professor.getDetails());
        System.out.println("Записанные студенты:");
        for (Student student : students) {
            System.out.println(" - " + student.getDetails());
        }

        if (!feed.isEmpty()) {
            System.out.println("\n--- Лента курса ---");
            for (String message : feed) {
                System.out.println("- " + message);
            }
        }

        if (!schedule.isEmpty()) {
            System.out.println("\n--- Расписание курса ---");
            for (Event event : schedule) {
                System.out.println("- " + event.getDescription() + " (" + event.getDateTime() + ")");
            }
        }
    }
}