public class Main {
    public static void main(String[] args) {
        try {
            Professor prof1 = new Professor("Иван Викторович к.ф.м.н.", 1001, "Компьютерные науки");
            Professor prof2 = new Professor("Алла Ивановна к.ф.н.", 1002, "Филология");

            Course course1 = new Course("Введение в программирование", prof1);
            Course course2 = new Course("Финский язык", prof2);

            Student s1 = new Student("Дмитрий", 2001, "ПМИ");
            Student s2 = new Student("Дарья", 2002, "Экономика");
            Student s3 = new Student("Диана", 2003, "Менеджмент");

            // 1. Очередь ожидания
            course1.addStudent(s1);
            course1.addStudent(s2);
            course1.addStudent(s3); // в очередь

            System.out.println("Waiting list size до: " + course1.getWaitingListSize());
            course1.processWaitingList(); // мест нет — никто не зачислен
            System.out.println("Waiting list size после: " + course1.getWaitingListSize());

            // 2. Лента объявлений
            course1.publish("Занятие перенесено на пятницу");
            course1.publish("Выложены материалы по 3-й теме");

            System.out.println("\nЛента объявлений по курсу:");
            for (String msg : course1.getFeed()) {
                System.out.println(" - " + msg);
            }

            // 3. Справочник студентов
            University university = new University();
            university.registerStudent(s1);
            university.registerStudent(s2);

            try {
                Student found = university.findStudentById(2001);
                System.out.println("\nНайден студент: " + found.getName());
                university.findStudentById(9999); // не существует
            } catch (StudentNotFoundException e) {
                System.out.println("Ошибка поиска студента: " + e.getMessage());
            }

            // 4. Курсы по кафедрам
            university.addCourseToDept("Программирование", course1);
            university.addCourseToDept("Языки", course2);

            System.out.println("\nКурсы на кафедре Языки:");
            for (Course c : university.getCoursesForDept("Языки")) {
                System.out.println(" - " + c.getCourseName());
            }

            // 5. GraduateStudent
            GraduateStudent gs = new GraduateStudent("Андрей", 3001, "Логистика", "Оптимизация поставок");
            System.out.println("\nВыпускник: " + gs.getDetails());

            // 6. Планировщик событий
            course1.scheduleEvent("Контрольная работа", "2025-07-01 12:00");
            prof1.scheduleEvent("Курсовая работа", "2025-06-28 10:00");

            System.out.println("\nСобытия курса:");
            for (Event e : course1.getSchedule()) {
                System.out.println(e.getDescription() + " в " + e.getDateTime());
            }

            System.out.println("\nСобытия профессора:");
            for (Event e : prof1.getSchedule()) {
                System.out.println(e.getDescription() + " в " + e.getDateTime());
            }

            // 7. CourseFullException
            Course tinyCourse = new Course("Ограниченный курс", prof1);
            tinyCourse.addStudent(s1);
            tinyCourse.addStudent(s2); // в очередь
            tinyCourse.addStudent(s3); // выбросит исключение

        } catch (InvalidCourseException e) {
            System.out.println("Ошибка при создании курса: " + e.getMessage());
        } catch (CourseFullException e) {
            System.out.println("Ошибка при добавлении студента: " + e.getMessage());
        }
    }
}
