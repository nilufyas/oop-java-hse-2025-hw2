import java.util.*;

public class University {
    private ArrayList<Course> courses;
    private HashMap<Integer, Student> studentDirectory;
    private HashMap<String, LinkedList<Course>> coursesByDept;

    public University() {
        courses = new ArrayList<>();
        studentDirectory = new HashMap<>();
        coursesByDept = new HashMap<>();
    }

    public void addCourse(Course course) {
        if (course != null && !courses.contains(course)) {
            courses.add(course);
        }
    }

    public void removeCourse(Course course) {
        if (course != null) {
            courses.remove(course);
        }
    }

    public void showAllCourses() {
        System.out.println("Университетские курсы:");
        for (Course course : courses) {
            course.showCourseDetails();
            System.out.println("--------------------------");
        }
    }

    // --- Регистрация и поиск студентов ---
    public void registerStudent(Student student) {
        if (student != null) {
            studentDirectory.put(student.getId(), student);
        }
    }

    public Student findStudentById(int id) throws StudentNotFoundException {
        Student student = studentDirectory.get(id);
        if (student == null) {
            throw new StudentNotFoundException("Студент с ID " + id + " не найден в справочнике.");
        }
        return student;
    }

    // --- Группировка курсов по кафедрам ---
    public void addCourseToDept(String deptName, Course course) {
        if (deptName == null || course == null) return;

        coursesByDept.computeIfAbsent(deptName, k -> new LinkedList<>()).add(course);
    }

    public List<Course> getCoursesForDept(String deptName) {
        return coursesByDept.getOrDefault(deptName, new LinkedList<>());
    }

    public void printCoursesByDepartment(String deptName) {
        List<Course> deptCourses = getCoursesForDept(deptName);
        System.out.println("\nКурсы на кафедре '" + deptName + "':");
        if (deptCourses.isEmpty()) {
            System.out.println("Нет курсов на этой кафедре.");
        } else {
            for (Course course : deptCourses) {
                System.out.println("- " + course.getCourseName());
            }
        }
    }
}