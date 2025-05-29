//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Professor prof1 = new Professor("Иван Викторович к.ф.м.н.", 1001, "Компьютерные науки");
            Professor prof2 = new Professor("Алла Ивановна к.ф.н.", 1002, "Филология");

            Course course1 = new Course("Введение в программирование", prof1);
            Course course2 = new Course("Финский язык", prof2);

//  тестируем, что ошибка правильно выбрасывается в случае пустого курса:
//            Course course3 = new Course("", prof2);
//            String newCourseName = null;
//            Course course4 = new Course(newCourseName, prof2);

            Student s1 = new Student("Дмитрий", 2001, "ПМИ");
            Student s2 = new Student("Дарья", 2002, "Экономика");
            Student s3 = new Student("Диана", 2003, "Менеджмент");

            course1.addStudent(s1);
            course1.addStudent(s3);

            course2.addStudent(s2);
            course2.addStudent(s3);

            University university = new University();
            university.addCourse(course1);
            university.addCourse(course2);

            university.showAllCourses();

        } catch (InvalidCourseException e) {
            System.out.println("Ошибка при создании курса: " + e.getMessage());
        }
    }
}