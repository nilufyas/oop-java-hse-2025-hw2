import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class University {
    private ArrayList<Course> courses;
    private HashMap<Integer, Student> studentDirectory;
    private HashMap<String, LinkedList<Course>> coursesByDept;

    /**
     * Конструктор университета
     */
    public University() {
        courses = new ArrayList<>();
        studentDirectory = new HashMap<>();
        coursesByDept = new HashMap<>();
    }

    /**
     * Добавляет курс в университет
     * @param course Курс для добавления
     */
    public void addCourse(Course course) {
        courses.add(course);
    }

    /**
     * Удаляет курс из университета
     * @param course Курс для удаления
     */
    public void removeCourse(Course course) {
        courses.remove(course);
    }

    /**
     * Выводит информацию о всех курсах
     */
    public void showAllCourses() {
        System.out.println("Университетские курсы:");
        for (Course course : courses) {
            course.showCourseDetails();
            System.out.println("--------------------------");
        }
    }

    /**
     * Регистрирует студента в справочнике
     * @param student Студент для регистрации
     */
    public void registerStudent(Student student) {
        studentDirectory.put(student.getId(), student);
    }

    /**
     * Находит студента по ID
     * @param id ID студента
     * @return Студент
     * @throws StudentNotFoundException Если студент не найден
     */
    public Student findStudentById(int id) throws StudentNotFoundException {
        Student student = studentDirectory.get(id);
        if (student == null) {
            throw new StudentNotFoundException("Студент с ID " + id + " не найден");
        }
        return student;
    }

    /**
     * Добавляет курс в кафедру
     * @param deptName Название кафедры
     * @param course Курс для добавления
     */
    public void addCourseToDept(String deptName, Course course) {
        coursesByDept.computeIfAbsent(deptName, k -> new LinkedList<>()).add(course);
    }

    /**
     * Возвращает список курсов для кафедры
     * @param deptName Название кафедры
     * @return Список курсов
     */
    public List<Course> getCoursesForDept(String deptName) {
        return coursesByDept.getOrDefault(deptName, new LinkedList<>());
    }
}