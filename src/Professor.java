import java.util.LinkedList;
import java.util.List;

public class Professor extends UniversityMember implements Person, Schedulable {
    private String department;
    private LinkedList<Event> schedule;

    public Professor(String name, int id, String department) {
        super(name, id);
        this.department = department;
        this.schedule = new LinkedList<>();
    }

    @Override
    public String getDetails() {
        return "ID преподавателя: " + id + ", Имя: " + name + ", кафедра: " + department;
    }

    // --- Методы из Schedulable ---
    @Override
    public void scheduleEvent(String description, String dateTime) {
        schedule.add(new Event(description, dateTime));
    }

    @Override
    public List<Event> getSchedule() {
        return new LinkedList<>(schedule);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void showSchedule() {
        System.out.println("\nРасписание преподавателя " + name + ":");
        if (schedule.isEmpty()) {
            System.out.println("Нет запланированных событий.");
        } else {
            for (Event event : schedule) {
                System.out.println("- " + event.getDescription() + " (" + event.getDateTime() + ")");
            }
        }
    }
}