public class GraduateStudent extends Student {
    private String thesisTitle;

    /**
     * Конструктор аспиранта
     * @param name Имя
     * @param id ID
     * @param major Специальность
     * @param thesisTitle Тема диссертации
     */
    public GraduateStudent(String name, int id, String major, String thesisTitle) {
        super(name, id, major);
        this.thesisTitle = thesisTitle;
    }

    /**
     * Возвращает тему диссертации
     * @return Тема диссертации
     */
    public String getThesisTitle() {
        return thesisTitle;
    }

    /**
     * Возвращает информацию об аспиранте
     * @return Строка с информацией
     */
    @Override
    public String getDetails() {
        return "ID аспиранта: " + id + ", Имя: " + name + ", специальность: " + getMajor() + ", тема диссертации: " + thesisTitle;
    }
}