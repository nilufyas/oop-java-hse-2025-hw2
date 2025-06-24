import java.util.LinkedList;
import java.util.List;

public class Department implements Departmental {
    private String name;
    private Professor head;
    private LinkedList<Course> courses;

    /**
     * Конструктор кафедры
     * @param name Название кафедры
     * @param head Руководитель кафедры
     */
    public Department(String name, Professor head) {
        this.name = name;
        this.head = head;
        this.courses = new LinkedList<>();
    }

    /**
     * Добавляет курс на кафедру
     * @param c Курс
     */
    @Override
    public void addCourse(Course c) {
        courses.add(c);
    }

    /**
     * Удаляет курс с кафедры
     * @param c Курс
     */
    @Override
    public void removeCourse(Course c) {
        courses.remove(c);
    }

    /**
     * Возвращает список курсов кафедры
     * @return Список курсов
     */
    @Override
    public List<Course> listCourses() {
        return courses;
    }
}