public class UniversityMember implements Person {
    protected String name;
    protected int id;

    /**
     * Конструктор члена университета
     * @param name Имя
     * @param id ID
     */
    public UniversityMember(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Возвращает информацию о члене университета
     * @return Строка с информацией
     */
    @Override
    public String getDetails() {
        return "Человек из университета";
    }

    /**
     * Возвращает ID
     * @return ID
     */
    public int getId() {
        return id;
    }
}