import java.util.LinkedList;
import java.util.List;

public class Professor extends UniversityMember {
    private String department;
    private LinkedList<Event> schedule = new LinkedList<>();

    public Professor(String name, int id, String department) {
        super(name, id);
        this.department = department;
    }

    @Override
    public String getDetails() {
        return "ID преподавателя: " + id + ", Имя: " + name + ", кафедра: " + department;
    }
    public void scheduleEvent(String description, String dateTime) {
        schedule.add(new Event(description, dateTime));
    }

    public List<Event> getSchedule() {
        return schedule;
    }
}
