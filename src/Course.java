import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course implements Publishable, Schedulable {
    private String courseName;
    private Professor professor;
    private ArrayList<Student> students;
    private Queue<Student> waitingList;
    private LinkedList<String> feed;
    private LinkedList<Event> schedule;
    private int maxStudents;

    /**
     * Конструктор курса
     * @param courseName Название курса
     * @param professor Преподаватель
     * @param maxStudents Максимальная вместимость курса
     * @throws InvalidCourseException Если название курса пустое или null
     */
    public Course(String courseName, Professor professor, int maxStudents) throws InvalidCourseException {
        if (courseName == null || courseName.isEmpty()) {
            throw new InvalidCourseException("Курс обязательно должен иметь название");
        }
        this.courseName = courseName;
        this.professor = professor;
        this.students = new ArrayList<>();
        this.waitingList = new LinkedList<>();
        this.feed = new LinkedList<>();
        this.schedule = new LinkedList<>();
        this.maxStudents = maxStudents;
    }

    /**
     * Добавляет студента на курс или в очередь ожидания
     * @param student Студент для добавления
     * @throws CourseFullException Если курс и очередь ожидания полны
     */
    public void addStudent(Student student) throws CourseFullException {
        if (students.size() < maxStudents) {
            students.add(student);
        } else if (waitingList.size() < maxStudents) { // Очередь ограничена тем же maxStudents
            waitingList.add(student);
        } else {
            throw new CourseFullException("Course " + courseName + " is completely full");
        }
    }

    /**
     * Удаляет студента из списка студентов
     * @param student Студент для удаления
     */
    public void removeStudent(Student student) {
        students.remove(student);
    }

    /**
     * Возвращает количество студентов на курсе
     * @return Размер списка студентов
     */
    public int getNumberOfStudents() {
        return students.size();
    }

    /**
     * Обрабатывает очередь ожидания, перемещая студентов в основной список, если есть место
     */
    public void processWaitingList() {
        while (!waitingList.isEmpty() && students.size() < maxStudents) {
            Student student = waitingList.poll();
            students.add(student);
        }
    }

    /**
     * Возвращает размер очереди ожидания
     * @return Количество студентов в очереди
     */
    public int getWaitingListSize() {
        return waitingList.size();
    }

    /**
     * Выводит информацию о курсе
     */
    public void showCourseDetails() {
        System.out.println("Курс: " + courseName);
        System.out.println("Преподаватель: " + professor.getDetails());
        System.out.println("Максимальная вместимость: " + maxStudents);
        System.out.println("Записанные студенты:");
        for (Student student : students) {
            System.out.println(" - " + student.getDetails());
        }
        System.out.println("Студенты в очереди ожидания: " + waitingList.size());
    }

    /**
     * Публикует объявление в ленте курса
     * @param message Текст объявления
     */
    @Override
    public void publish(String message) {
        feed.add(message);
    }

    /**
     * Возвращает список объявлений
     * @return Лента объявлений
     */
    @Override
    public List<String> getFeed() {
        return feed;
    }

    /**
     * Планирует событие для курса
     * @param description Описание события
     * @param dateTime Дата и время события
     */
    @Override
    public void scheduleEvent(String description, String dateTime) {
        schedule.add(new Event(description, dateTime));
    }

    /**
     * Возвращает расписание курса
     * @return Список событий
     */
    @Override
    public List<Event> getSchedule() {
        return schedule;
    }
}