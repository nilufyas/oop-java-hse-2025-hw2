import java.util.LinkedList;
import java.util.List;

public class Department implements Departmental {
    private String name;
    private Professor head;
    private LinkedList<Course> courses;

    public Department(String name, Professor head) {
        this.name = name;
        this.head = head;
        this.courses = new LinkedList<>();
    }

    @Override
    public void addCourse(Course course) {
        if (course != null && !courses.contains(course)) {
            courses.add(course);
            System.out.println("Курс '" + course.getCourseName() + "' добавлен на кафедру '" + name + "'");
        }
    }

    @Override
    public void removeCourse(Course course) {
        if (course != null && courses.remove(course)) {
            System.out.println("Курс '" + course.getCourseName() + "' удалён с кафедры '" + name + "'");
        }
    }

    @Override
    public List<Course> listCourses() {
        return new LinkedList<>(courses); // возвращаем копию для безопасности
    }

    public String getName() {
        return name;
    }

    public Professor getHead() {
        return head;
    }

    public void setHead(Professor head) {
        this.head = head;
    }

    public void showDepartmentInfo() {
        System.out.println("Кафедра: " + name);
        System.out.println("Заведующий: " + (head != null ? head.getDetails() : "Не назначен"));
        System.out.println("Курсы:");
        if (courses.isEmpty()) {
            System.out.println("На кафедре пока нет курсов.");
        } else {
            for (Course course : courses) {
                System.out.println("- " + course.getCourseName());
            }
        }
    }
}