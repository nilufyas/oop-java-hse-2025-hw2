public class Event {
    private String description;
    private String dateTime;

    /**
     * Конструктор события
     * @param description Описание события
     * @param dateTime Дата и время
     */
    public Event(String description, String dateTime) {
        this.description = description;
        this.dateTime = dateTime;
    }

    /**
     * Возвращает описание события
     * @return Описание
     */
    public String getDescription() {
        return description;
    }

    /**
     * Возвращает дату и время события
     * @return Дата и время
     */
    public String getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return description + " (" + dateTime + ")";
    }
}