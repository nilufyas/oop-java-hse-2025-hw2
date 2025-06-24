public class Main {
    public static void main(String[] args) {
        try {
            // Создаем преподавателей
            Professor prof1 = new Professor("Иван Викторович", 1001, "Компьютерные науки");
            Professor prof2 = new Professor("Алла Ивановна", 1002, "Филология");

            // Создаем курсы с ограниченным количеством мест и очередью
            Course course1 = new Course("Введение в программирование", prof1, 2, 1); // максимум 2 студента, очередь до 1
            Course course2 = new Course("Финский язык", prof2, 1, 0);               // только основной список

            // Создаем студентов
            Student s1 = new Student("Дмитрий", 2001, "ПМИ");
            Student s2 = new Student("Дарья", 2002, "Экономика");
            Student s3 = new Student("Диана", 2003, "Менеджмент");

            // Создаем аспиранта
            GraduateStudent gradStudent = new GraduateStudent("Алексей", 2004, "Искусственный интеллект", "Обучение с подкреплением");

            // Регистрируем студентов и аспиранта в университете
            University university = new University();
            university.registerStudent(s1);
            university.registerStudent(s2);
            university.registerStudent(s3);
            university.registerStudent(gradStudent);

            // Добавляем студентов на курс
            try {
                course1.addStudent(s1);
                course1.addStudent(s2); // добавится в основной список
                course1.addStudent(s3); // попадёт в очередь ожидания
            } catch (CourseFullException e) {
                System.out.println("\nОшибка при добавлении: " + e.getMessage());
            }

            // Пробуем добавить ещё одного студента → очередь заполнена
            try {
                Student s4 = new Student("Екатерина", 2005, "ПМИ");
                course1.addStudent(s4); // ← должно вызвать CourseFullException
            } catch (CourseFullException e) {
                System.out.println("\nОшибка при добавлении студента: " + e.getMessage());
            }

            // Удаляем студента → очередь обрабатывается автоматически
            course1.removeStudent(s2);

            // Публикуем объявления для курса
            course1.publish("Лекция перенесена на 10:00");
            course1.publish("Домашнее задание опубликовано");

            // Проверяем ленту курса
            System.out.println("\n--- Лента курса ---");
            for (String message : course1.getFeed()) {
                System.out.println("- " + message);
            }

            // Выводим информацию о курсе
            course1.showCourseDetails();

            // Ищем студента по ID
            try {
                Student found = university.findStudentById(2001);
                System.out.println("\nСтудент найден: " + found.getDetails());
            } catch (StudentNotFoundException e) {
                System.out.println(e.getMessage());
            }

            // Пример ошибки: поиск несуществующего студента
            try {
                Student notFound = university.findStudentById(9999);
            } catch (StudentNotFoundException e) {
                System.out.println(e.getMessage());
            }

            // Поиск аспиранта по ID
            try {
                Student foundGrad = university.findStudentById(2004);
                System.out.println("\nНайден аспирант: " + foundGrad.getDetails());
            } catch (StudentNotFoundException e) {
                System.out.println(e.getMessage());
            }

            // Группировка курсов по кафедрам
            university.addCourseToDept("Компьютерные науки", course1);
            university.addCourseToDept("Филология", course2);

            // Вывод всех курсов по кафедре
            university.printCoursesByDepartment("Компьютерные науки");
            university.printCoursesByDepartment("Филология");

            // Использование класса Department
            Department csDept = new Department("Компьютерные науки", prof1);
            csDept.addCourse(course1);

            Department philologyDept = new Department("Филология", prof2);
            philologyDept.addCourse(course2);

            philologyDept.removeCourse(course2);

            System.out.println("\n--- Информация о кафедрах ---");
            csDept.showDepartmentInfo();
            philologyDept.showDepartmentInfo();

            // Планирование событий через Schedulable

            // Планируем события для курса
            course1.scheduleEvent("Лекция по Java", "2025-03-20 10:00");
            course1.scheduleEvent("Практика по ООП", "2025-03-21 12:00");

            // Планируем события для преподавателя
            prof1.scheduleEvent("Лекция по Java", "2025-03-20 10:00");
            prof1.scheduleEvent("Консультация", "2025-03-22 14:00");

            // Вывод расписания курса
            System.out.println("\n--- Расписание курса ---");
            for (Event event : course1.getSchedule()) {
                System.out.println(event);
            }

            // Вывод расписания преподавателя
            System.out.println("\n--- Расписание преподавателя ---");
            prof1.showSchedule();

        } catch (InvalidCourseException e) {
            System.out.println("Ошибка при создании курса: " + e.getMessage());
        }
    }
}