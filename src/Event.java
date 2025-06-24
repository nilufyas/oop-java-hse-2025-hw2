import java.util.Objects;

public class Event {
    private String description;
    private String dateTime;

    public Event(String description, String dateTime) {
        this.description = description;
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public String getDateTime() {
        return dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(description, event.description) &&
                Objects.equals(dateTime, event.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, dateTime);
    }

    @Override
    public String toString() {
        return "Event{" +
                "description='" + description + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}