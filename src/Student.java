public class Student extends UniversityMember {
    private String major;

    /**
     * Конструктор студента
     * @param name Имя
     * @param id ID
     * @param major Специальность
     */
    public Student(String name, int id, String major) {
        super(name, id);
        this.major = major;
    }

    /**
     * Возвращает специальность студента
     * @return Специальность
     */
    public String getMajor() {
        return major;
    }

    /**
     * Возвращает информацию о студенте
     * @return Строка с информацией
     */
    @Override
    public String getDetails() {
        return "ID студента: " + id + ", Имя: " + name + ", специальность: " + major;
    }
}