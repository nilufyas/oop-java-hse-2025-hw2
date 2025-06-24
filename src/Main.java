public class Main {
    public static void main(String[] args) {
        try {
            // Создаем преподавателей
            Professor prof1 = new Professor("Иван Викторович к.ф.м.н.", 1001, "Компьютерные науки");
            Professor prof2 = new Professor("Алла Ивановна к.ф.н.", 1002, "Филология");

            // Создаем курсы с максимальной вместимостью
            Course course1 = new Course("Введение в программирование", prof1, 2);
            Course course2 = new Course("Финский язык", prof2, 2);

            // Тестируем исключение InvalidCourseException
            // Course course3 = new Course("", prof2); // Выбросит исключение

            // Создаем студентов и аспиранта
            Student s1 = new Student("Дмитрий", 2001, "ПМИ");
            Student s2 = new Student("Дарья", 2002, "Экономика");
            Student s3 = new Student("Диана", 2003, "Менеджмент");
            GraduateStudent s4 = new GraduateStudent("Егор", 2004, "ПМИ", "ИИ в обработке данных");

            // Создаем университет
            University university = new University();

            // Регистрируем студентов
            university.registerStudent(s1);
            university.registerStudent(s2);
            university.registerStudent(s3);
            university.registerStudent(s4);

            // Добавляем студентов на курсы
            course1.addStudent(s1);
            course1.addStudent(s3);
            // Следующий студент попадет в очередь
            course1.addStudent(s4); // В очередь ожидания
            // Тестируем CourseFullException
            // course1.addStudent(s2); // Выбросит исключение, так как курс и очередь полны

            course2.addStudent(s2);
            course2.addStudent(s3);

            // Обрабатываем очередь ожидания
            course1.removeStudent(s1);
            course1.processWaitingList();

            // Публикуем объявления
            course1.publish("Лекция перенесена на пятницу");
            course2.publish("Контрольная работа на следующей неделе");

            // Планируем события
            course1.scheduleEvent("Лекция по Java", "2025-06-25 10:00");
            prof1.scheduleEvent("Консультация", "2025-06-26 14:00");

            // Создаем кафедру
            Department compSciDept = new Department("Компьютерные науки", prof1);
            compSciDept.addCourse(course1);

            // Группируем курсы по кафедрам
            university.addCourseToDept("Компьютерные науки", course1);
            university.addCourseToDept("Филология", course2);

            // Добавляем курсы в университет
            university.addCourse(course1);
            university.addCourse(course2);

            // Выводим информацию
            System.out.println("=== Все курсы университета ===");
            university.showAllCourses();

            System.out.println("=== Курсы кафедры Компьютерные науки ===");
            for (Course c : university.getCoursesForDept("Компьютерные науки")) {
                c.showCourseDetails();
            }

            System.out.println("=== Объявления курса 1 ===");
            for (String message : course1.getFeed()) {
                System.out.println("- " + message);
            }

            System.out.println("=== Расписание курса 1 ===");
            for (Event event : course1.getSchedule()) {
                System.out.println("- " + event);
            }

            System.out.println("=== Расписание преподавателя ===");
            for (Event event : prof1.getSchedule()) {
                System.out.println("- " + event);
            }

            System.out.println("=== Поиск студента ===");
            Student found = university.findStudentById(2004);
            System.out.println("Найден студент: " + found.getDetails());

            // Тестируем StudentNotFoundException
            // university.findStudentById(9999); // Выбросит исключение

        } catch (InvalidCourseException e) {
            System.out.println("Ошибка при создании курса: " + e.getMessage());
        } catch (CourseFullException e) {
            System.out.println("Ошибка при добавлении студента: " + e.getMessage());
        } catch (StudentNotFoundException e) {
            System.out.println("Ошибка при поиске студента: " + e.getMessage());
        }
    }
}