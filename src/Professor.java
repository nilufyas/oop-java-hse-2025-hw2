import java.util.LinkedList;
import java.util.List;

public class Professor extends UniversityMember implements Schedulable {
    private String department;
    private LinkedList<Event> schedule;

    /**
     * Конструктор преподавателя
     * @param name Имя
     * @param id ID
     * @param department Кафедра
     */
    public Professor(String name, int id, String department) {
        super(name, id);
        this.department = department;
        this.schedule = new LinkedList<>();
    }

    /**
     * Возвращает информацию о преподавателе
     * @return Строка с информацией
     */
    @Override
    public String getDetails() {
        return "ID преподавателя: " + id + ", Имя: " + name + ", кафедра: " + department;
    }

    /**
     * Планирует событие для преподавателя
     * @param description Описание события
     * @param dateTime Дата и время
     */
    @Override
    public void scheduleEvent(String description, String dateTime) {
        schedule.add(new Event(description, dateTime));
    }

    /**
     * Возвращает расписание преподавателя
     * @return Список событий
     */
    @Override
    public List<Event> getSchedule() {
        return schedule;
    }
}