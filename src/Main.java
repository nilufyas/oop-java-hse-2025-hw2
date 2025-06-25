public class Main {
    public static void main(String[] args) {
        try {
            // 1. Создаём преподавателей
            Professor prof1 = new Professor(
                    "Иван Викторович к.ф.м.н.",
                    1001,
                    "Компьютерные науки"
            );
            Professor prof2 = new Professor(
                    "Алла Ивановна к.ф.н.",
                    1002,
                    "Филология"
            );

            // 2. Создаём курсы с ограничением по maxStudents
            Course course1 = new Course(
                    "Введение в программирование",
                    prof1,
                    2
            );
            Course course2 = new Course(
                    "Финский язык",
                    prof2,
                    3
            );

            // 3. Создаём студентов
            Student s1 = new Student("Дмитрий", 2001, "ПМИ");
            Student s2 = new Student("Дарья",   2002, "Экономика");
            Student s3 = new Student("Диана",   2003, "Менеджмент");

            // 4. Регистрируем студентов
            University uni = new University();
            uni.registerStudent(s1);
            uni.registerStudent(s2);
            uni.registerStudent(s3);

            // 5. Записываем на курсы (последний уходит в очередь)
            course1.addStudent(s1);
            course1.addStudent(s2);
            course1.addStudent(s3);
            course2.addStudent(s1);

            // 6. Добавляем курсы в университет
            uni.addCourse(course1);
            uni.addCourse(course2);

            // 7. Публикуем объявления и планируем события
            course1.publish("Первая лекция: 01.09, аудитория 101");
            course1.publish("Домашнее задание 1 выложено в LMS");
            course1.scheduleEvent("Лекция: Основы ООП", "2025-09-01 10:00");
            prof1.scheduleEvent("Приём студентов", "2025-08-28 14:00");

            // 8. Группировка курсов по кафедре
            uni.addCourseToDept("Компьютерные науки", course1);
            uni.addCourseToDept("Компьютерные науки", course2);

            // 9. Выводим текущее состояние
            System.out.println("\n=== Все курсы университета ===");
            uni.showAllCourses();

            System.out.println("\n=== Курсы кафедры «Компьютерные науки» ===");
            uni.getCoursesForDept("Компьютерные науки").forEach(c ->
                    System.out.println(" - "
                            + c.getNumberOfStudents() + "/"
                            + c.getMaxStudents() + " в "
                            + c.getCourseName())
            );

            // 10. Демонстрация очереди: удаляем Дарью
            System.out.println("\n--- После удаления Дарьи из course1 ---");
            course1.removeStudent(s2);
            uni.showAllCourses();

        } catch (InvalidCourseException e) {
            System.err.println("Ошибка при создании курса: " + e.getMessage());
        } catch (CourseFullException e) {
            System.err.println("Невозможно добавить студента: " + e.getMessage());
        }
    }
}