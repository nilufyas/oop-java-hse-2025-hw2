// src/Course.java

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course implements Publishable, Schedulable {
    private String courseName;
    private Professor professor;
    private List<Student> students;
    private Queue<Student> waitingList;
    private LinkedList<String> feed;
    private LinkedList<Event> schedule;
    private int maxStudents;

    public Course(String courseName, Professor professor, int maxStudents) throws InvalidCourseException {
        if (courseName == null || courseName.isEmpty()) {
            throw new InvalidCourseException("Курс обязательно должен иметь название");
        }
        this.courseName = courseName;
        this.professor = professor;
        this.maxStudents = maxStudents;
        this.students = new ArrayList<>();
        this.waitingList = new LinkedList<>();
        this.feed = new LinkedList<>();
        this.schedule = new LinkedList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void addStudent(Student student) throws CourseFullException {
        if (students.size() < maxStudents) {
            students.add(student);
        } else if (waitingList.size() < maxStudents) {
            waitingList.add(student);
        } else {
            throw new CourseFullException(courseName);
        }
    }

    public void removeStudent(Student student) {
        if (students.remove(student)) {
            processWaitingList();
        } else {
            waitingList.remove(student);
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
        feed.addLast(message);
    }

    @Override
    public List<String> getFeed() {
        return new LinkedList<>(feed);
    }

    @Override
    public void scheduleEvent(String description, String dateTime) {
        schedule.add(new Event(description, dateTime));
    }

    @Override
    public List<Event> getSchedule() {
        return new LinkedList<>(schedule);
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    public void showCourseDetails() {
        System.out.println("Курс: " + courseName);
        System.out.println("Преподаватель: " + professor.getDetails());
        System.out.println("Студентов: " + students.size() + "/" + maxStudents);
        for (Student s : students) {
            System.out.println(" - " + s.getDetails());
        }
        System.out.println("Очередь ожидания (" + getWaitingListSize() + "):");
        for (Student s : waitingList) {
            System.out.println(" ~ " + s.getDetails());
        }
        System.out.println("Лента объявлений:");
        for (String msg : feed) {
            System.out.println(" * " + msg);
        }
        System.out.println("Расписание событий:");
        for (Event e : schedule) {
            System.out.println(" # " + e);
        }
    }
}